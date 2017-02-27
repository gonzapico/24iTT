package xyz.gonzapico.a24itt.listPopularMovies;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import xyz.gonzapico.a24itt.di.PerActivity;
import xyz.gonzapico.a24itt.listPopularMovies.mapper.DomainMovieMapper;
import xyz.gonzapico.data.entity.mapper.MovieMapper;
import xyz.gonzapico.entity.MovieDomainEntity;
import xyz.gonzapico.exception.DefaultErrorBundle;
import xyz.gonzapico.interactor.BaseUseCase;
import xyz.gonzapico.interactor.DefaultSubscriber;

/**
 * Created by gfernandez on 25/02/17.
 */

@PerActivity public class ListPopularMoviesPresenter {
  private BaseUseCase getPopularMoviesUseCase;
  private List<MovieModel> listOfMovies = new ArrayList<>();
  private ListPopularMoviesView listPopularMoviesView;

  private DomainMovieMapper domainMovieMapper;

  @Inject
  public ListPopularMoviesPresenter(@Named("popularMovies") BaseUseCase useCasePopularMovies,
      DomainMovieMapper domainMovieMapper) {
    this.getPopularMoviesUseCase = useCasePopularMovies;
    this.domainMovieMapper = domainMovieMapper;
  }

  private void renderListOfMovies(List<MovieDomainEntity> listOfMoviesEntityDomain) {
    listPopularMoviesView.showPopularMovies(
        domainMovieMapper.transformListOfMovies(listOfMoviesEntityDomain));
  }

  private List<MovieModel> getFakePopularMovies() {
    return listOfMovies;
  }

  private void createfakePopularMovies() {
    listOfMovies.add(new MovieModel(0,
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTM4NDIxNTM2Ml5BMl5BanBnXkFtZTcwMDQ0NDQzMQ@@._V1_UY268_CR3,0,182,268_AL_.jpg",
        "Torrente 4"));
    listOfMovies.add(new MovieModel(1,
        "https://images-na.ssl-images-amazon.com/images/M/MV5BZWIyNmZmNWItZmExNS00MzA5LTk1ZTgtY2EyOTVlNWMzN2UwL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTA0MjU0Ng@@._V1_UY268_CR1,0,182,268_AL_.jpg",
        "Torrente 5"));
    listOfMovies.add(new MovieModel(2,
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY4MzAyMTY4MV5BMl5BanBnXkFtZTgwMjU5NDI1MDE@._V1_UX182_CR0,0,182,268_AL_.jpg",
        "Torrente 6"));
  }

  public void getPopularMovies() {
    this.getPopularMoviesUseCase.execute(new GetPopularMoviesSuscriber());
  }

  public void setListPopularMoviesView(ListPopularMoviesView view) {
    listPopularMoviesView = view;
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
}
