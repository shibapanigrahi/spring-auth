package com.authorization.rest.controller;

import org.json.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserAuthController 
{

    
    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public String addNumber( 
    		@RequestBody String jsonBody)  throws Exception {       

    	JSONObject obj = new JSONObject(jsonBody);
    	Integer Sum = 0;
    	try {
    		Integer x = Integer.parseInt((String) obj.get("x"));
	    	Integer y = Integer.parseInt((String) obj.get("y"));
	    	Sum = x + y;
    	} catch(ClassCastException e) {
    		throw new Exception("Pass number with string format!");
    	}
    	
    	JSONObject result = new JSONObject();
    	result.put("result", Sum);
    	return result.toString();
    }
 
    @PostMapping(path= "/diff", consumes = "application/json", produces = "application/json")
    public String subtractNumber( @RequestBody String jsonBody)  throws Exception {       

    	JSONObject obj = new JSONObject(jsonBody);
    	Integer Sum = 0;
    	try {
	    	Integer x = Integer.parseInt((String) obj.get("x"));
	    	Integer y = Integer.parseInt((String) obj.get("y"));
	    	Sum = x - y;
    	} catch(ClassCastException e) {
    		throw new Exception("Pass number with string format!");
    	}
    	
    	JSONObject result = new JSONObject();
    	result.put("result", Sum);
    	return result.toString();
    }
}
