package com.lmn.view.my.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lmn.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lmn.com.lmnlibrary.base.BaseFragment;

public class MyFragment extends BaseFragment {
    @BindView(R.id.tv_my_number)
    TextView tvMyNumber;
    @BindView(R.id.tv_my_name)
    TextView tvMyName;
    @BindView(R.id.my_modify_psw)
    TextView my_modify_psw;
    @BindView(R.id.my_leave_message)
    TextView myLeaveMessage;
    @BindView(R.id.my_btn_back)
    Button myBtnBack;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_my;
    }

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Override
    public void initview() {
        tvMyName.setText(mDataManager.getSPMapData().get("username"));
        tvMyNumber.setText(mDataManager.getSPMapData().get("number"));
    }

    @Override
    public void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.my_modify_psw, R.id.my_leave_message, R.id.my_btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_modify_psw:
                ARouter.getInstance().build("/modify/activity").navigation();
                break;
            case R.id.my_leave_message:
                ARouter.getInstance().build("/leavemessage/activity").navigation();
                break;
            case R.id.my_btn_back:
                HashMap<String, String> map = new HashMap<>();
                map.put("username","");
                map.put("number","");
                map.put("userId","");
                mDataManager.saveSPMapData(map);
                ARouter.getInstance().build("/lmn/login").navigation();
                getActivity().finish();
                break;
        }
    }
}
