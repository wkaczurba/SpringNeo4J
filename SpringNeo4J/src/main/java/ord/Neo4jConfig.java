package ord;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories; // NEW
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableNeo4jRepositories(basePackages="ord.db") // repo
@EnableTransactionManagement
public class Neo4jConfig {
	
	/*public Neo4jConfig() {
		setBasePackage("ord");
	}

	// TODO: Add embedded NEO4J DB:*/
/*	@Bean(destroyMethod="shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory()
				.newEmbeddedDatabase(new File("c:/tmp/graphdb"));
	}*/

	@Bean
	public SessionFactory sessionFactory() {
		// TODO Auto-generated method stub
		return new SessionFactory(configuration(), "ord"); // domain entity base packages
	}
	
	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}
	
	// WORKS WELL -> Embedded Driver:
	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
		config
			.driverConfiguration()
			.setDriverClassName("org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver")
			.setURI("file:///c/tmp/graphdb");
		
		return config;
	}
	
	// WORKS WELL WITH LOCAL HTTP SERVER:
	/*@Bean
	public org.neo4j.ogm.config.Configuration configuration() {		
		Configuration configuration = new Configuration();
		        configuration.driverConfiguration()
		        .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
		        .setURI("http://neo4j:password@localhost:7474");
		
		
		return configuration;
	}*/	
}
