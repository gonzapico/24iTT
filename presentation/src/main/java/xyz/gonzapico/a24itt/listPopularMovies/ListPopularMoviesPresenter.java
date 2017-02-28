package xyz.gonzapico.a24itt.listPopularMovies;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import xyz.gonzapico.a24itt.di.PerActivity;
import xyz.gonzapico.a24itt.listPopularMovies.mapper.DomainMovieMapper;
import xyz.gonzapico.entity.GenreDomainEntity;
import xyz.gonzapico.entity.MovieDomainEntity;
import xyz.gonzapico.exception.DefaultErrorBundle;
import xyz.gonzapico.interactor.BaseUseCase;
import xyz.gonzapico.interactor.DefaultSubscriber;

/**
 * Created by gfernandez on 25/02/17.
 */

@PerActivity public class ListPopularMoviesPresenter {
  private BaseUseCase getPopularMoviesUseCase, getGenresUseCase;
  private List<MovieModel> listOfMovies = new ArrayList<>();
  private ListPopularMoviesView listPopularMoviesView;

  private DomainMovieMapper domainMovieMapper;

  @Inject
  public ListPopularMoviesPresenter(@Named("popularMovies") BaseUseCase useCasePopularMovies,
      @Named("genres") BaseUseCase getGenresUseCase, DomainMovieMapper domainMovieMapper) {
    this.getGenresUseCase = getGenresUseCase;
    this.getPopularMoviesUseCase = useCasePopularMovies;
    this.domainMovieMapper = domainMovieMapper;
  }

  private void renderListOfMovies(List<MovieDomainEntity> listOfMoviesEntityDomain) {
    listPopularMoviesView.showPopularMovies(
        domainMovieMapper.transformListOfMovies(listOfMoviesEntityDomain));
  }

  public void onMovieClicked(MovieModel movieModel) {
    this.listPopularMoviesView.viewMovie(movieModel);
  }

  private void getPopularMovies() {
    this.getPopularMoviesUseCase.execute(new GetPopularMoviesSuscriber());
  }

  public void setListPopularMoviesView(ListPopularMoviesView view) {
    listPopularMoviesView = view;
  }

  public void getMoviesInformation() {
    getPopularMovies();
    getGenres();
  }

  private void getGenres(){
    this.getGenresUseCase.execute(new GetGenresSuscriber());
  }

  private final class GetPopularMoviesSuscriber extends DefaultSubscriber<List<MovieDomainEntity>> {

    public GetPopularMoviesSuscriber() {
    }

    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {
      showErrorMessage(new DefaultErrorBundle((Exception) e));
    }

    @Override public void onNext(List<MovieDomainEntity> movieDomainEntity) {
      ListPopularMoviesPresenter.this.renderListOfMovies(movieDomainEntity);
    }

    private void showErrorMessage(DefaultErrorBundle errorBundle) {
      //String errorMessage =
      //    ErrorMessageFactory.create(sectionsView.context(), errorBundle.getException());
      //sectionsView.showError(errorMessage);
    }
  }

  private final class GetGenresSuscriber extends DefaultSubscriber<List<GenreDomainEntity>> {

    public GetGenresSuscriber() {
    }

    @Override public void onCompleted() {

    }

    @Override public void onError(Throwable e) {
      showErrorMessage(new DefaultErrorBundle((Exception) e));
    }

    @Override public void onNext(List<GenreDomainEntity> movieDomainEntity) {
      //ListPopularMoviesPresenter.this.saveGenres(movieDomainEntity);
    }

    private void showErrorMessage(DefaultErrorBundle errorBundle) {
      //String errorMessage =
      //    ErrorMessageFactory.create(sectionsView.context(), errorBundle.getException());
      //sectionsView.showError(errorMessage);
    }
  }
}
