package xyz.gonzapico.data.repository.datasource;

import android.content.Context;
import com.nytimes.android.external.store.base.impl.BarCode;
import com.nytimes.android.external.store.base.impl.Store;
import com.nytimes.android.external.store.base.impl.StoreBuilder;
import javax.inject.Inject;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import xyz.gonzapico.data.Config;
import xyz.gonzapico.data.cloud.MovieDBAPIService;
import xyz.gonzapico.data.di.CloudModule;
import xyz.gonzapico.data.di.DaggerCloudComponent;
import xyz.gonzapico.data.entity.GenreEntity;
import xyz.gonzapico.data.entity.MovieAPIGenre;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.data.entity.MovieAPITrailer;
import xyz.gonzapico.data.entity.MovieEntity;
import xyz.gonzapico.entity.TrailerDomainEntity;

/**
 * Created by gfernandez on 26/02/17.
 */

public class CloudMoviesStore implements MoviesDataStore {
  private static final String BARCODE_INDEX = "999000";
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
    return getPopularMovies();
  }

  private Observable<Response<MovieAPIResponse>> getPopularMovies() {
    BarCode barCodePopularMovies = new BarCode(MovieEntity.class.getSimpleName(), Config.API_KEY);
    return providePopularMoviesStore().get(barCodePopularMovies);
  }

  private Store<Response<MovieAPIResponse>, BarCode> providePopularMoviesStore() {
    return StoreBuilder.<Response<MovieAPIResponse>>barcode().fetcher(
        barCode -> restApi.popularMovies(barCode.getKey())).open();
  }

  @Override public Observable<Response<MovieAPIGenre>> genres() {
    return getGenres();
  }

  private Observable<Response<MovieAPIGenre>> getGenres() {
    BarCode barCodeGenres = new BarCode(GenreEntity.class.getSimpleName(), Config.API_KEY);
    return provideGenresStore().get(barCodeGenres);
  }

  private Store<Response<MovieAPIGenre>, BarCode> provideGenresStore() {
    return StoreBuilder.<Response<MovieAPIGenre>>barcode().fetcher(
        barCode -> restApi.genres(barCode.getKey())).open();
  }

  @Override public Observable<Response<MovieAPITrailer>> trailers(int idMovie) {
    return restApi.trailers(idMovie, Config.API_KEY);
  }

  private Observable<Response<MovieAPITrailer>> getTrailers(int idMovie) {
    BarCode barCodeTrailer = new BarCode(TrailerDomainEntity.class.getSimpleName(), idMovie + "");
    return provideTrailerStore().get(barCodeTrailer);
  }

  private Store<Response<MovieAPITrailer>, BarCode> provideTrailerStore() {
    return StoreBuilder.<Response<MovieAPITrailer>>barcode().fetcher(
        barCode -> restApi.trailers(Integer.parseInt(barCode.getKey()), Config.API_KEY)).open();
  }
}
