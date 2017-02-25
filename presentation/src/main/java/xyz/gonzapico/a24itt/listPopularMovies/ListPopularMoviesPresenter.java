package xyz.gonzapico.a24itt.listPopularMovies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfernandez on 25/02/17.
 */

public class ListPopularMoviesPresenter {

  private List<MovieModel> listOfMovies = new ArrayList<>();
  private ListPopularMoviesView listPopularMoviesView;

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
    createfakePopularMovies();
    listPopularMoviesView.showPopularMovies(getFakePopularMovies());
  }

  public void setListPopularMoviesView(ListPopularMoviesView view) {
    listPopularMoviesView = view;
  }
}
