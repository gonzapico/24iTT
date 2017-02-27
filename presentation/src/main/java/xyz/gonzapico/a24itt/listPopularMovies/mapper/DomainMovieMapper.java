package xyz.gonzapico.a24itt.listPopularMovies.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import xyz.gonzapico.a24itt.di.PerActivity;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;
import xyz.gonzapico.entity.MovieDomainEntity;

/**
 * Created by gfernandez on 27/02/17.
 */

@PerActivity public class DomainMovieMapper {
  @Inject public DomainMovieMapper() {

  }

  /***
   * Transform a {@link List} of {@link MovieDomainEntity} into a {@link List} of {@link
   * MovieModel}
   */
  public List<MovieModel> transformListOfMovies(List<MovieDomainEntity> listOfMoviesDomainEntity) {
    List<MovieModel> resultOfTransformation = new ArrayList<>();
    int id = 0;

    for (MovieDomainEntity movieDomainEntity : listOfMoviesDomainEntity) {
      MovieModel movieEntity =
          new MovieModel(id++, movieDomainEntity.getTitle(), movieDomainEntity.getPosterPath());
      resultOfTransformation.add(movieEntity);
    }

    return resultOfTransformation;
  }
}