package xyz.gonzapico.data.repository.datasource;

import java.util.List;
import xyz.gonzapico.data.entity.GenreEntity;

/**
 * Created by gfernandez on 26/02/17.
 */

public interface GenresDataStore {

  /***
   * Save genres in memory
   */
  void saveGenres(List<GenreEntity> listOfGenres);
}
