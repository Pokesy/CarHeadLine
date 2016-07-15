package com.hengrtech.carheadline;

import android.app.Application;
import com.hengrtech.carheadline.injection.DaggerGlobalComponent;
import com.hengrtech.carheadline.injection.GlobalComponent;
import com.hengrtech.carheadline.injection.GlobalModule;

/**
 * Created by zhaozeyang on 16/4/13.
 */
public class CustomApp extends Application {

  private GlobalComponent mGlobalComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    mGlobalComponent = DaggerGlobalComponent.builder().globalModule(new GlobalModule(this)).build();
  }

  public GlobalComponent getGlobalComponent() {
    return mGlobalComponent;
  }
}
