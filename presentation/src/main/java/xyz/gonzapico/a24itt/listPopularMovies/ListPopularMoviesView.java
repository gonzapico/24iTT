package xyz.gonzapico.a24itt.listPopularMovies;

import android.graphics.Movie;
import java.util.List;

/**
 * Created by gfernandez on 25/02/17.
 */

public interface ListPopularMoviesView {

  void showPopularMovies(List<MovieModel> listOfMovies);
}
