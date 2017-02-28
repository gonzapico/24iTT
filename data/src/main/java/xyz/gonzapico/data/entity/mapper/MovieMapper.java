package xyz.gonzapico.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Response;
import xyz.gonzapico.data.Config;
import xyz.gonzapico.data.entity.GenreEntity;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.data.entity.MovieEntity;
import xyz.gonzapico.entity.GenreDomainEntity;
import xyz.gonzapico.entity.MovieDomainEntity;

/**
 * Created by gfernandez on 26/02/17.
 */

@Singleton public class MovieMapper {

  public List<GenreEntity> listOfGenres = new ArrayList<>();

  @Inject public MovieMapper() {

  }

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

  private List<String> transformToGenreName(List<Integer> genreIds) {
    List<String> transformation = new ArrayList<>();
    for (Integer genreId : genreIds) {
      transformation.add(searchGenreId(genreId));
    }
    return transformation;
  }

  private String searchGenreId(int genreId) {
    for (GenreEntity genreEntity : listOfGenres) {
      if (genreEntity.getId() == genreId) {
        return genreEntity.getName();
      }
    }
    return "";
  }

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
}
