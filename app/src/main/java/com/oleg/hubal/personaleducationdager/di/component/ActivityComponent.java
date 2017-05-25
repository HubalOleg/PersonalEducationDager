package com.oleg.hubal.personaleducationdager.di.component;

import com.oleg.hubal.personaleducationdager.MainActivity;
import com.oleg.hubal.personaleducationdager.di.PerActivity;
import com.oleg.hubal.personaleducationdager.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by User on 08.05.2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
