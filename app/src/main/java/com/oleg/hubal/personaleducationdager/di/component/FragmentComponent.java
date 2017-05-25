package com.oleg.hubal.personaleducationdager.di.component;

import com.oleg.hubal.personaleducationdager.di.PerFragment;
import com.oleg.hubal.personaleducationdager.di.module.FragmentModule;
import com.oleg.hubal.personaleducationdager.mvp.network.view.NetworkFragment;

import dagger.Component;

/**
 * Created by User on 08.05.2017.
 */

@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(NetworkFragment networkFragment);
}
