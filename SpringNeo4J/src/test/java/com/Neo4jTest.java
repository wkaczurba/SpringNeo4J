package com;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import ord.Neo4jConfig;
import ord.db.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

@ContextConfiguration(classes={Neo4jConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class Neo4jTest {
	
	@Autowired
	OrderRepository orderRepo; 

	@Test
	public void testNeo() {
		// TODO: Write the test.
		Assert.fail("TODO: Write the test...");
	}
	
}
