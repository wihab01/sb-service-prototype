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
import org.springframework.web.bind.annotation.RestController;

import com.phoenixcontact.appstore.domain.User;
import com.phoenixcontact.appstore.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/users")
@Api(value="onlinestore", description="Operations pertaining to user in Application Store")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Search an user by UUID",response = User.class)
    @RequestMapping(value = "/{uuid}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> showUser(@PathVariable String uuid, Model model){
    	User storedUser = userService.getUserById(uuid);
    	if (storedUser == null) {
    		return new ResponseEntity<String>("User with UUID = " + uuid + " not found", HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<User>(storedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Add an user")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public User saveUser(@Valid @RequestBody User user){
        User newUser = userService.saveUser(user);
        return newUser;
    }

    @ApiOperation(value = "Update an user")
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateUser(@PathVariable String uuid , @Valid @RequestBody User user){
        User storedUser = userService.getUserById(uuid);
    	if (storedUser == null) {
    		return new ResponseEntity<String>("User with UUID = " + uuid + " not found", HttpStatus.NOT_FOUND);
    	} else {
    		storedUser.setFirstName(user.getFirstName());
    		storedUser.setLastName(user.getLastName());
    		storedUser.setEmail(user.getEmail());
    		storedUser.setActive(user.isActive());
	        storedUser.setCompany(user.getCompany());
	    	storedUser.setGeneralTaCAccepted(user.isGeneralTaCAccepted());
	    	storedUser.setDeveloperTaCAccepted(user.isDeveloperTaCAccepted());
	    	storedUser.setGeneralInfo(user.getGeneralInfo());
	    	storedUser.setCreatedAt(user.getCreatedAt());
	    	//storedUser.setUserName(user.getUserName());
	    	storedUser.setPcLoginToken(user.getPcLoginToken());
	    	userService.saveUser(storedUser);
        }
        return new ResponseEntity<User>(storedUser, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an user")
    @RequestMapping(value="/{uuid}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable String uuid){
    	if (!userService.existsUserById(uuid)) {
    		return new ResponseEntity<String>("User with UUID =" + uuid + " not found", HttpStatus.NOT_FOUND);
    	}
        userService.deleteUser(uuid);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available users",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "", method= RequestMethod.GET, produces = "application/json")
    public Iterable<User> list(Model model){
        Iterable<User> list = userService.listAllUsers();
        return list;
    }
 
}
