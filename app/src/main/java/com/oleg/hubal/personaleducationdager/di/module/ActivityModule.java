package com.oleg.hubal.personaleducationdager.di.module;

import android.app.Activity;
import android.content.Context;

import com.oleg.hubal.personaleducationdager.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 08.05.2017.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
