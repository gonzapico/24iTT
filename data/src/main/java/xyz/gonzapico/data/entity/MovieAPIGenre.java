package xyz.gonzapico.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by gfernandez on 28/02/17.
 */

public class MovieAPIGenre {

  @SerializedName("genres")
  private List<GenreEntity> genreEntityList;

  public List<GenreEntity> getGenreEntityList() {
    return genreEntityList;
  }

  public void setGenreEntityList(List<GenreEntity> genreEntityList) {
    this.genreEntityList = genreEntityList;
  }
}
