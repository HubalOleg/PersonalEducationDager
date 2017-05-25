package com.oleg.hubal.personaleducationdager.di.component;

import android.app.Application;
import android.content.Context;

import com.oleg.hubal.personaleducationdager.MainApplication;
import com.oleg.hubal.personaleducationdager.SharedPrefsHelper;
import com.oleg.hubal.personaleducationdager.di.ApplicationContext;
import com.oleg.hubal.personaleducationdager.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by User on 08.05.2017.
 */


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication mainApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    SharedPrefsHelper getPreferenceHelper();
}
