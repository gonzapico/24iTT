package xyz.gonzapico.a24itt.listPopularMovies;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gfernandez on 25/02/17.
 */

public class MovieModel implements Parcelable {

  private int id;
  private String poster = "";
  private String overview = "";

  public MovieModel(int id, String overview, String poster) {
    this.id = id;
    this.poster = poster;
    this.overview = overview;
  }

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

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.poster);
    dest.writeString(this.overview);
  }

  protected MovieModel(Parcel in) {
    this.id = in.readInt();
    this.poster = in.readString();
    this.overview = in.readString();
  }

  public static final Parcelable.Creator<MovieModel> CREATOR =
      new Parcelable.Creator<MovieModel>() {
        @Override public MovieModel createFromParcel(Parcel source) {
          return new MovieModel(source);
        }

        @Override public MovieModel[] newArray(int size) {
          return new MovieModel[size];
        }
      };
}
