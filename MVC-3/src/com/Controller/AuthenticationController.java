package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DTO.UserDTO;
import com.Entity.User;
import com.Service.UserService;

@Controller
public class AuthenticationController {

	// 100
	/*
	 * @RequestMapping(value = "/log") public String
	 * getLogRequest(@RequestParam("un") String username, @RequestParam("ps") String
	 * passowrd) { System.out.println(username + " " + passowrd);
	 * System.out.println("This is Backend Login Method"); return "Success"; }
	 */

	/*
	 * @RequestMapping(value = "/log") public String
	 * getLogRequestData(@ModelAttribute LoginCred loginDetails) {
	 * System.out.println(loginDetails);
	 * System.out.println("This is Backend Login Method"); return "Success"; }
	 */

	@Autowired
	private UserService us;

	@RequestMapping(value = "/reg")
	public String SignUp(@ModelAttribute User user) {
		System.out.println("I am in Controller layer");
		us.Register(user);
		
		return "login";

	}
	
	
	
//	@ExceptionHandler(value = NullPointerException.class)
//	public String handleNullpointerException(Model model)
//	{
//		System.out.println("Nullpointer Excaption handles here");
//		model.addAttribute("msg", "Nullpointerexception occures");
//		return "error";
//	}
	
	
	
	@RequestMapping(value = "/log")
	public String SignIn(@RequestParam("uname") String un , @RequestParam("upassword") String ps , Model model)
	{
		  System.out.println("I am in Controller layer " + un + " " + ps);
		  
		  UserDTO udto = us.login(un , ps);
		  
		  String userdata  = null;
		  
		  System.out.println(userdata.toLowerCase());
		  
		  model.addAttribute("data", udto);
		  
		  return "login";
	}
	
	@RequestMapping("/logAdmin")
	public String SignInAdmin(@RequestParam("uname") String un , @RequestParam("upassword") String ps , Model model)
	{
		 System.out.println("I am in Controller layer " + un + " " + ps);
		 
		 List<User> allUsers = us.loginAdmin(un , ps);
		 
		 model.addAttribute("msg", allUsers);
		 
		 return "Success";
		 
		
	}
	
	@RequestMapping(value = "/del")
	public String deleteUser(@RequestParam("uid") int uid,Model model) {
		
		System.out.println("I am in Contoller layer" + uid);
		
		List<User> allUsers = us.deleteUserById(uid);
		
		model.addAttribute("msg", allUsers);
		
		return "Success";
		
	}
	
	
	

}
