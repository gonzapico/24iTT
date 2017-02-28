package xyz.gonzapico.a24itt.watchTrailer;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import xyz.gonzapico.a24itt.di.PerActivity;
import xyz.gonzapico.a24itt.listPopularMovies.mapper.DomainMovieMapper;
import xyz.gonzapico.entity.TrailerDomainEntity;
import xyz.gonzapico.exception.DefaultErrorBundle;
import xyz.gonzapico.interactor.BaseUseCase;
import xyz.gonzapico.interactor.DefaultSubscriber;
import xyz.gonzapico.interactor.GetTrailers;

/**
 * Created by gfernandez on 28/02/17.
 */

@PerActivity public class GetTrailerPresenter {
  private BaseUseCase getTrailersUseCase;

  private DomainMovieMapper domainMovieMapper;

  private TrailerView trailerView;

  @Inject public GetTrailerPresenter(@Named("trailers") BaseUseCase useCasePopularMovies,
      DomainMovieMapper domainMovieMapper) {
    this.getTrailersUseCase = useCasePopularMovies;
    this.domainMovieMapper = domainMovieMapper;
  }

  public void getTrailers(int idMovie) {
    ((GetTrailers) this.getTrailersUseCase).setIdMovie(idMovie);
    getTrailersUseCase.execute(new GetTrailersSuscriber());
  }

  public void getTrailers(TrailerView trailerView, int idMovie) {
    this.trailerView = trailerView;
    ((GetTrailers) this.getTrailersUseCase).setIdMovie(idMovie);
    getTrailersUseCase.execute(new GetTrailersSuscriber());
  }

  public void setTrailerView(TrailerView trailerView) {
    this.trailerView = trailerView;
  }

  private void playVideo(String keyVideo) {
    trailerView.showVideo(keyVideo);
  }

  private final class GetTrailersSuscriber extends DefaultSubscriber<List<TrailerDomainEntity>> {

    public GetTrailersSuscriber() {
    }

    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {
      showErrorMessage(new DefaultErrorBundle((Exception) e));
    }

    @Override public void onNext(List<TrailerDomainEntity> trailerDomainEntityList) {
      GetTrailerPresenter.this.playVideo(trailerDomainEntityList.get(0).getKey());
    }

    private void showErrorMessage(DefaultErrorBundle errorBundle) {
      //String errorMessage =
      //    ErrorMessageFactory.create(sectionsView.context(), errorBundle.getException());
      //sectionsView.showError(errorMessage);
    }
  }
}