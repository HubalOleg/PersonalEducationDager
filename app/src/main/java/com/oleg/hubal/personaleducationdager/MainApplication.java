package com.oleg.hubal.personaleducationdager;

import android.app.Application;
import android.content.Context;

import com.oleg.hubal.personaleducationdager.di.component.ApplicationComponent;
import com.oleg.hubal.personaleducationdager.di.component.DaggerApplicationComponent;
import com.oleg.hubal.personaleducationdager.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by User on 08.05.2017.
 */

public class MainApplication extends Application {

    protected ApplicationComponent mApplicationComponent;

    @Inject
    SharedPrefsHelper mSharedPrefsHelper;

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
