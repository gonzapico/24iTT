package xyz.gonzapico.data.cloud;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gfernandez on 26/02/17.
 */

public interface MovieDBAPIService {

  // https://api.themoviedb.org/3/movie/popular?api_key=​###
  @GET("/3/movie/popular") void popularMovies(
      @Path(value = "api_key", encoded = true) String apiKey);
}
