package com.lmn.view.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lmn.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;
@Route(path = "/search/activity")
public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_view)
    SearchView searchView;
    private CustomPopupWindow mPop; //显示搜索联想的pop
    private ListView searchLv; //搜索联想结果的列表
    private ArrayAdapter mAdapter; //ListView的适配器
    private List<String> mSearchList = new ArrayList<>(); //搜索结果的数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        // 4. 设置点击搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
//        initPop();

    }

    /**
     * 初始化Pop，pop的布局是一个列表
     */
    private void initPop() {
        mPop = new CustomPopupWindow.Builder(this)
                .setContentView(R.layout.pop_search)
                .setwidth(LinearLayout.LayoutParams.MATCH_PARENT)
                .setheight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setBackgroundAlpha(1f)
                .build();
        searchLv = (ListView) mPop.getItemView(R.id.search_list_lv);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSearchList);
        searchLv.setAdapter(mAdapter);
        searchLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(Ser, SearchResultActivity.class);
//                intent.putExtra("result", mSearchList.get(position));
//                startActivity(intent);
            }
        });
    }
}
