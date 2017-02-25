package xyz.gonzapico.a24itt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gfernandez on 25/02/17.
 */

public abstract class Base24Activity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResource());
  }

  protected abstract int getLayoutResource();
}
