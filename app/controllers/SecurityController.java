package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class SecurityController extends Controller{
	@Before(only={"StudentController.findById","StudentController.findByIdAndName"})
	static void checkAuthentification() {
	System.out.println("----------Check authentication-------"); String oauthToken = params.get("oauth_token");
	if(oauthToken==null){
	//renderJSON("{\"error\":\"ouath token is empty\"}");
	} 
	}
}
