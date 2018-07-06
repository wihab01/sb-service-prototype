package com.phoenixcontact.appstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenixcontact.appstore.domain.User;
import com.phoenixcontact.appstore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserRepository userRepository;
    
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public Iterable<User> listAllUsers() {
	    logger.debug("listAllUsers called");
        return userRepository.findAll();
	}

	@Override
	public User getUserById(String uUID) {
        logger.debug("getUserById called");
        return userRepository.findById(uUID).orElse(null);
	}

	@Override
	public User saveUser(User user) {
		   logger.debug("saveUser called");
	        return userRepository.save(user);
	}

	@Override
	public void deleteUser(String uUID) {
		   logger.debug("deleteUser called");
	        userRepository.deleteById(uUID);
		
	}

	@Override
	public boolean existsUserById(String uUID) {
		logger.debug("existUserById called");
       return userRepository.existsById(uUID);
	}


}
