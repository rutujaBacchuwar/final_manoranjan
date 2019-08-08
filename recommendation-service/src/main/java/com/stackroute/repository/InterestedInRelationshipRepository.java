package com.stackroute.repository;

import com.stackroute.domain.Documentary;
import com.stackroute.domain.InterestedInRelationship;
import com.stackroute.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InterestedInRelationshipRepository extends Neo4jRepository<InterestedInRelationship, String> {

    @Query("MATCH (v:User)-[r:Interested_In]->(g:Genre)<-[:Of_Genre]-(d:Documentary) WHERE v.emailId={emailId} RETURN d")
    Collection<Documentary> getRecommendedDocumentary(@Param("emailId") String emailId);

    @Query("MATCH (v:User)-[r:Interested_In]->(g:Genre)<-[:Of_Genre]-(m:Movie) WHERE v.emailId={emailId} RETURN m")
    Collection<Movie> getRecommendedMovie(@Param("emailId") String emailId);
}
