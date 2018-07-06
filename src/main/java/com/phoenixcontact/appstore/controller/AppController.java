package com.phoenixcontact.appstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.phoenixcontact.appstore.domain.App;
import com.phoenixcontact.appstore.service.AppService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/apps")
@Api(value="onlinestore", description="Operations pertaining to app in Application Store")
public class AppController {

    private AppService appService;

    @Autowired
    public void setAppService(AppService appService) {
        this.appService = appService;
    }

//    @ApiOperation(value = "View a list of available apps",response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
/*   @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    public Iterable<App> list(Model model){
        Iterable<App> appList = appService.listAllApps();
        return appList;
    }*/

    @ApiOperation(value = "Search an app by ID",response = App.class)
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> showApp(@PathVariable Long id, Model model){
    	App storedApp = appService.getAppById(id);
    	if (storedApp == null) {
    		return new ResponseEntity<String>("App with id=" + id + " not found", HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<App>(storedApp, HttpStatus.OK);
    }

    @ApiOperation(value = "Search an app by a set of values", response = App.class)
    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Iterable<App> searchApp(@RequestParam(value = "name", required = false) String name, 
    		@RequestParam(value = "rating", required = false) Integer rating) { 
    	Iterable<App> appList = appService.findApps(name, rating);
        return appList;
    }
    
    @ApiOperation(value = "Add an app")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public App saveApp(@Valid @RequestBody App app){
    	//app.setLastUpdated(new Date());
        App newApp = appService.saveApp(app);
        return newApp;
        //return new ResponseEntity("App saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update an app")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateApp(@PathVariable Long id, @Valid @RequestBody App app){
        App storedApp = appService.getAppById(id);
    	if (storedApp == null) {
    		return new ResponseEntity<String>("App with id=" + id + " not found", HttpStatus.NOT_FOUND);
    	} else {
	        storedApp.setDescription(app.getDescription());
	        storedApp.setIconUrl(app.getIconUrl());
	        storedApp.setPrice(app.getPrice());
	        storedApp.setActive(app.isActive());
	        storedApp.setVersion(app.getVersion());
	    	//storedApp.setLastUpdated(new Date());
	        appService.saveApp(storedApp);
        }
        return new ResponseEntity<App>(storedApp, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a app")
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable Long id){
    	if (!appService.existsAppById(id)) {
    		return new ResponseEntity<String>("App with id=" + id + " not found", HttpStatus.NOT_FOUND);
    	}
        appService.deleteApp(id);
        return new ResponseEntity<String>("App deleted successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Search a list by list name")
    @RequestMapping(value = "/list/{listName}", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Iterable<App> searchAppByList(@PathVariable String listName) {
    	Iterable<App> appList = null;
    	switch(listName) {
    	case "PromotedApps":
    		appList = appService.findAllApps();
    		break;
    	}
        return appList;
    }
    
    
    
}
