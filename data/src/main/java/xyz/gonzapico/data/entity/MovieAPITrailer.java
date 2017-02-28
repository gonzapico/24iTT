package xyz.gonzapico.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by gfernandez on 28/02/17.
 */

public class MovieAPITrailer {

  @SerializedName("id")
  String id;
  @SerializedName("results") List<MovieTrailerEntity> listOfVideos;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<MovieTrailerEntity> getListOfVideos() {
    return listOfVideos;
  }

  public void setListOfVideos(List<MovieTrailerEntity> listOfVideos) {
    this.listOfVideos = listOfVideos;
  }
}
