package xyz.gonzapico.a24itt.navigation;

import android.content.Context;
import android.content.Intent;
import javax.inject.Inject;
import javax.inject.Singleton;
import xyz.gonzapico.a24itt.MovieDetailActivity;
import xyz.gonzapico.a24itt.WatchTrailerActivity;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;

/**
 * Created by gfernandez on 28/02/17.
 */

/**
 * Class used to navigate through the application.
 */
@Singleton public class Navigator {

  @Inject public Navigator() {
  }

  public void navigateToMovieDetail(Context context, MovieModel movieModel) {
    if (context != null) {
      Intent intentToLaunch = MovieDetailActivity.getCallingIntent(context, movieModel);
      context.startActivity(intentToLaunch);
    }
  }

  public void navigateToWatchTrailer(Context context, int idVideo){
    if (context != null){
      Intent intentToLaunch = WatchTrailerActivity.getCallingIntent(context, idVideo);
      context.startActivity(intentToLaunch);
    }
  }
}