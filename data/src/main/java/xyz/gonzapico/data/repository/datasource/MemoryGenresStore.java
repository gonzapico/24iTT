package xyz.gonzapico.data.repository.datasource;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import xyz.gonzapico.data.entity.GenreEntity;

/**
 * Created by gfernandez on 28/02/17.
 */

public class MemoryGenresStore implements GenresDataStore {
  private Context context;
  private List<GenreEntity> listOfGenres = new ArrayList<>();

  /**
   * Construct a {@link CloudMoviesStore} based on connections to the api (Cloud).
   */
  @Inject public MemoryGenresStore(Context context) {
    this.context = context;
  }

  @Override public void saveGenres(List<GenreEntity> listOfGenres) {
    this.listOfGenres = listOfGenres;
  }
}
