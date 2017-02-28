package xyz.gonzapico.data.repository;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import xyz.gonzapico.data.entity.mapper.MovieMapper;
import xyz.gonzapico.data.repository.datasource.GenresDataStore;
import xyz.gonzapico.data.repository.datasource.MoviesDataStore;
import xyz.gonzapico.data.repository.datasource.MoviesDataStoreFactory;
import xyz.gonzapico.entity.GenreDomainEntity;
import xyz.gonzapico.entity.MovieDomainEntity;
import xyz.gonzapico.entity.TrailerDomainEntity;
import xyz.gonzapico.repository.MoviesDomainRepository;

/**
 * Boundary between data and domain layer to retrieve movies data information.
 *
 * Created by gfernandez on 26/02/17.
 */

@Singleton public class MoviesRepository implements MoviesDomainRepository {

  private final MoviesDataStoreFactory movieDataStoreFactory;
  private final MovieMapper movieMapper;

  private MoviesDataStore moviesDataStore = null;

  @Inject
  public MoviesRepository(MoviesDataStoreFactory movieDataStoreFactory, MovieMapper movieMapper) {
    this.movieDataStoreFactory = movieDataStoreFactory;
    this.movieMapper = movieMapper;

    moviesDataStore = this.movieDataStoreFactory.createCloudDataStore();
  }

  @Override public Observable<List<MovieDomainEntity>> getPopularMovies() {
    return moviesDataStore.popularMoves().map(this.movieMapper::transformToListOfMovies);
  }

  @Override public Observable<List<GenreDomainEntity>> getGenres() {
    return moviesDataStore.genres().map(this.movieMapper::transformToListOfGenres);
  }

  @Override public Observable<List<TrailerDomainEntity>> getTrailers(int idMovie) {
    return moviesDataStore.trailers(idMovie).map(this.movieMapper::transformToListOfTrailers);
  }
}
