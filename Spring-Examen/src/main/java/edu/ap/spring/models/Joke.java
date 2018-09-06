package edu.ap.spring.models;

public class Joke {
	private String type;
	private JokeValue value;
	
	public Joke() {
		super();
	}


	
	public JokeValue getValue() {
		return value;
	}



	public void setValue(JokeValue value) {
		this.value = value;
	}



	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


}