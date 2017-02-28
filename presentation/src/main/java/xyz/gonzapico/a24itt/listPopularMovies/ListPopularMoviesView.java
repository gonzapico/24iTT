package xyz.gonzapico.a24itt.listPopularMovies;

import android.graphics.Movie;
import java.util.List;

/**
 * Created by gfernandez on 25/02/17.
 */

public interface ListPopularMoviesView {

  /***
   * Render the list of popular movies into the UI.
   *
   * @param listOfMovies
   */
  void showPopularMovies(List<MovieModel> listOfMovies);

  /***
   * View a {@link MovieModel} detail.
   *
   * @param movieDetail
   */
  void viewMovie(MovieModel movieDetail);
}
