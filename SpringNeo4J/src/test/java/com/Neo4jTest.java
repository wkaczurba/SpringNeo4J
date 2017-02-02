package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import ord.Item;
import ord.Neo4jConfig;
import ord.Order;
import ord.db.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.neo4j.conversion.Result;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

@ContextConfiguration(classes={Neo4jConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class Neo4jTest {
	
	@Autowired
	OrderRepository orderRepo; 
	Order savedOrder;
	
	@Before
	public void init() {
		Assert.assertEquals(0, orderRepo.count());
	}	

	@Test
	public void testNeo() {
		
		// Create elements + save them into DB:
		Order order = null;
		order = new Order("John Welsh", "WEB", 
				new Item(order, "Book", 39.99f, 3),
				new Item(order, "Socks", 4.99f, 5));
		savedOrder = orderRepo.save(order);
		Assert.assertEquals(1, orderRepo.count()); // There is 1 entity after saving the order;
		
		// Finding...
		List<Order> ordersFound;
		ordersFound = orderRepo.findByCustomer("John Welsh");
		Assert.assertEquals(1, ordersFound.size());
		
		ordersFound = orderRepo.findByCustomerLike("John*");
		Assert.assertEquals(1, ordersFound.size());
		
		ordersFound = orderRepo.findByCustomerAndType("John Welsh", "WEB");
		Assert.assertEquals(1, ordersFound.size());
		
		ordersFound = orderRepo.getByType("WEB");
		Assert.assertEquals(1, ordersFound.size());
		
		
		// Find all -> This causes problems.
/*		Result<Order> orders = orderRepo.findAll();
		for (Order o : orders) {
			System.out.println("findAll found -> o: " + o);
		}*/
		
		Order foundOne = orderRepo.findOne(savedOrder.getId());
		Assert.assertEquals("John Welsh", foundOne.getCustomer());
		Assert.assertEquals(2, foundOne.getItems().size());
		
		//Assert.fail("TODO: Write the test...");
	}
	
	// This one will be always executed.
	@After
	public void after() {
		orderRepo.delete(savedOrder.getId());
		Assert.assertEquals(0, orderRepo.count());
	}	
	
}
