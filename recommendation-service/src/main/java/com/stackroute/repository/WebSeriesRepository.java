package com.stackroute.repository;

import com.stackroute.domain.WebSeries;
import com.stackroute.domain.Documentary;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface WebSeriesRepository extends Neo4jRepository<WebSeries, Long> {

    //query to get all WebSeries
    @Query("MATCH (w:WebSeries) RETURN w")
    Collection<WebSeries> getAllWebSeries();

    //query to find WebSeries by title
    WebSeries findWebSeriesByEpisodicTitle(@Param("episodicTitle") String episodicTitle);

    //query to create WebSeries node
    @Query("CREATE (w:WebSeries {episodicTitle:{episodicTitle}})")
    WebSeries createWebSeriesNode(@Param("episodicTitle") String episodicTitle);

    //query to create WebSeries and language relation
    @Query("MATCH (w:WebSeries),(l:Language) WHERE w.episodicTitle={episodicTitle} and l.language={language} CREATE (w)-[r:In_Language]->(l) RETURN w, r, l")
    WebSeries createLanguageRelation(@Param("episodicTitle") String episodicTitle, @Param("language") String language);

    //query to create WebSeries and category relation
    @Query("MATCH (w:WebSeries),(c:Category) WHERE w.episodicTitle={episodicTitle} and c.category={category} CREATE (w)-[r:Of_Category]->(c) RETURN w, r, c")
    Documentary createCategoryRelation(@Param("episodicTitle") String episodicTitle, @Param("category") String category);

}
