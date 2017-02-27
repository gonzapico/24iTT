package xyz.gonzapico.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Response;
import xyz.gonzapico.data.Config;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.data.entity.MovieEntity;
import xyz.gonzapico.entity.MovieDomainEntity;

/**
 * Created by gfernandez on 26/02/17.
 */

@Singleton public class MovieMapper {

  @Inject public MovieMapper() {

  }

  public List<MovieDomainEntity> transformToListOfMovies(Response<MovieAPIResponse> responseOfAPI) {
    List<MovieDomainEntity> movieDomainEntityList = new ArrayList<>();
    if (responseOfAPI.isSuccessful()) {
      MovieAPIResponse responseOfMovies = responseOfAPI.body();

      List<MovieEntity> listOfMovies = responseOfMovies.getMovieEntities();
      for (MovieEntity movieEntity : listOfMovies) {
        MovieDomainEntity movieDomainEntity = new MovieDomainEntity();
        movieDomainEntity.setTitle(movieEntity.getTitle());
        movieDomainEntity.setPosterPath(Config.IMG_TMDB + movieEntity.getPosterPath());
        movieDomainEntityList.add(movieDomainEntity);
      }

      return movieDomainEntityList;
    } else {
      return null;
    }
  }
}
