package br.com.karin.jdbc.modelo;

public class Product {

	private Integer id;
	private String name;
	private String description;

	public Product(String name, String description) {
		
		this.name = name;
		this.description = description;
	}
	
	public Product(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return String.format("Product info: %d, %s, %s", 
				this.getId(), this.getName(), this.getDescription());
	}
	
	
	

}
