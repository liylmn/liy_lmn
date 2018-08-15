package com.lmn.view.main;


import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerActivity;

/**
 * Created by admin on 2017/3/12.
 */
@PerActivity
@Component(dependencies = AppComponent.class , modules = MainPresenterModule .class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
