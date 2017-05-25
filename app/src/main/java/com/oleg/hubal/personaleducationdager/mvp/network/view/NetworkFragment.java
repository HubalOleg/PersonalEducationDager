package com.oleg.hubal.personaleducationdager.mvp.network.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.oleg.hubal.personaleducationdager.MainApplication;
import com.oleg.hubal.personaleducationdager.R;
import com.oleg.hubal.personaleducationdager.SharedPrefsHelper;
import com.oleg.hubal.personaleducationdager.di.component.DaggerFragmentComponent;
import com.oleg.hubal.personaleducationdager.di.component.FragmentComponent;
import com.oleg.hubal.personaleducationdager.mvp.network.presenter.INetworkPresenter;
import com.oleg.hubal.personaleducationdager.mvp.network.presenter.NetworkPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 08.05.2017.
 */

public class NetworkFragment extends Fragment implements NetworkView {

    private static final String TAG = "NetworkFragment";


    private INetworkPresenter mNetworkPresenter = new NetworkPresenter();

    @Inject
    SharedPrefsHelper mSharedPrefsHelper;

    private FragmentComponent mFragmentComponent;

    @BindView(R.id.iv_image)
    ImageView mImageImageView;
    @BindView(R.id.tv_text)
    TextView mTextTextView;

    public static NetworkFragment newInstance() {

        Bundle args = new Bundle();

        NetworkFragment fragment = new NetworkFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentComponent getFragmentComponent() {
        if (mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent
                    .builder()
                    .applicationComponent(MainApplication.get(getContext()).getComponent())
                    .build();
        }
        return mFragmentComponent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network, container, false);

        ButterKnife.bind(NetworkFragment.this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNetworkPresenter.onAttachView(NetworkFragment.this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mTextTextView.setText(mSharedPrefsHelper.get("String", ""));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mNetworkPresenter.onDetachView();
    }
}
