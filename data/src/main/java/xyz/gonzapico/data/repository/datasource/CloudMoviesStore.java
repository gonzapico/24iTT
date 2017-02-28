package xyz.gonzapico.data.repository.datasource;

import android.content.Context;
import javax.inject.Inject;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import xyz.gonzapico.data.Config;
import xyz.gonzapico.data.cloud.MovieDBAPIService;
import xyz.gonzapico.data.di.CloudModule;
import xyz.gonzapico.data.di.DaggerCloudComponent;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.data.entity.MovieAPIResponse;

/**
 * Created by gfernandez on 26/02/17.
 */

public class CloudMoviesStore implements MoviesDataStore {
  @Inject Retrofit retrofit;
  private MovieDBAPIService restApi;
  private Context context;

  /**
   * Construct a {@link CloudMoviesStore} based on connections to the api (Cloud).
   */
  @Inject public CloudMoviesStore(Context context) {
    this.context = context;
    initDagger();
    initRetrofit();
  }

  private void initRetrofit() {
    restApi = retrofit.create(MovieDBAPIService.class);
  }

  private void initDagger() {
    DaggerCloudComponent.builder()
        // list of modules that are part of this component need to be created here too
        .cloudModule(new CloudModule(Config.MOVIE_DB_URL_SECURE, this.context))
        .build()
        .inject(this);
  }

  @Override public Observable<Response<MovieAPIResponse>> popularMoves() {
    return restApi.popularMovies(Config.API_KEY);
  }

  @Override public Observable<Response<MovieAPIGenre>> genres() {
    return restApi.genres(Config.API_KEY);
  }
}
