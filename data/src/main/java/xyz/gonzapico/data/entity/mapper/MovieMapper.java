package xyz.gonzapico.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Response;
import xyz.gonzapico.data.Config;
import xyz.gonzapico.data.entity.GenreEntity;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.data.entity.MovieAPITrailer;
import xyz.gonzapico.data.entity.MovieEntity;
import xyz.gonzapico.data.entity.MovieTrailerEntity;
import xyz.gonzapico.entity.GenreDomainEntity;
import xyz.gonzapico.entity.MovieDomainEntity;
import xyz.gonzapico.entity.TrailerDomainEntity;

/**
 * Class in charge of the translation of the entities from the data layer (responses of the API) to the domain layer.
 *
 * Created by gfernandez on 26/02/17.
 */

@Singleton public class MovieMapper {

  // Saved to transform from id to name (genres)
  private List<GenreEntity> listOfGenres = new ArrayList<>();

  @Inject public MovieMapper() {

  }

  /***
   * Method to transform the response of the API to domain entities
   *
   * @param responseOfAPI
   * @return
   */
  public List<MovieDomainEntity> transformToListOfMovies(Response<MovieAPIResponse> responseOfAPI) {
    List<MovieDomainEntity> movieDomainEntityList = null;
    if (responseOfAPI.isSuccessful()) {
      movieDomainEntityList = new ArrayList<>();
      MovieAPIResponse responseOfMovies = responseOfAPI.body();

      List<MovieEntity> listOfMovies = responseOfMovies.getMovieEntities();
      for (MovieEntity movieEntity : listOfMovies) {
        MovieDomainEntity movieDomainEntity = new MovieDomainEntity();
        movieDomainEntity.setId(movieEntity.getId());
        movieDomainEntity.setTitle(movieEntity.getTitle());
        movieDomainEntity.setOverview(movieEntity.getOverview());
        movieDomainEntity.setReleaseDate(movieEntity.getReleaseDate());
        movieDomainEntity.setGenreNames(transformToGenreName(movieEntity.getGenreIds()));
        movieDomainEntity.setPosterPath(Config.IMG_TMDB + movieEntity.getPosterPath());
        movieDomainEntityList.add(movieDomainEntity);
      }
    }

    return movieDomainEntityList;
  }

  /***
   * Method to transform ids to strings (genres)
   *
   * @param genreIds
   * @return
   */
  private List<String> transformToGenreName(List<Integer> genreIds) {
    List<String> transformation = new ArrayList<>();
    for (Integer genreId : genreIds) {
      transformation.add(searchGenreId(genreId));
    }
    return transformation;
  }

  /***
   * Method to search an id in the list of genres
   *
   * @param genreId
   * @return
   */
  private String searchGenreId(int genreId) {
    for (GenreEntity genreEntity : listOfGenres) {
      if (genreEntity.getId() == genreId) {
        return genreEntity.getName();
      }
    }
    return "";
  }

  /***
   * Genre entity transformation
   *
   * @param movieAPIGenreResponse
   * @return
   */
  public List<GenreDomainEntity> transformToListOfGenres(
      Response<MovieAPIGenre> movieAPIGenreResponse) {
    List<GenreDomainEntity> listOfGenreDomainEntity = null;
    if (movieAPIGenreResponse.isSuccessful()) {
      listOfGenreDomainEntity = new ArrayList<>();
      List<GenreEntity> listOfGenreEntities = movieAPIGenreResponse.body().getGenreEntityList();
      listOfGenres = listOfGenreEntities;
      for (GenreEntity genreEntity : listOfGenreEntities) {
        GenreDomainEntity genreDomainEntity = new GenreDomainEntity();
        genreDomainEntity.setId(genreEntity.getId());
        genreDomainEntity.setName(genreEntity.getName());

        listOfGenreDomainEntity.add(genreDomainEntity);
      }
    }
    return listOfGenreDomainEntity;
  }

  /***
   * Trailers entity transformation
   * 
   * @param movieAPITrailer
   * @return
   */
  public List<TrailerDomainEntity> transformToListOfTrailers(
      Response<MovieAPITrailer> movieAPITrailer) {
    List<TrailerDomainEntity> resultOfTransformation = null;
    if (movieAPITrailer.isSuccessful()) {
      resultOfTransformation = new ArrayList<>();

      List<MovieTrailerEntity> listOfTrailers = movieAPITrailer.body().getListOfVideos();

      for (MovieTrailerEntity entity : listOfTrailers) {
        TrailerDomainEntity trailerDomainEntity = new TrailerDomainEntity();
        trailerDomainEntity.setName(entity.getName());
        trailerDomainEntity.setKey(entity.getKey());
        trailerDomainEntity.setSize(entity.getSize());
        trailerDomainEntity.setType(entity.getType());

        resultOfTransformation.add(trailerDomainEntity);
      }
    }
    return resultOfTransformation;
  }
}
