package com.oleg.hubal.personaleducationdager.mvp.network.presenter;

import com.oleg.hubal.personaleducationdager.mvp.network.view.NetworkView;

/**
 * Created by User on 08.05.2017.
 */

public class NetworkPresenter implements INetworkPresenter {

    private NetworkView mNetworkView;

    @Override
    public void onAttachView(NetworkView networkView) {
        mNetworkView = networkView;
    }

    @Override
    public void onDetachView() {
        mNetworkView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mNetworkView != null;
    }
}
