package lmn.com.lmnlibrary.base;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import lmn.com.lmnlibrary.R;
import lmn.com.lmnlibrary.imageloader.ILoader;
import lmn.com.lmnlibrary.imageloader.ImageFactory;

/**
 * 作者：liy_lmn
 * 时间：2018/5/17:16:53
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class BaseEntity {
    /**
     * 使用ImageLoader显示图片
     * @param imageView
     * @param url
     */
    @BindingAdapter({"imageUrl"})
    public static void imageLoader(ImageView imageView, String url) {
        ImageFactory.getLoader().loadNet(imageView,
                url, new ILoader.Options(R.drawable.loading_img, R.drawable.loading_img));
    }
}
