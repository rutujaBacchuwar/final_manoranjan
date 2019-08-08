package com.stackroute.repository;

import com.stackroute.domain.*;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

public interface InLanguageRelationshipRepository extends Neo4jRepository<InLanguageRelationship, String> {

    @Query("MATCH (v:User) WHERE v.emailId={emailId}"+"-[:Watches]->(d:Documentary)-[:In_Language]->(l:Language)<-[:In_Language]-(d1:Documentary)"+"RETURN d1")
    Collection<Documentary> getRecommendedDocumentary(@Param("emailId") String emailId);

    @Query("MATCH (v:User) WHERE v.emailId={emailId}"+"-[:Watches]->(m:Movie)-[:In_Language]->(l:Language)<-[:In_Language]-(m1:Movie)"+"RETURN m1")
    Collection<Movie> getRecommendedMovie(@Param("emailId") String emailId);

    @Query("MATCH (v:User) WHERE v.emailId={emailId}"+"-[:Watches]->(t:TvEpisodes)-[:In_Language]->(l:Language)<-[:In_Language]-(t1:TvEpisodes)"+"RETURN d1")
    Collection<TvEpisodes> getRecommendedTvEpisodes(@Param("emailId") String emailId);

    @Query("MATCH (v:User) WHERE v.emailId={emailId}"+"-[:Watches]->(w:WebSeries)-[:In_Language]->(l:Language)<-[:In_Language]-(w1:WebSeries)"+"RETURN d1")
    Collection<WebSeries> getRecommendedWebSeries(@Param("emailId") String emailId);
}
