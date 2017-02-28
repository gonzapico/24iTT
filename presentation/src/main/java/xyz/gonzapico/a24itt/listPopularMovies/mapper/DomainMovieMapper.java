package xyz.gonzapico.a24itt.listPopularMovies.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import xyz.gonzapico.a24itt.di.PerActivity;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;
import xyz.gonzapico.a24itt.watchTrailer.TrailerModel;
import xyz.gonzapico.entity.MovieDomainEntity;
import xyz.gonzapico.entity.TrailerDomainEntity;

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
      MovieModel movieEntity = new MovieModel();
      movieEntity.setId(movieDomainEntity.getId());
      movieEntity.setPoster(movieDomainEntity.getPosterPath());
      movieEntity.setTitle(movieDomainEntity.getTitle());
      movieEntity.setOverview(movieDomainEntity.getOverview());
      movieEntity.setDate(movieDomainEntity.getReleaseDate());
      movieEntity.setGenres(movieDomainEntity.getGenreNames());
      resultOfTransformation.add(movieEntity);
    }

    return resultOfTransformation;
  }

  public List<TrailerModel> transformTrailers(List<TrailerDomainEntity> listOfTrailerDomainEntity) {
    List<TrailerModel> resultOfTransformation = new ArrayList<>();

    for (TrailerDomainEntity trailerDomainEntity : listOfTrailerDomainEntity) {
      TrailerModel trailerModel = new TrailerModel();

      trailerModel.setKeyVideo(trailerDomainEntity.getKey());
      trailerModel.setQualityTrailer(
          trailerDomainEntity.getName() + " " + trailerDomainEntity.getSize());
      resultOfTransformation.add(trailerModel);
    }

    return resultOfTransformation;
  }
}
