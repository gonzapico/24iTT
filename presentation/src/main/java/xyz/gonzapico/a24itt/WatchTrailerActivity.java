package xyz.gonzapico.a24itt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class WatchTrailerActivity extends Base24Activity {
  private static final String MOVIE_ID = "movie_id";

  public static Intent getCallingIntent(Context context, int idMovie) {
    Intent intent = new Intent(context, WatchTrailerActivity.class);
    intent.putExtra(MOVIE_ID, idMovie);
    return intent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState == null) {
      addFragment(R.id.fragmentContainer,
          WatchTrailerFragment.newInstance(getIntent().getIntExtra(MOVIE_ID, 0)));
    }
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_watch_trailer;
  }
}
