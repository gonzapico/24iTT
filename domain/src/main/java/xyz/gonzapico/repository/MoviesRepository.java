package xyz.gonzapico.repository;

import java.util.List;
import rx.Observable;
import xyz.gonzapico.entity.MovieDomainEntity;

/**
 * Created by gfernandez on 27/02/17.
 */

public interface MoviesRepository {

  Observable<List<MovieDomainEntity>> getPopularMovies();
}
