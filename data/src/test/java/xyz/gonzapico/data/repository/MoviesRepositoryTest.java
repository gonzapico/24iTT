package xyz.gonzapico.data.repository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import retrofit2.Response;
import rx.Observable;
import xyz.gonzapico.data.ApplicationTestCase;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.data.entity.mapper.MovieMapper;
import xyz.gonzapico.data.repository.datasource.MoviesDataStore;
import xyz.gonzapico.data.repository.datasource.MoviesDataStoreFactory;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by gfernandez on 28/02/17.
 */
public class MoviesRepositoryTest extends ApplicationTestCase {

  @Rule public ExpectedException expectedException = ExpectedException.none();
  private MoviesRepository moviesRepository;
  @Mock private MoviesDataStoreFactory mockMovieDataStoreFactory;
  @Mock private MovieMapper mockMovieMapper;
  @Mock private MoviesDataStore mockMoviesDataStore;
  @Mock private MovieAPIResponse mockEntityAPIResponse;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    moviesRepository = new MoviesRepository(mockMovieDataStoreFactory, mockMovieMapper);

    given(mockMovieDataStoreFactory.createCloudDataStore()).willReturn(mockMoviesDataStore);
  }

  @Test public void testGetConfigurationHappyCase() {
    Response<MovieAPIResponse> entityAPIResponse = Response.success(new MovieAPIResponse());
    given(mockMoviesDataStore.popularMoves()).willReturn(Observable.just(entityAPIResponse));

    moviesRepository.getPopularMovies();

    verify(mockMovieDataStoreFactory).createCloudDataStore();
    verify(mockMoviesDataStore).popularMoves();
  }
}