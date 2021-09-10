package com.tech.app.ws.ui.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tech.app.ws.ui.model.response.UserRest;
import com.tech.app.ws.ui.services.UserService;
import com.tech.app.ws.utilities.Utils;

@Service
public class UserServicesImpl implements UserService {
  Map<String, UserRest> users;
  
  Utils util;
  
  public UserServicesImpl() {}
  
  @Autowired
  public UserServicesImpl(Utils util) {
	  this.util = util;
  }
  
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		// TODO Auto-generated method stub
       UserRest returnValue = new UserRest();
		
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		
		String userId = util.generateUserId();
		returnValue.setUserId(userId);
		
		if(users==null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return returnValue;
	}

}
