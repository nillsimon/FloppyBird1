package com.example.mvp_mosby.presenter;

import com.example.mvp_mosby.view.InfoView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

public interface InfoPresenter extends MvpPresenter<InfoView> {

    void loadInformation();
}
