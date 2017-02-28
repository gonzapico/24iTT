package xyz.gonzapico.a24itt;

import android.os.Bundle;
import xyz.gonzapico.a24itt.di.HasComponent;
import xyz.gonzapico.a24itt.di.components.DaggerMovieComponent;
import xyz.gonzapico.a24itt.di.components.MovieComponent;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;
import xyz.gonzapico.a24itt.navigation.Navigator;

public class HomeActivity extends Base24Activity
    implements ShowPopularMoviesFragment.MovieListListener, HasComponent<MovieComponent> {
  private MovieComponent mMovieComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.initializeInjector();
    if (savedInstanceState == null) {
      addFragment(R.id.fragmentContainer, new ShowPopularMoviesFragment());
    }
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_home;
  }

  @Override public MovieComponent getComponent() {
    return mMovieComponent;
  }

  private void initializeInjector() {
    this.mMovieComponent = DaggerMovieComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  @Override public void onMovieClicked(MovieModel movieModel) {
    if (this.mNavigator == null){
      this.mNavigator = new Navigator();
    }
    this.mNavigator.navigateToMovieDetail(this, movieModel);
  }
}
