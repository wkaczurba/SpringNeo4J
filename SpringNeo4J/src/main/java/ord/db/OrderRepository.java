package ord.db;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import ord.Order;

// This is an interface that will be turned into implementation by Spring.
public interface OrderRepository extends GraphRepository<Order> {
	
	List<Order> findByCustomer(String customer);
	List<Order> findByCustomerLike(String customer);
	List<Order> findByCustomerAndType(String customer, String type);
	List<Order> getByType(String type);
	
}
