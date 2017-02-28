package xyz.gonzapico.a24itt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import javax.inject.Inject;
import xyz.gonzapico.a24itt.di.HasComponent;
import xyz.gonzapico.a24itt.di.components.DaggerMovieComponent;
import xyz.gonzapico.a24itt.di.components.MovieComponent;
import xyz.gonzapico.a24itt.watchTrailer.GetTrailerPresenter;
import xyz.gonzapico.a24itt.watchTrailer.TrailerView;

public class WatchTrailerActivity extends Base24Activity
    implements TrailerView, HasComponent<MovieComponent> {

  private static final String MOVIE_ID = "movie_id";
  @Inject GetTrailerPresenter getTrailerPresenter;
  private YouTubePlayerFragment youTubePlayerFragment;
  private YouTubePlayer youTubePlayer;
  private MovieComponent movieComponent;

  public static Intent getCallingIntent(Context context, int idMovie) {
    Intent intent = new Intent(context, WatchTrailerActivity.class);
    intent.putExtra(MOVIE_ID, idMovie);
    return intent;
  }

  private void initializeInjector() {
    this.movieComponent = DaggerMovieComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.initializeInjector();
    this.getComponent().inject(this);
    if (savedInstanceState == null) {
      getTrailerPresenter.getTrailers(this, getIntent().getIntExtra(MOVIE_ID, 0));
    }
  }

  @Override protected int getLayoutResource() {
    return R.layout.activity_watch_trailer;
  }

  @Override public void showVideo(final String idVideo) {

    youTubePlayerFragment = YouTubePlayerFragment.newInstance();
    addFragment(R.id.fragmentContainer, youTubePlayerFragment);
    youTubePlayerFragment.initialize(Config.YOUTUBE_API_KEY,
        new YouTubePlayer.OnInitializedListener() {

          @Override
          public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
              boolean wasRestored) {

            if (!wasRestored) {
              youTubePlayer = player;
              youTubePlayer.setFullscreen(true);
              youTubePlayer.loadVideo(idVideo);
              youTubePlayer.play();
            }
          }

          @Override public void onInitializationFailure(YouTubePlayer.Provider arg0,
              YouTubeInitializationResult arg1) {
            Log.e("YT", arg1.toString());
          }
        });

  }

  @Override public MovieComponent getComponent() {
    return movieComponent;
  }
}
