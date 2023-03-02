package br.com.karin.jdbc.modelo;

public class Category {
	
	private Integer id;
	private String name;
	
	public Category(String name) {
		this.name = name;
	};
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	private Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Cateogry info: %d, %s", 
				this.getId(), this.getName());
	}

	
	
	

}
