package xyz.gonzapico.a24itt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;

/**
 * Created by gfernandez on 28/02/17.
 */

public class MovieDetailActivity extends Base24Activity {

  private static final String MOVIE_DETAIL = "movie_detail";

  public static Intent getCallingIntent(Context context, MovieModel movieModelDetail) {
    Intent intent = new Intent(context, MovieDetailActivity.class);
    intent.putExtra(MOVIE_DETAIL, movieModelDetail);
    return intent;
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_home;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState == null) {
      addFragment(R.id.fragmentContainer, MovieDetailFragment.newInstance(
          (MovieModel) getIntent().getParcelableExtra(MOVIE_DETAIL)));
    }

    setUpBackArrow();
  }
}
