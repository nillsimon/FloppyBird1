package com.example.mvp_mosby.presenter;

import com.example.mvp_mosby.model.InfoModel;
import com.example.mvp_mosby.model.MyAction;
import com.example.mvp_mosby.view.InfoView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

public class InfoPresenterImpl extends
        MvpBasePresenter<InfoView> implements InfoPresenter {

   private final InfoModel infoModel;
    public InfoPresenterImpl(InfoModel infoModel) {
        this.infoModel = infoModel;
    }

    @Override
    public void loadInformation() {
        if(isViewAttached()) {
            getView().showLoading(false);
        }
        infoModel.retrieveInfo(new MyAction<String>() {
            @Override
            public void call(String s) {
                final InfoView infoView = getView();
                if(isViewAttached()){
                    infoView.setData(s);
                    infoView.showContent();
                }
            }
        });

    }
}
