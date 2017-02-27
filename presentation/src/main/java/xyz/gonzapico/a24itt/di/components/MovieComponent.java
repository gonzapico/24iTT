package xyz.gonzapico.a24itt.di.components;

import com.elconfidencial.app.ShowNewFragment;
import com.elconfidencial.app.ShowNewsFragment;
import com.elconfidencial.app.di.PerActivity;
import com.elconfidencial.app.di.modules.ActivityModule;
import com.elconfidencial.app.di.modules.NewModule;
import dagger.Component;

/**
 * Created by gfernandez on 31/10/16.
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, NewModule.class
}) public interface MovieComponent extends ActivityComponent {
  void inject(ShowNewFragment showNewFragment);

  void inject(ShowNewsFragment showNewsFragment);
}