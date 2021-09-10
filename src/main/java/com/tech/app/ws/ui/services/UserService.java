package com.tech.app.ws.ui.services;

import com.tech.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tech.app.ws.ui.model.response.UserRest;

public interface UserService {

	
	UserRest createUser(UserDetailsRequestModel userDetails);

}
