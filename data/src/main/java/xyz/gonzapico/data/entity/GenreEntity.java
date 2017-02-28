package xyz.gonzapico.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gfernandez on 28/02/17.
 */

public class GenreEntity {

  @SerializedName("id")
  private int id;
  @SerializedName("name")
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
