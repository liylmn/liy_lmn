package com.lmn.view.resources.adapter;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.lmn.BuildConfig;
import com.lmn.Entity.ResourcesMultiItemEntity0;
import com.lmn.Entity.ResourcesMultiItemEntity1;
import com.lmn.MainDataManager;
import com.lmn.R;

import java.io.File;
import java.util.List;

import io.reactivex.observers.DisposableObserver;
import lmn.com.lmnlibrary.GlobalAppComponent;
import lmn.com.lmnlibrary.imageloader.ILoader;
import lmn.com.lmnlibrary.imageloader.ImageFactory;
import lmn.com.lmnlibrary.listener.DownloadFileListener;
import okhttp3.ResponseBody;

/**
 * 作者：liy_lmn
 * 时间：2018/8/16:17:51
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class ResourcesAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    private Context context;
    private static final String TAG = "ResourcesAdapter";
    private File firstFile;
    private File dir;
    ComponentName[] excluded = new ComponentName[]{
            new ComponentName("nutstore.android", "nutstore.android.SendToNutstoreIndex"),
            new ComponentName("nutstore.android.debug", "nutstore.android.SendToNutstoreIndex"),
    };
    private static final int REQUEST_CODE_OPEN_FILE = 10;
    public ResourcesAdapter(Context context, List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_LEVEL_0:
                final ResourcesMultiItemEntity0 item0 = (ResourcesMultiItemEntity0) item;
                helper.setText(R.id.title, item0.title)
                        .setImageResource(R.id.iv, item0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        if (item0.isExpanded()) {
                            collapse(pos);
//                            ToastUtils.showShortToast("收起：" + item0.getTitle());
                        } else {
                            expand(pos);
//                            ToastUtils.showShortToast("展开：" + item0.getTitle());
                        }
                    }
                });
                if (item0.getImgurl() == null || item0.getImgurl().equals("")) {
                    helper.getView(R.id.iv_head).setVisibility(View.GONE);
                } else {
                    helper.getView(R.id.iv_head).setVisibility(View.VISIBLE);
                    ImageFactory.getLoader().loadNet((ImageView) helper.getView(R.id.iv_head), item0.getImgurl(), new ILoader.Options(R.drawable.loading_img, R.drawable.loading_img));
                }
                break;
            case TYPE_LEVEL_1:
                final ResourcesMultiItemEntity1 item1 = (ResourcesMultiItemEntity1) item;
                helper.setText(R.id.title, item1.title);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String fileUrl = Environment.getExternalStorageDirectory().getAbsolutePath() + "/zhongchetaiyuan/" + item1.getDownloadfilename();
                        final File file = new File(fileUrl);
                        if (file.exists()) {
                            MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                                    .title("打开文件")
                                    .content(((ResourcesMultiItemEntity1) item).getDownloadfilename())
                                    .positiveText("打开")
                                    .negativeText("取消")
                                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                                        @Override
                                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                            try {
                                                if (null == file || !file.exists()) {
                                                    return;
                                                }
                                              context.startActivity(getImageFileIntent(context,fileUrl));

                                            } catch (Exception e) {
                                                //没有安装第三方的软件会提示
                                                Toast toast = Toast.makeText(mContext, "没有找到打开该文件的应用程序", Toast.LENGTH_SHORT);
                                                toast.show();
                                            }
                                        }
                                    }).show();
                        } else {
                            MaterialDialog materialDialog = new MaterialDialog.Builder(context)
                                    .title("下载附件")
                                    .content(((ResourcesMultiItemEntity1) item).getDownloadfilename())
                                    .positiveText("下载")
                                    .negativeText("取消")
                                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                                        @Override
                                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                            MainDataManager.getInstance(GlobalAppComponent.getAppComponent().getDataManager()).download(((ResourcesMultiItemEntity1) item).getBaseurl() + ((ResourcesMultiItemEntity1) item).getUrl(), ((ResourcesMultiItemEntity1) item).getDownloadfilename(), new DisposableObserver<ResponseBody>() {
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
                                                            Activity activity = (Activity) context;
                                                            activity.runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    Toast.makeText(context, "开始下载", Toast.LENGTH_SHORT).show();
                                                                }
                                                            });
                                                        }

                                                        @Override
                                                        public void onProgress(final int currentLength) {
                                                            Activity activity = (Activity) context;
                                                            activity.runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    Log.e("下载进度", currentLength + "%");
                                                                }
                                                            });
                                                        }

                                                        @Override
                                                        public void onFinish(final String localPath) {
                                                            Activity activity = (Activity) context;
                                                            activity.runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    Toast.makeText(context, "下载完成，保存路径" + localPath, Toast.LENGTH_SHORT).show();
                                                                }
                                                            });
                                                        }

                                                        @Override
                                                        public void onFailure(final String erroInfo) {
                                                            Activity activity = (Activity) context;
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
                });
                break;
        }

    }

    private File getDir() {
        if (dir != null && dir.exists()) {
            return dir;
        }

        dir = new File(context.getExternalCacheDir(), "download");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    //android获取一个用于打开图片文件的intent
    public static Intent getImageFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//判断是否为Android N版本
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            uri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", new File(param));
        } else {
             uri = Uri.fromFile(new File(param));
        }
        intent.setDataAndType(uri, "*/*");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
