package edu.ap.spring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	   
	   URL url;
	   String joke = new String();
	try {
		url = new URL("http://api.icndb.com/jokes/random?firstName=" + firstname + "&lastName=" + lastname);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				in.close();
				
		joke =content.toString();
				
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   StringBuilder builder = new StringBuilder();
	   
	   builder.append("<html><body><p>");
	   builder.append(joke);
	   builder.append("</p></body></html>");
	   
	   return builder.toString();
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
