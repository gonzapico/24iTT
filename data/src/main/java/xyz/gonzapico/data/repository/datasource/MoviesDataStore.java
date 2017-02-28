package xyz.gonzapico.data.repository.datasource;

import retrofit2.Response;
import rx.Observable;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.data.entity.MovieAPITrailer;

/**
 * Created by gfernandez on 26/02/17.
 */

public interface MoviesDataStore {

  /***
   * Get a {@link Observable} which will emit a {@link MovieAPIResponse}.
   */
  Observable<Response<MovieAPIResponse>> popularMoves();

  /***
   * Get a {@link Observable} which will emit a {@link MovieAPIGenre}
   * @return
   */
  Observable<Response<MovieAPIGenre>> genres();

  /***
   * Get a {@link Observable} which will emit a {@link MovieAPITrailer}
   * @return
   */
  Observable<Response<MovieAPITrailer>> trailers(int idMovie);
}
