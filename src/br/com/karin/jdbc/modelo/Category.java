package br.com.karin.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private Integer id;
	private String name;
	private List<Product> products = new ArrayList<Product>();
	
	public Category(String name) {
		this.name = name;
	};
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Integer getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	@Override
	public String toString() {
		return String.format("Cateogry info: %d, %s", 
				this.getId(), this.getName());
	}

}
