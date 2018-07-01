package com.phoenixcontact.prototype.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.phoenixcontact.prototype.domain.App;
import com.phoenixcontact.prototype.service.AppService;

@RestController
@RequestMapping("/api/apps")
@Api(value="onlinestore", description="Operations pertaining to app in Application Store")
public class AppController {

    private AppService appService;

    @Autowired
    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @ApiOperation(value = "View a list of available apps",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "", method= RequestMethod.GET, produces = "application/json")
    public Iterable<App> list(Model model){
        Iterable<App> appList = appService.listAllApps();
        return appList;
    }
    @ApiOperation(value = "Search an app by ID",response = App.class)
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity showApp(@PathVariable Long id, Model model){
    	App storedApp = appService.getAppById(id);
    	if (storedApp == null) {
    		return new ResponseEntity<String>("App with id=" + id + " not found", HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<App>(storedApp, HttpStatus.OK);
    }

    @ApiOperation(value = "Add an app")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public App saveApp(@Valid @RequestBody App app){
        App newApp = appService.saveApp(app);
        return newApp;
        //return new ResponseEntity("App saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update an app")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateApp(@PathVariable Long id, @RequestBody App app){
        App storedApp = appService.getAppById(id);
    	if (storedApp == null) {
    		return new ResponseEntity<String>("App with id=" + id + " not found", HttpStatus.NOT_FOUND);
    	} else {
	        storedApp.setDescription(app.getDescription());
	        storedApp.setIconUrl(app.getIconUrl());
	        storedApp.setPrice(app.getPrice());
	        storedApp.setActive(app.isActive());
	        storedApp.setVersion(app.getVersion());
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

}
