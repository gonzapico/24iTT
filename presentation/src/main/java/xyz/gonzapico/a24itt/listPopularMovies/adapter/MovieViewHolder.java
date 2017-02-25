package xyz.gonzapico.a24itt.listPopularMovies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gfernandez on 25/02/17.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

  MovieViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
