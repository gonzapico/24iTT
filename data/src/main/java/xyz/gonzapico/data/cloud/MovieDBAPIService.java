package xyz.gonzapico.data.cloud;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.data.entity.MovieAPITrailer;

/**
 * Created by gfernandez on 26/02/17.
 */

public interface MovieDBAPIService {

  // https://api.themoviedb.org/3/movie/popular?api_key=​###
  @GET("/3/movie/popular") Observable<Response<MovieAPIResponse>> popularMovies(
      @Query(value = "api_key", encoded = true) String apiKey);

  // https://api.themoviedb.org/3/genre/movie/list?api_key=dbea971bbf56f55e5fdf7aad761c4c2e
  @GET("/3/genre/movie/list") Observable<Response<MovieAPIGenre>> genres(
      @Query(value = "api_key", encoded = true) String apiKey);

  // https://api.themoviedb.org/3/movie/271110/videos?api_key=dbea971bbf56f55e5fdf7aad761c4c2e
  @GET("/3/movie/{id}/videos") Observable<Response<MovieAPITrailer>> trailers(@Path("id") int id,
      @Query(value = "api_key", encoded = true) String apiKey);
}
