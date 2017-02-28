package xyz.gonzapico.data.repository.datasource;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gfernandez on 26/02/17.
 */

@Singleton public class MoviesDataStoreFactory {

  private final Context context;

  @Inject public MoviesDataStoreFactory(Context context) {
    if (context == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
  }

  /**
   * Create {@link MoviesDataStore} to retrieve data from the Cloud.
   */
  public MoviesDataStore createCloudDataStore() {

    return new CloudMoviesStore(context);
  }

  public GenresDataStore createMemoryGenresDataStore() {
    return new MemoryGenresStore(context);
  }
}
