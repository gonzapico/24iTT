package xyz.gonzapico.a24itt;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;
import xyz.gonzapico.a24itt.di.components.MovieComponent;
import xyz.gonzapico.a24itt.listPopularMovies.ListPopularMoviesPresenter;
import xyz.gonzapico.a24itt.listPopularMovies.ListPopularMoviesView;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;
import xyz.gonzapico.a24itt.listPopularMovies.adapter.MoviesAdapter;

/**
 * Created by gfernandez on 27/02/17.
 */

public class ShowPopularMoviesFragment extends Base24Fragment implements ListPopularMoviesView {

  @Inject ListPopularMoviesPresenter listPopularMoviesPresenter;

  RecyclerView rvMovies;

  public ShowPopularMoviesFragment() {
    setRetainInstance(true);
  }

  public static ShowPopularMoviesFragment newInstance() {
    ShowPopularMoviesFragment fragment = new ShowPopularMoviesFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.getComponent(MovieComponent.class).inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    //ButterKnife.bind(this, view);
    rvMovies = (RecyclerView) view.findViewById(R.id.rvMovies);
    setUpRecyclerView();

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    listPopularMoviesPresenter.setListPopularMoviesView(this);
    if (savedInstanceState == null) {
      listPopularMoviesPresenter.getPopularMovies();
    }
  }

  private void setUpRecyclerView() {
    rvMovies.setHasFixedSize(true);

    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    rvMovies.setLayoutManager(llm);
  }

  private void setUpAdapter(List<MovieModel> popularMovies) {
    MoviesAdapter moviesAdapter = new MoviesAdapter(popularMovies);
    rvMovies.setAdapter(moviesAdapter);
  }

  @Override public void showPopularMovies(List<MovieModel> listOfMovies) {
    setUpAdapter(listOfMovies);
  }
}
