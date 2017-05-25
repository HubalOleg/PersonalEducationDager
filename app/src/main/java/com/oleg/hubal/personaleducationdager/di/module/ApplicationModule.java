package com.oleg.hubal.personaleducationdager.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.oleg.hubal.personaleducationdager.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 08.05.2017.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
