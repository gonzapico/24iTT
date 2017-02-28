package xyz.gonzapico.repository;

import java.util.List;
import rx.Observable;
import xyz.gonzapico.entity.GenreDomainEntity;
import xyz.gonzapico.entity.MovieDomainEntity;
import xyz.gonzapico.entity.TrailerDomainEntity;

/**
 * Created by gfernandez on 27/02/17.
 */

public interface MoviesDomainRepository {

  /***
   * Get the popular movies from the API/DB
   */
  Observable<List<MovieDomainEntity>> getPopularMovies();

  /***
   * Get the genres to map the genreId to its correspondent name
   */
  Observable<List<GenreDomainEntity>> getGenres();

  /***
   * Get the trailers of the movie with the id {@param idMovie}
   * @param idMovie
   * @return
   */
  Observable<List<TrailerDomainEntity>> getTrailers(int idMovie);
}
