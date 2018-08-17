package com.lmn.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lmn.R;


/**
 * 标题栏
 */
public class CustomTitleBar extends LinearLayout {

    private Boolean isLeftBtnVisible;
    private int leftResId;

    private Boolean isLeftTvVisible;
    private String leftTvText;

    private Boolean isRightBtnVisible;
    private int rightResId;
    private String rightbtnText;

    private Boolean isRightTvVisible;
    private String rightTvText;

    private Boolean isTitleVisible;
    private String titleText;

    private int backgroundResId;

    private boolean isLeftClick_Finish;
    private Context mContext;

    public CustomTitleBar(Context context) {
        this(context, null);
        mContext = context;
    }

    public CustomTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        mContext = context;
    }

    public CustomTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView(attrs);
    }

    /**
     * 初始化属性
     *
     * @param attrs
     */
    public void initView(AttributeSet attrs) {

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);
        /**-------------获取左边按钮属性------------*/
        isLeftBtnVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_left_btn_visible, false);
        isLeftClick_Finish = typedArray.getBoolean(R.styleable.CustomTitleBar_leftClick_finish, true);
        leftResId = typedArray.getResourceId(R.styleable.CustomTitleBar_left_btn_src, -1);
        /**-------------获取左边文本属性------------*/
        isLeftTvVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_left_tv_visible, false);
        if (typedArray.hasValue(R.styleable.CustomTitleBar_left_tv_text)) {
            leftTvText = typedArray.getString(R.styleable.CustomTitleBar_left_tv_text);
        }
        /**-------------获取右边按钮属性------------*/
        isRightBtnVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_right_btn_visible, false);
        rightResId = typedArray.getResourceId(R.styleable.CustomTitleBar_right_btn_src, -1);
        if (typedArray.hasValue(R.styleable.CustomTitleBar_right_btn_text)) {
            rightbtnText = typedArray.getString(R.styleable.CustomTitleBar_right_btn_text);
        }
        /**-------------获取右边文本属性------------*/
        isRightTvVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_right_tv_visible, false);
        if (typedArray.hasValue(R.styleable.CustomTitleBar_right_tv_text)) {
            rightTvText = typedArray.getString(R.styleable.CustomTitleBar_right_tv_text);
        }
        /**-------------获取标题属性------------*/
        isTitleVisible = typedArray.getBoolean(R.styleable.CustomTitleBar_title_visible, false);
        if (typedArray.hasValue(R.styleable.CustomTitleBar_title_text)) {
            titleText = typedArray.getString(R.styleable.CustomTitleBar_title_text);
        }
        /**-------------背景颜色------------*/
        backgroundResId = typedArray.getResourceId(R.styleable.CustomTitleBar_barBackground, -1);

        typedArray.recycle();

        /**-------------设置内容------------*/
        View barLayoutView = View.inflate(getContext(), R.layout.layout_common_toolbar, null);
        Button leftBtn = (Button) barLayoutView.findViewById(R.id.toolbar_left_btn);
        TextView leftTv = (TextView) barLayoutView.findViewById(R.id.toolbar_left_tv);
        TextView titleTv = (TextView) barLayoutView.findViewById(R.id.toolbar_title_tv);
        Button rightBtn = (Button) barLayoutView.findViewById(R.id.toolbar_right_btn);
        TextView rightTv = (TextView) barLayoutView.findViewById(R.id.toolbar_right_tv);
        RelativeLayout barRlyt = (RelativeLayout) barLayoutView.findViewById(R.id.toolbar_content_rlyt);

        if (isLeftBtnVisible) {
            leftBtn.setVisibility(VISIBLE);
            if (isLeftClick_Finish) {
                leftBtn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((Activity) mContext).finish();
                    }
                });
            }

        }
        if (isLeftTvVisible) {
            leftTv.setVisibility(VISIBLE);
        }
        if (isRightBtnVisible) {
            rightBtn.setVisibility(VISIBLE);
        }
        if (isRightTvVisible) {
            rightTv.setVisibility(VISIBLE);
        }
        if (isTitleVisible) {
            titleTv.setVisibility(VISIBLE);
        }
        leftTv.setText(leftTvText);
        rightTv.setText(rightTvText);
        titleTv.setText(titleText);
        rightBtn.setText(rightbtnText);
        if (leftResId != -1) {
            leftBtn.setBackgroundResource(leftResId);
        }
        if (rightResId != -1) {
            rightBtn.setBackgroundResource(rightResId);
        }
        if (backgroundResId != -1) {
            barRlyt.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }
        //将设置完成之后的View添加到此LinearLayout中
        addView(barLayoutView, 0);
    }
}
