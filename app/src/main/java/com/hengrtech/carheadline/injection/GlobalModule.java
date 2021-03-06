package com.hengrtech.carheadline.injection;

import android.content.Context;
import com.hengrtech.carheadline.CustomApp;
import com.hengrtech.carheadline.manager.LoginSession;
import com.hengrtech.carheadline.utils.preference.CustomAppPreferences;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;


/**
 * Created by zhaozeyang on 16/4/13.
 */
@Module
public class GlobalModule {
  private CustomApp mApplication;

  public GlobalModule(CustomApp app) {
    mApplication = app;
  }

  @Singleton
  @Provides
  public Context providesApplicationContext() {
    return mApplication;
  }

  @Singleton
  @Provides
  @GlobalBus
  public Bus providesGlobalBus() {
    return new Bus();
  }

  @Singleton
  @Provides
  public CustomAppPreferences providesGlobalPreferences() {
    return new CustomAppPreferences(mApplication);
  }

  @Provides
  @Singleton
  public LoginSession providesLoginSession() {
    return new LoginSession(mApplication);
  }
}
