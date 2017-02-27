package xyz.gonzapico.interactor;

import javax.inject.Inject;
import rx.Observable;
import xyz.gonzapico.executor.PostExecutionThread;
import xyz.gonzapico.executor.ThreadExecutor;
import xyz.gonzapico.repository.MoviesDomainRepository;

/**
 * Created by gfernandez on 27/02/17.
 */

public class GetPopularMovies extends BaseUseCase {

  private final MoviesDomainRepository mRepository;

  @Inject public GetPopularMovies(MoviesDomainRepository moviesDomainRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.mRepository = moviesDomainRepository;
  }

  @Override public Observable buildUseCaseObservable() {
    return this.mRepository.getPopularMovies();
  }
}
