package xyz.gonzapico.interactor;

import javax.inject.Inject;
import rx.Observable;
import xyz.gonzapico.executor.PostExecutionThread;
import xyz.gonzapico.executor.ThreadExecutor;
import xyz.gonzapico.repository.MoviesDomainRepository;

/**
 * Created by gfernandez on 28/02/17.
 */

public class GetTrailers extends BaseUseCase {

  private final MoviesDomainRepository mRepository;
  private int idMovie;

  @Inject
  public GetTrailers(MoviesDomainRepository moviesDomainRepository, ThreadExecutor threadExecutor,
      PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.mRepository = moviesDomainRepository;
  }

  @Override public Observable buildUseCaseObservable() {
    return this.mRepository.getTrailers(idMovie);
  }

  public void setIdMovie(int idMovie) {
    this.idMovie = idMovie;
  }
}
