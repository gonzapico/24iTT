package xyz.gonzapico.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Response;
import xyz.gonzapico.data.entity.MovieAPIResponse;
import xyz.gonzapico.entity.MovieDomainEntity;

/**
 * Created by gfernandez on 26/02/17.
 */

public class MovieMapper {

  public List<MovieDomainEntity> transformToListOfMovies(Response<MovieAPIResponse> responseOfAPI) {
    return new ArrayList<>();
  }
}
