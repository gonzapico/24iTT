package xyz.gonzapico.a24itt.listPopularMovies.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gonzapico.a24itt.R;

/**
 * Created by gfernandez on 25/02/17.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.cvMovie) CardView cvMovie;
  @BindView(R.id.ivMoviePoster) ImageView ivMoviePoster;
  @BindView(R.id.tvMovieTitle) TextView tvMovieTitle;

  MovieViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
