package com.oleg.hubal.personaleducationdager.mvp.network.presenter;


import com.oleg.hubal.personaleducationdager.mvp.network.view.NetworkView;

/**
 * Created by User on 08.05.2017.
 */

public interface INetworkPresenter {
    void onAttachView(NetworkView view);
    void onDetachView();
    boolean isViewAttached();
}
