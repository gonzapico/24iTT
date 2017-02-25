package xyz.gonzapico.a24itt.listPopularMovies;

/**
 * Created by gfernandez on 25/02/17.
 */

public class MovieModel {

  private int id;
  private String poster = "";
  private String overview = "";

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }
}
