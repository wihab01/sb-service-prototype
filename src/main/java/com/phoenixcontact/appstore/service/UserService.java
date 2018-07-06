package com.phoenixcontact.appstore.service;

import java.util.List;

import com.phoenixcontact.appstore.domain.App;
import com.phoenixcontact.appstore.domain.User;

public interface UserService {
	
	 Iterable<User> listAllUsers();

	 User getUserById(String uUID);

	 User saveUser(User user);

	 void deleteUser(String uUID);
	    
	 boolean existsUserById(String uUID);
	    

}
