package edu.ap.spring.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Joke {
	
	static int idteller = 0;
	
	@Id
    private Long Id;
	
	@Column
	private String type;
	
	@Embedded
	private JokeValue value;
	
	public Joke() {
		super();
		idteller +=1;
		this.Id = (long) idteller;
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