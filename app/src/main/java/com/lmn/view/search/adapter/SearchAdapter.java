package com.lmn.view.search.adapter;

import android.app.Activity;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lmn.MainDataManager;
import com.lmn.R;
import com.lmn.utils.FileUtil;
import com.lmn.view.search.entity.SearchAdapterEntity;

import java.io.File;
import java.util.List;

import io.reactivex.observers.DisposableObserver;
import lmn.com.lmnlibrary.GlobalAppComponent;
import lmn.com.lmnlibrary.listener.DownloadFileListener;
import okhttp3.ResponseBody;

/**
 * 作者：liy_lmn
 * 时间：2018/10/26:11:16
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class SearchAdapter extends BaseQuickAdapter<SearchAdapterEntity,BaseViewHolder>{
    public SearchAdapter(int layoutResId, @Nullable List<SearchAdapterEntity> data) {
        super(layoutResId, data);
    }

    public SearchAdapter(@Nullable List<SearchAdapterEntity> data) {
        super(data);
    }

    public SearchAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, final SearchAdapterEntity item) {
        helper.setText(R.id.tv,item.getName());
    helper.getView(R.id.ar_tv).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (item.getResulttype().equals("1")){
                ARouter.getInstance().build("/detailmessage/activity")
                        .withString("message",  item.getName())
                        .withString("id",item.getId()+"")
                        .navigation();
            }else if (item.getResulttype().equals("2")){
                final String fileUrl = Environment.getExternalStorageDirectory().getAbsolutePath() + "/zhongchetaiyuan/" + item.getName();
                final File file = new File(fileUrl);
                if (file.exists()) {
                    MaterialDialog materialDialog = new MaterialDialog.Builder(mContext)
                            .title("打开文件")
                            .content(item.getName())
                            .positiveText("打开")
                            .negativeText("取消")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    try {
                                        if (null == file || !file.exists()) {
                                            return;
                                        }
                                        mContext.startActivity(FileUtil.getImageFileIntent(mContext,fileUrl));

                                    } catch (Exception e) {
                                        //没有安装第三方的软件会提示
                                        Toast toast = Toast.makeText(mContext, "没有找到打开该文件的应用程序", Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                }
                            }).show();
                } else {
                    MaterialDialog materialDialog = new MaterialDialog.Builder(mContext)
                            .title("下载附件")
                            .content(item.getImgurl())
                            .positiveText("下载")
                            .negativeText("取消")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager()).download(item.getBaseurl() + item.getImgurl(), item.getName(), new DisposableObserver<ResponseBody>() {
                                                @Override
                                                public void onNext(ResponseBody responseBody) {

                                                }

                                                @Override
                                                public void onError(Throwable e) {

                                                }

                                                @Override
                                                public void onComplete() {

                                                }
                                            }, new DownloadFileListener() {
                                                @Override
                                                public void onStart() {
                                                    Activity activity = (Activity) mContext;
                                                    activity.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(mContext, "开始下载", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onProgress(final int currentLength) {
                                                    Activity activity = (Activity) mContext;
                                                    activity.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Log.e("下载进度", currentLength + "%");
                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onFinish(final String localPath) {
                                                    Activity activity = (Activity) mContext;
                                                    activity.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            if (null == file || !file.exists()) {
                                                                return;
                                                            }
                                                            mContext.startActivity(FileUtil.getImageFileIntent(mContext,fileUrl));
                                                            Toast.makeText(mContext, "下载完成，保存路径" + localPath, Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onFailure(final String erroInfo) {
                                                    Activity activity = (Activity) mContext;
                                                    activity.runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Log.e("下载错误", erroInfo);
                                                        }
                                                    });
                                                }
                                            }
                                    );

                                }
                            })
                            .show();
                }
            }
        }
    });
    }
}
