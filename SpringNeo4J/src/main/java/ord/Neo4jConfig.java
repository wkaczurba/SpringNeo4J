package ord;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@EnableNeo4jRepositories
public class Neo4jConfig extends Neo4jConfiguration {
	
	public Neo4jConfig() {
		setBasePackage("ord");
	}

	// TODO: Add embedded NEO4J DB:
	@Bean(destroyMethod="shutdown")
	public GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory()
				.newEmbeddedDatabaseBuilder("/tmp/graphdb")
				.newGraphDatabase();
	}
	
	
}
