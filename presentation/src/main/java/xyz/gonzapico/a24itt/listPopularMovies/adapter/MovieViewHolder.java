package xyz.gonzapico.a24itt.listPopularMovies.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import xyz.gonzapico.a24itt.R;

/**
 * Created by gfernandez on 25/02/17.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

  CardView cvMovie;
  ImageView ivMoviePoster;
  TextView tvMovieTitle;

  MovieViewHolder(View itemView) {
    super(itemView);
    ivMoviePoster = (ImageView) itemView.findViewById(R.id.ivMoviePoster);
    tvMovieTitle = (TextView) itemView.findViewById(R.id.tvMovieTitle);
    cvMovie = (CardView) itemView.findViewById(R.id.cvMovie);
  }
}
