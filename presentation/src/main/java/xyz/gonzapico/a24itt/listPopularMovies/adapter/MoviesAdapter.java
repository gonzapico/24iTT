package xyz.gonzapico.a24itt.listPopularMovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import java.util.List;
import xyz.gonzapico.a24itt.R;
import xyz.gonzapico.a24itt.listPopularMovies.MovieModel;

/**
 * Created by gfernandez on 25/02/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {
  private List<MovieModel> movies;
  private Context mContext;

  public MoviesAdapter(List<MovieModel> movieList) {
    this.movies = movieList;
  }

  @Override public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    mContext = parent.getContext();
    View v = LayoutInflater.from(mContext).inflate(R.layout.movie_row, parent, false);
    return new MovieViewHolder(v);
  }

  @Override public void onBindViewHolder(MovieViewHolder holder, int position) {
    MovieModel popularMovie = movies.get(position);
    holder.tvMovieTitle.setText(popularMovie.getOverview());
    Glide.with(mContext).load(popularMovie.getPoster()).into(holder.ivMoviePoster);
  }

  @Override public int getItemCount() {
    return movies.size();
  }

  @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }
}
