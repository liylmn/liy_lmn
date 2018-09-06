package com.lmn.view.my.activity.leave;

import dagger.Component;
import lmn.com.lmnlibrary.AppComponent;
import lmn.com.lmnlibrary.PerFragment;

/**
 * 作者：liy_lmn
 * 时间：2018/9/6:16:51
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
@PerFragment
@Component(dependencies = AppComponent.class,modules = LeaveMessagePresenterModule.class)
public interface LeaveMessageComponent {
    void inject(LeaveMessageActivity leaveMessageActivity);
}
