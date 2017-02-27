package xyz.gonzapico.data.repository;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import xyz.gonzapico.data.entity.mapper.MovieMapper;
import xyz.gonzapico.data.repository.datasource.MoviesDataStore;
import xyz.gonzapico.data.repository.datasource.MoviesDataStoreFactory;
import xyz.gonzapico.entity.MovieDomainEntity;
import xyz.gonzapico.repository.MoviesDomainRepository;

/**
 * Created by gfernandez on 26/02/17.
 */

@Singleton public class MoviesRepository implements MoviesDomainRepository {

  private final MoviesDataStoreFactory movieDataStoreFactory;
  private final MovieMapper movieMapper;

  @Inject
  public MoviesRepository(MoviesDataStoreFactory movieDataStoreFactory, MovieMapper movieMapper) {
    this.movieDataStoreFactory = movieDataStoreFactory;
    this.movieMapper = movieMapper;
  }

  @Override public Observable<List<MovieDomainEntity>> getPopularMovies() {
    final MoviesDataStore moviesDataStore = this.movieDataStoreFactory.createCloudDataStore();
    return moviesDataStore.popularMoves().map(this.movieMapper::transformToListOfMovies);
  }
}
