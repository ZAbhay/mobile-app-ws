package com.tech.app.ws.ui.controller;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.tech.app.ws.ui.model.request.UserDetailsRequestModel;
import com.tech.app.ws.ui.model.response.UserRest;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("users")
public class UserController {

	Map<String, UserRest> users;
	
	@GetMapping
	public String getUser(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="50") int limit,
			@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		return "get user was called with page = "+page +" and limit = "+limit +" and sort= "+sort;
	}
	
	
	@GetMapping(path="/{userId}",
			produces =  {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
//		UserRest returnValue = new UserRest();
//		
//		returnValue.setEmail("test@test.com");
//		returnValue.setFirstName("Abhay");
//		returnValue.setLastName("Singh");
//		returnValue.setUserId("1234");
		
		if(users.containsKey(userId))
		{
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK) ;
		}
		
		return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT) ;
	}
	
	@PostMapping(consumes =   {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE},
			produces =  {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Validated @RequestBody UserDetailsRequestModel userDetails) {
        
		UserRest returnValue = new UserRest();
		
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		
		if(users==null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK) ;
	}
	
	@PutMapping(path="/{userId}",
			consumes =   {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE},
			produces =  {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel userDetails) {
		
		if(users.containsKey(userId))
		{
			UserRest returnValue = users.get(userId);
			returnValue.setFirstName(userDetails.getFirstName());
			returnValue.setLastName(userDetails.getLastName());
			
			users.put(userId, returnValue);
			
			return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
		}
		
		return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		
		if (users.containsKey(userId)) 
		{
			users.remove(userId);
		    return ResponseEntity.noContent().build();
	     }
		
		return ResponseEntity.badRequest().build();
}
}