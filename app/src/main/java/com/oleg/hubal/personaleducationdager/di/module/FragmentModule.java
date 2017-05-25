package com.oleg.hubal.personaleducationdager.di.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.oleg.hubal.personaleducationdager.di.FragmentContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 08.05.2017.
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentContext
    Context provideContext() {
        return mFragment.getContext();
    }

    @Provides
    Fragment provideFragment() {
        return mFragment;
    }

}
