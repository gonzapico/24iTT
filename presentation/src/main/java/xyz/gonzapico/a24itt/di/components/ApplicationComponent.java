package xyz.gonzapico.a24itt.di.components;

/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import dagger.Component;
import javax.inject.Singleton;
import xyz.gonzapico.a24itt.Base24Activity;
import xyz.gonzapico.a24itt.di.modules.ApplicationModule;
import xyz.gonzapico.data.repository.MoviesRepository;
import xyz.gonzapico.executor.PostExecutionThread;
import xyz.gonzapico.executor.ThreadExecutor;
import xyz.gonzapico.repository.MoviesDomainRepository;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  void inject(Base24Activity baseActivity);

  //Exposed to sub-graphs.
  Context context();

  ThreadExecutor threadExecutor();

  PostExecutionThread postExecutionThread();

  MoviesDomainRepository moviesRepository();
}


