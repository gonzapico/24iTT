package xyz.gonzapico.a24itt.di.modules;

import com.elconfidencial.app.di.PerActivity;
import com.elconfidencial.domain.app.interactor.BaseUseCase;
import com.elconfidencial.domain.app.interactor.GetNew;
import com.elconfidencial.domain.app.interactor.GetNews;
import com.elconfidencial.domain.app.interactor.GetRelatedNews;
import com.elconfidencial.domain.app.interactor.GetTagNews;
import com.elconfidencial.domain.app.interactor.GetVideo;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by gfernandez on 31/10/16.
 */
@Module public class MovieModule {

  public MovieModule() {

  }

  @Provides @PerActivity @Named("new") BaseUseCase provideGetNewUseCase(GetNew getNew) {
    return getNew;
  }

  @Provides @PerActivity @Named("news") BaseUseCase provideGetNewsUseCase(GetNews getNews) {
    return getNews;
  }

  @Provides @PerActivity @Named("relatedNews") BaseUseCase provideGetRelatedNewsUseCase(
      GetRelatedNews getRelatedNews) {
    return getRelatedNews;
  }

  @Provides @PerActivity @Named("video") BaseUseCase provideGetVideo(GetVideo getVideo) {
    return getVideo;
  }

  @Provides @PerActivity @Named("tag") BaseUseCase provideGetTagNews(GetTagNews getTags) {
    return getTags;
  }
}
