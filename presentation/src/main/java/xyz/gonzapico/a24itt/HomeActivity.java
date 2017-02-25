package xyz.gonzapico.a24itt;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import java.util.List;
import xyz.gonzapico.a24itt.listPopularMovies.ListPopularMoviesView;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;
import xyz.gonzapico.a24itt.listPopularMovies.adapter.MoviesAdapter;

public class HomeActivity extends Base24Activity implements ListPopularMoviesView {

  @BindView(R.id.rvMovies) RecyclerView rvMovies;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setUpRecyclerView(rvMovies);
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_home;
  }

  private void setUpRecyclerView(RecyclerView rv) {
    rv.setHasFixedSize(true);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    rv.setLayoutManager(llm);
  }

  private void setUpAdapter(List<MovieModel> popularMovies) {
    MoviesAdapter moviesAdapter = new MoviesAdapter(popularMovies);
    rvMovies.setAdapter(moviesAdapter);
  }

  @Override public void showPopularMovies(List<MovieModel> listOfMovies) {
    setUpAdapter(listOfMovies);
  }
}
