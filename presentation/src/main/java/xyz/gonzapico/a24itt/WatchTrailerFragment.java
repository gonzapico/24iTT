package xyz.gonzapico.a24itt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import java.util.List;
import javax.inject.Inject;
import xyz.gonzapico.a24itt.di.components.MovieComponent;
import xyz.gonzapico.a24itt.watchTrailer.GetTrailerPresenter;
import xyz.gonzapico.a24itt.watchTrailer.TrailerModel;
import xyz.gonzapico.a24itt.watchTrailer.TrailerView;

/**
 * Created by gfernandez on 28/02/17.
 */

public class WatchTrailerFragment extends Base24Fragment implements TrailerView {
  private final static String MOVIE_ID = "movie_id";
  @Inject GetTrailerPresenter getTrailerPresenter;
  private YouTubePlayerFragment youTubePlayerFragment;
  private YouTubePlayer youTubePlayer;

  public WatchTrailerFragment() {
    setRetainInstance(true);
  }

  public static WatchTrailerFragment newInstance(int idMovie) {
    WatchTrailerFragment fragment = new WatchTrailerFragment();
    Bundle arguments = new Bundle();
    arguments.putInt(MOVIE_ID, idMovie);
    fragment.setArguments(arguments);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.video_content, container, false);
    bindViews();
    return view;
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    this.getComponent(MovieComponent.class).inject(this);

    if (getArguments() != null) {
      getTrailerPresenter.getTrailers(this, getArguments().getInt(MOVIE_ID));
    }

  }

  @Override public void onResume() {
    super.onResume();
  }

  private void bindViews() {
    youTubePlayerFragment = YouTubePlayerFragment.newInstance();
    ((Base24Activity)getActivity()).addFragment(R.id.youtubePlayerFragment, youTubePlayerFragment);
  }

  @Override public void playVideo(final String idVideo) {

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

  @Override public void showChooserTrailer(final List<TrailerModel> trailerOptions) {
    int indexOfTrailers = 0;
    CharSequence trailers[] = new CharSequence[trailerOptions.size()];
    for (TrailerModel trailerModel : trailerOptions) {
      trailers[indexOfTrailers++] = trailerModel.getQualityTrailer();
    }
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("Select one of the trailers");
    builder.setItems(trailers, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // the user clicked on colors[which]
        getTrailerPresenter.playVideo(trailerOptions.get(which).getKeyVideo());
      }
    });
    builder.show();
  }
}
