package ord;

import java.util.LinkedHashSet;
import java.util.Set;

//import org.springframework.data.neo4j.annotation.GraphId;
//import org.springframework.data.neo4j.annotation.NodeEntity;
//import org.springframework.data.neo4j.annotation.RelatedTo; (NOW: Relationship)

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Order {
	@GraphId
	private Long id;
	
	private String customer;
	private String type;
	
	@Relationship(type="HAS_ITEMS")
	private Set<Item> items = new LinkedHashSet<>();
	
	// constructor to help tests.
	public Order() {
	}
	
	public Order(String customer, String type, Item... items) {
		this.customer = customer;
		this.type = type;
		for (Item item : items) {
			this.items.add(item);
		}
	}

	// getters + setters below
	
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

}
