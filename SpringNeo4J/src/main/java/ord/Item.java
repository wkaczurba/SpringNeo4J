package ord;

//import org.springframework.data.neo4j.annotation.GraphId;
//import org.springframework.data.neo4j.annotation.NodeEntity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Item {

	@GraphId
	private Long id;
	
	private Order order;
	private String product;
	private double price;
	private int quantity;
	
	// Constructor to help tests:
	public Item() { }
	public Item(Order order, String product, double price, int quantity) {
		this.order = order;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	
	// Getters + Setters:
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}	
}
