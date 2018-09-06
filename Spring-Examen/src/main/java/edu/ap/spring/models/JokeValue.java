package edu.ap.spring.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Embeddable
public class JokeValue {
	
	@Id
	private Long Id;
	
	@Column
	private String Joke;
	
	@Column
	private String[] Categories;
	
	public JokeValue() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getJoke() {
		return Joke;
	}

	public void setJoke(String joke) {
		Joke = joke;
	}

	public String[] getCategories() {
		return Categories;
	}

	public void setCategories(String[] categories) {
		Categories = categories;
	}
	
	
}