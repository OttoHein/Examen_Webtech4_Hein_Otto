package edu.ap.spring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ap.spring.jpa.JokeRepository;
import edu.ap.spring.models.Joke;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {
   }
   
   private JokeRepository repository;
   
   @Autowired
	public void setUserRepository(JokeRepository repository) {
		this.repository = repository;
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
	   String result = new String();
	   ObjectMapper objectMapper = new ObjectMapper();
	   Joke joke = new Joke();
	   
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
				
		result = content.toString();
		
				
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		try {
			joke = objectMapper.readValue(result, Joke.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		if(repository.findAll() != null) {
			repository.save(joke);
		}
		
	   StringBuilder builder = new StringBuilder();
	   
	   builder.append("<html><body><h1>Here's your bad joke:</h1><p>");
	   builder.append(joke.getValue().getJoke());
	   builder.append("</p></body></html>");
	   
	   return builder.toString();
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
