package com.oleg.hubal.personaleducationdager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.oleg.hubal.personaleducationdager.di.component.ActivityComponent;
import com.oleg.hubal.personaleducationdager.di.component.DaggerActivityComponent;
import com.oleg.hubal.personaleducationdager.mvp.network.view.NetworkFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject
    SharedPrefsHelper mSharedPrefsHelper;

    private ActivityComponent mActivityComponent;

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent
                    .builder()
                    .applicationComponent(MainApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mSharedPrefsHelper.put("String", "One");

        launchNetworkFragment();
    }

    private void launchNetworkFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, NetworkFragment.newInstance())
                .commit();
    }
}
