package xyz.gonzapico.a24itt;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import xyz.gonzapico.a24itt.di.HasComponent;
import xyz.gonzapico.a24itt.di.components.ApplicationComponent;
import xyz.gonzapico.a24itt.di.components.DaggerMovieComponent;
import xyz.gonzapico.a24itt.di.components.MovieComponent;
import xyz.gonzapico.a24itt.di.modules.ActivityModule;
import xyz.gonzapico.a24itt.navigation.Navigator;

/**
 * Created by gfernandez on 25/02/17.
 */

public abstract class Base24Activity extends AppCompatActivity implements
    HasComponent<MovieComponent> {

  Navigator mNavigator = new Navigator();
  MovieComponent mMovieComponent;
  Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResource());

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    if (toolbar != null) {
      setSupportActionBar(toolbar);

      getSupportActionBar().setTitle("");
    }

    this.initializeInjector();
  }

  /***
   * Method to init the DI and has all the classes availables
   */
  private void initializeInjector() {
    this.mMovieComponent = DaggerMovieComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  protected abstract int getLayoutResource();

  /**
   * Adds a {@link Fragment} to this activity's layout.
   *
   * @param containerViewId The container view to where add the fragment.
   * @param fragment The fragment to be added.
   */
  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  /**
   * Get the Main Application component for dependency injection.
   *
   * @return {@link ApplicationComponent}
   */
  protected ApplicationComponent getApplicationComponent() {
    return ((Base24Application) getApplication()).getApplicationComponent();
  }

  /**
   * Get an Activity module for dependency injection.
   *
   * @return {@link ActivityModule}
   */
  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  @Override public MovieComponent getComponent() {
    return mMovieComponent;
  }
  public void setUpBackArrow() {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //What to do on back clicked
        finish();
      }
    });
  }
}
