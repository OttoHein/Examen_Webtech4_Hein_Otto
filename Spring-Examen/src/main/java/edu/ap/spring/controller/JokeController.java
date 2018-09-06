package edu.ap.spring.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {
   }
       
   @RequestMapping("/joke")
   @ResponseBody
   public String joke() {
	   StringBuilder builder = new StringBuilder();
	   
	   builder.append("<html><body><h1>Get a joke</h1>" + ""
	   		+ "<form action='joke_post' method ='POST'>\r\n" + 
	   		"  First name:<br>\r\n" + 
	   		"  <input type=\"text\" name=\"firstname\"><br>\r\n" + 
	   		"  Last name:<br>\r\n" + 
	   		"  <input type=\"text\" name=\"lastname\">\r\n" +
	   		"  <input type=\"submit\" value=\"Submit\">" +
	   		"  </form></body></html>");
	   
	   return builder.toString();
   }
		   
   @RequestMapping("/joke_post")
   @ResponseBody
   public String joke_post(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
	   return "";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
