package com.stackroute.repository;

import com.stackroute.domain.Documentary;
import com.stackroute.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie,Long> {

    //query to get all movies
    @Query("MATCH (m:Movie) RETURN m")
    Collection<Movie> getAllMovie();

    //query to find movie by title
    Movie findMovieByMediaTitle(@Param("mediaTitle") String mediaTitle);

    //query to create movie node
    @Query("CREATE (m:Movie {mediaTitle:{mediaTitle}})")
    Movie createMovieNode(@Param("mediaTitle") String mediaTitle);

    //query to create movie and language relation
    @Query("MATCH (m:Movie),(l:Language) WHERE m.mediaTitle={mediaTitle} and l.language={language} CREATE (m)-[r:In_Language]->(l) RETURN m, r, l")
    Movie createLanguageRelation(@Param("mediaTitle") String mediaTitle, @Param("language") String language);

    //query to create movie and genre relation
    @Query("MATCH (m:Movie),(g:Genre) WHERE m.mediaTitle={mediaTitle} and g.genre={genre} CREATE (m)-[r:Of_Genre]->(g) RETURN m, r, g")
    Movie createGenreRelation(@Param("mediaTitle") String mediaTitle, @Param("genre") String genre);

    //query to create movie and category relation
    @Query("MATCH (m:Movie),(c:Category) WHERE m.mediaTitle={mediaTitle} and c.category={category} CREATE (m)-[r:Of_Category]->(c) RETURN m, r, c")
    Documentary createCategoryRelation(@Param("mediaTitle") String mediaTitle, @Param("category") String category);

}
