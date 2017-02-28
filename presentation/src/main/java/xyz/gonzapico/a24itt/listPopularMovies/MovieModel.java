package xyz.gonzapico.a24itt.listPopularMovies;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gfernandez on 25/02/17.
 */

public class MovieModel implements Parcelable {

  private int id;
  private String poster = "";
  private String overview = "";
  private String title = "";
  private List<String> genres = new ArrayList<String>();
  private String date = "";

  public MovieModel() {

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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.poster);
    dest.writeString(this.overview);
    dest.writeString(this.title);
    dest.writeStringList(this.genres);
    dest.writeString(this.date);
  }

  protected MovieModel(Parcel in) {
    this.id = in.readInt();
    this.poster = in.readString();
    this.overview = in.readString();
    this.title = in.readString();
    this.genres = in.createStringArrayList();
    this.date = in.readString();
  }

  public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
    @Override public MovieModel createFromParcel(Parcel source) {
      return new MovieModel(source);
    }

    @Override public MovieModel[] newArray(int size) {
      return new MovieModel[size];
    }
  };
}
