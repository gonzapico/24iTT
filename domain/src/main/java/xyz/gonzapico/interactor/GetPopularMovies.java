package xyz.gonzapico.interactor;

import javax.inject.Inject;
import rx.Observable;
import xyz.gonzapico.executor.PostExecutionThread;
import xyz.gonzapico.executor.ThreadExecutor;
import xyz.gonzapico.repository.MoviesRepository;

/**
 * Created by gfernandez on 27/02/17.
 */

public class GetPopularMovies extends BaseUseCase {

  private final MoviesRepository mRepository;

  @Inject public GetPopularMovies(MoviesRepository moviesRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.mRepository = moviesRepository;
  }

  @Override public Observable buildUseCaseObservable() {
    return this.mRepository.getPopularMovies();
  }
}
