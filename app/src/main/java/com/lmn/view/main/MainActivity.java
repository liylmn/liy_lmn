package com.lmn.view.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.lmn.R;
import com.lmn.databinding.ActivityMainBinding;
import com.lmn.model.entity.Beauty;
import com.lmn.view.main.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import lmn.com.lmnlibrary.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private List<Beauty> list=new ArrayList<Beauty>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        initData();
        TestAdapter<Beauty> adapter = new TestAdapter<Beauty>(mContext);
        viewDataBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        viewDataBinding.rv.setAdapter(adapter);
        adapter.getItems().addAll(list);
    }
    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    void initData() {
        Beauty beauty1 = new Beauty("第一个美女", "http://img1.dzwww.com:8080/tupian_pl/20150813/16/7858995348613407436.jpg");
        Beauty beauty2 = new Beauty("第二个美女", "http://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&ie=utf-8&in=24401&cl=2&lm=-1&st=-1&step_word=&rn=1&cs=&ln=1998&fmq=1402900904181_R&ic=0&s=&se=1&sme=0&tab=&width=&height=&face=0&is=&istype=2&ist=&jit=&fr=ala&ala=1&alatpl=others&pos=1&pn=1&word=%E5%9B%BE%E7%89%87%20%E7%BE%8E%E5%A5%B3&di=48595043420&os=2534996117,2422129846&pi=0&objurl=http%3A%2F%2Ff2.topitme.com%2F2%2F6a%2Fbc%2F113109954583dbc6a2o.jpg");
        Beauty beauty3 = new Beauty("第三个美女", "http://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&ie=utf-8&in=24401&cl=2&lm=-1&st=-1&step_word=&rn=1&cs=&ln=1998&fmq=1402900904181_R&ic=0&s=&se=1&sme=0&tab=&width=&height=&face=0&is=&istype=2&ist=&jit=&fr=ala&ala=1&alatpl=others&pos=1&pn=4&word=%E5%9B%BE%E7%89%87%20%E7%BE%8E%E5%A5%B3&di=49060051150&os=2265042136,2556439682&pi=0&objurl=http%3A%2F%2Ffd.topitme.com%2Fd%2Fa8%2F1d%2F11315383988791da8do.jpg");
        Beauty beauty4 = new Beauty("第四个美女", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%20%E7%BE%8E%E5%A5%B3&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1765474568,392718820&os=2446997121,213703390&simid=3346074161,401526866&pn=23&rn=1&di=30652022170&ln=3988&fr=&fmq=1526636599589_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140806%2F235020-140P60H10661.jpg&rpstart=0&rpnum=0&adpicid=0");
        Beauty beauty5 = new Beauty("第五个美女", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%20%E7%BE%8E%E5%A5%B3&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=3304768569,3158259996&os=833775228,1291072480&simid=3512975676,351035099&pn=33&rn=1&di=192521773510&ln=3988&fr=&fmq=1526636599589_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F159%2F21%2FBOJVNY9U4XEY.jpg&rpstart=0&rpnum=0&adpicid=0");
        list.add(beauty1);
        list.add(beauty2);
        list.add(beauty3);
        list.add(beauty4);
        list.add(beauty5);
    }
}
