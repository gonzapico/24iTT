package xyz.gonzapico.a24itt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;

/**
 * Created by gfernandez on 28/02/17.
 */

public class MovieDetailFragment extends Base24Fragment {

  private static final String MOVIE_DETAIL = "movie_detail";
  private ImageView ivPosterHeader;
  private TextView tvTitle;
  private TextView tvOverview;
  private TextView tvDate;
  private TextView tvGenres;
  private Button btnWatchTrailer;
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
    bindViews(view);
    return view;
  }

  private void bindViews(View view) {
    tvTitle = (TextView) view.findViewById(R.id.tvMovieTitle);
    ivPosterHeader = (ImageView) view.findViewById(R.id.ivMoviePosterHeader);
    tvOverview = (TextView) view.findViewById(R.id.tvOverview);
    tvDate = (TextView) view.findViewById(R.id.tvDate);
    tvGenres = (TextView) view.findViewById(R.id.tvGenres);
    btnWatchTrailer = (Button) view.findViewById(R.id.btnWatchTrailer);
    btnWatchTrailer.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        ((Base24Activity) getActivity()).mNavigator.navigateToWatchTrailer(getActivity(),
            movieModelDetail.getId());
      }
    });
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    if (getArguments() != null) {
      movieModelDetail = getArguments().getParcelable(MOVIE_DETAIL);
    }

    setUpDetailsOfTheMovie(movieModelDetail);
  }

  private void setUpDetailsOfTheMovie(MovieModel movieModelDetail) {
    Glide.with(getActivity()).load(movieModelDetail.getPoster()).into(ivPosterHeader);
    tvTitle.setText(movieModelDetail.getTitle());
    tvOverview.setText(movieModelDetail.getOverview());
    tvDate.setText(movieModelDetail.getDate());
    tvGenres.setText(buildGenreList());
  }

  private String buildGenreList() {
    String genreList = "";
    int sizeOfGenres = movieModelDetail.getGenres().size();
    if (sizeOfGenres > 0) {
      StringBuilder stringBuilder = new StringBuilder(movieModelDetail.getGenres().get(0));
      for (int i = 1; i < sizeOfGenres; i++) {
        stringBuilder.append(", ");
        stringBuilder.append(movieModelDetail.getGenres().get(i));
      }
      genreList = stringBuilder.toString();
    }
    return genreList;
  }
}
