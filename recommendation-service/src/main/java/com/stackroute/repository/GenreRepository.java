package com.stackroute.repository;

import com.stackroute.domain.Genre;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

public interface GenreRepository extends Neo4jRepository {
    //query for get all genres
    @Query("MATCH (g:Genre) RETURN g")
    Collection<Genre> getAllGenres();

    //query for getting genre by name
    @Query("MATCH p=(g:Genre) WHERE g.genre={genre} RETURN DISTINCT nodes(p)")
    Genre findGenreByName(@Param("genre") String genre);

}