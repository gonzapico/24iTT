package xyz.gonzapico.data.repository.datasource;

import retrofit2.Response;
import rx.Observable;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.data.entity.MovieAPIResponse;

/**
 * Created by gfernandez on 26/02/17.
 */

public interface MoviesDataStore {

  /***
   * Get an {@link Observable} which will emit a {@link MovieAPIResponse}.
   */
  Observable<Response<MovieAPIResponse>> popularMoves();

  /***
   * Get an {@link Observable} which will emit a {@link MovieAPIGenre}
   * @return
   */
  Observable<Response<MovieAPIGenre>> genres();
}
