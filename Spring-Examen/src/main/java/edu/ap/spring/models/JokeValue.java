package edu.ap.spring.models;

public class JokeValue {
	private String Id;
	private String Joke;
	private String[] Categories;
	
	public JokeValue() {
		super();
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
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