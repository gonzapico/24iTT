package xyz.gonzapico.a24itt.watchTrailer;

import java.util.List;

/**
 * Created by gfernandez on 28/02/17.
 */

public interface TrailerView {

  /***
   * Play one of the videos
   */
  void playVideo(String idVideo);

  /***
   * Showing the list of different trailers to choose
   */
  void showChooserTrailer(List<TrailerModel> trailerOptions);
}
