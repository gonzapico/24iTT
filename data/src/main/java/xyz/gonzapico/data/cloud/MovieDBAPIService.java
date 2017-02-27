package xyz.gonzapico.data.cloud;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import xyz.gonzapico.data.entity.MovieAPIResponse;

/**
 * Created by gfernandez on 26/02/17.
 */

public interface MovieDBAPIService {

  // https://api.themoviedb.org/3/movie/popular?api_key=​###
  @GET("/3/movie/popular") Observable<Response<MovieAPIResponse>> popularMovies(
      @Path(value = "api_key", encoded = true) String apiKey);
}
