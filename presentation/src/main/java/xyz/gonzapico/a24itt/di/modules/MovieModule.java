package xyz.gonzapico.a24itt.di.modules;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import xyz.gonzapico.a24itt.di.PerActivity;
import xyz.gonzapico.interactor.BaseUseCase;
import xyz.gonzapico.interactor.GetGenres;
import xyz.gonzapico.interactor.GetPopularMovies;
import xyz.gonzapico.interactor.GetTrailers;

/**
 * Created by gfernandez on 31/10/16.
 */
@Module public class MovieModule {

  public MovieModule() {

  }

  @Provides @PerActivity @Named("popularMovies") BaseUseCase provideGetPopularMoviesUseCase(
      GetPopularMovies getPopularMovies) {
    return getPopularMovies;
  }

  @Provides @PerActivity @Named("genres") BaseUseCase provideGetGenresUseCase(GetGenres getGenres) {
    return getGenres;
  }

  @Provides @PerActivity @Named("trailers") BaseUseCase provideGetTrailersUseCase(
      GetTrailers getTrailers) {
    return getTrailers;
  }
}
