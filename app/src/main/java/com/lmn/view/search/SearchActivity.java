package com.lmn.view.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lmn.Entity.SearchEntity;
import com.lmn.MainDataManager;
import com.lmn.R;
import com.lmn.view.search.adapter.SearchAdapter;
import com.lmn.view.search.entity.SearchAdapterEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import lmn.com.lmnlibrary.GlobalAppComponent;

@Route(path = "/search/activity")
public class SearchActivity extends AppCompatActivity implements SearchContract.View {

    private static final String TAG = "MainActivity";
    private EditText editText;
    private RecyclerView recyclerView;
    private PublishSubject<String> mPublishSubject;
    private CompositeDisposable mCompositeDisposable;
    @Inject
    SearchPresenter searchPresenter;
    @Autowired(name = "resultType")
    String resultType;
    SearchAdapter searchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        DaggerSearchComponent
                .builder()
                .appComponent(GlobalAppComponent.getAppComponent())
                .searchPresenterModule(new SearchPresenterModule(MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager()), this))
                .build()
                .inject(this);
        initEdt();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
        searchPresenter.destory();
    }

    private void initEdt() {
        editText = findViewById(R.id.edt);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchAdapter=new SearchAdapter(R.layout.item_tv);
        recyclerView.setAdapter(searchAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().isEmpty()) {
                    searchAdapter.setNewData(null);
                } else {
                    //输入内容非空的时候才开始搜索
                    startSearch(s.toString());
                }
            }
        });

        mPublishSubject = PublishSubject.create();
        mPublishSubject.debounce(200, TimeUnit.MILLISECONDS) //这里我们限制只有在输入字符200毫秒后没有字符没有改变时才去请求网络，节省了资源
                .filter(new Predicate<String>() { //对源Observable产生的结果按照指定条件进行过滤，只有满足条件的结果才会提交给订阅者

                    @Override
                    public boolean test(String s) throws Exception {
                        //当搜索词为空时，不发起请求
                        return s.length() > 0;
                    }
                })
                /**
                 * flatmap:把Observable产生的结果转换成多个Observable，然后把这多个Observable
                 “扁平化”成一个Observable，并依次提交产生的结果给订阅者

                 *concatMap:操作符flatMap操作符不同的是，concatMap操作符在处理产生的Observable时，
                 采用的是“连接(concat)”的方式，而不是“合并(merge)”的方式，
                 这就能保证产生结果的顺序性，也就是说提交给订阅者的结果是按照顺序提交的，不会存在交叉的情况

                 *switchMap:与flatMap操作符不同的是，switchMap操作符会保存最新的Observable产生的
                 结果而舍弃旧的结果
                 **/
                .switchMap(new Function<String, ObservableSource<String>>() {

                    @Override
                    public ObservableSource<String> apply(String query) throws Exception {
                        return getSearchObservable(query);
                    }

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<String>() {

                    @Override
                    public void onNext(String s) {
                        //显示搜索联想的结果
                        showSearchResult(s);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        mCompositeDisposable = new CompositeDisposable();
        mCompositeDisposable.add(mCompositeDisposable);
    }

    //开始搜索
    private void startSearch(String query) {
        mPublishSubject.onNext(query);
    }

    private Observable<String> getSearchObservable(final String query) {
        return Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                //注意：这里只是模仿求取服务器数据，实际开发中需要你根据这个输入的关键字query去请求数据
                Log.d(TAG, "开始请求，关键词为：" + query);
                try {
                    Thread.sleep(100); //模拟网络请求，耗时100毫秒
                } catch (InterruptedException e) {
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter.onError(e);
                    }
                }
                Log.d("SearchActivity", "结束请求，关键词为：" + query);
                observableEmitter.onNext(query);
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());
    }

    /**
     * 显示搜索结果
     */
    private void showSearchResult(String keyWords) {
        searchPresenter.searchdate(keyWords, resultType);
    }


    @Override
    public void getdata(SearchEntity searchEntity) {
        List<SearchAdapterEntity> searchAdapterEntities = new ArrayList<>();
        for (int i = 0; i <searchEntity.getData().getList().size() ; i++) {
            SearchAdapterEntity searchAdapterEntity=new SearchAdapterEntity();
            searchAdapterEntity.setImgurl((String) searchEntity.getData().getList().get(i).getUrl());
            searchAdapterEntity.setBaseurl( searchEntity.getData().getBasePath());
            searchAdapterEntity.setId(searchEntity.getData().getList().get(i).getId()+"");
            searchAdapterEntity.setResulttype(searchEntity.getData().getList().get(i).getResultType()+"");
            searchAdapterEntity.setName(searchEntity.getData().getList().get(i).getName());
            searchAdapterEntities.add(searchAdapterEntity);
        }
        searchAdapter.setNewData(searchAdapterEntities);
    }


}
