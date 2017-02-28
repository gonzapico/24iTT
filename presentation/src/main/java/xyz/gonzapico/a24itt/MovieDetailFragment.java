package xyz.gonzapico.a24itt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;

/**
 * Created by gfernandez on 28/02/17.
 */

public class MovieDetailFragment extends Base24Fragment {

  private static final String MOVIE_DETAIL = "movie_detail";
  ImageView ivPosterHeader;
  TextView tvTitle;
  private MovieModel movieModelDetail;

  public MovieDetailFragment() {
    setRetainInstance(true);
  }

  public static MovieDetailFragment newInstance(MovieModel movieDetail) {
    MovieDetailFragment fragment = new MovieDetailFragment();
    if (movieDetail != null) {
      Bundle arguments = new Bundle();
      arguments.putParcelable(MOVIE_DETAIL, movieDetail);
      fragment.setArguments(arguments);
    }
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_detail_movie, container, false);
    ButterKnife.bind(this, view);
    tvTitle = (TextView) view.findViewById(R.id.tvMovieTitle);
    ivPosterHeader = (ImageView) view.findViewById(R.id.ivMoviePosterHeader);

    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    if (getArguments() != null) {
      movieModelDetail = (MovieModel) getArguments().getParcelable(MOVIE_DETAIL);
    }

    setUpDetailsOfTheMovie(movieModelDetail);
  }

  private void setUpDetailsOfTheMovie(MovieModel movieModelDetail) {
    Glide.with(getActivity()).load(movieModelDetail.getPoster()).into(ivPosterHeader);
    tvTitle.setText(movieModelDetail.getOverview());
  }
}
