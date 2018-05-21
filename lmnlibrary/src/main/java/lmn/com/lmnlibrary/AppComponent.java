package lmn.com.lmnlibrary;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import lmn.com.lmnlibrary.manager.DataManager;

/**
 * Created by admin on 2017/3/10.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {
    Context getContext();
    DataManager getDataManager();


}
