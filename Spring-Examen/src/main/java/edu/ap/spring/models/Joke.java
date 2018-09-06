package edu.ap.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Joke {
	
	@Column
	private String type;
	
	@Column
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