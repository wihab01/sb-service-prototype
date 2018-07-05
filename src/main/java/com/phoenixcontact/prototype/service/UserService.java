package com.phoenixcontact.prototype.service;

import java.util.List;

import com.phoenixcontact.prototype.domain.App;
import com.phoenixcontact.prototype.domain.User;

public interface UserService {
	
	 Iterable<User> listAllUsers();

	 User getUserById(String uUID);

	 User saveUser(User user);

	 void deleteUser(String uUID);
	    
	 boolean existsUserById(String uUID);
	    

}
