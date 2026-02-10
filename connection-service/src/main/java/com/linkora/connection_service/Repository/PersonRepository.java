package com.linkora.connection_service.Repository;

import com.linkora.connection_service.Entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository  extends Neo4jRepository<Person,Long> {

    List<Person> findByName(String name);

    @Query("""
    MATCH (u:Person)-[:CONNECTED_TO]->(a:Person)
    WHERE u.id = $id
    RETURN a
""")
    List<Person> findFirstDegreeConnections(Long id);

}
