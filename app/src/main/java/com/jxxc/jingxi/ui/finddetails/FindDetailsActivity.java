package com.jxxc.jingxi.ui.finddetails;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.jxxc.jingxi.R;
import com.jxxc.jingxi.entity.backparameter.AppreciateEntity;
import com.jxxc.jingxi.entity.backparameter.FindEntity;
import com.jxxc.jingxi.http.ZzRouter;
import com.jxxc.jingxi.mvp.MVPBaseActivity;
import com.jxxc.jingxi.utils.AnimUtils;
import com.jxxc.jingxi.utils.AppUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class FindDetailsActivity extends MVPBaseActivity<FindDetailsContract.View, FindDetailsPresenter> implements FindDetailsContract.View {

    @BindView(R.id.tv_back)
    TextView tv_back;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.find_details_context)
    WebView find_details_context;
    @BindView(R.id.tv_num_data)
    TextView tv_num_data;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_title_faxian)
    TextView tv_title_faxian;
    @BindView(R.id.tv_time_faxian)
    TextView tv_time_faxian;
    private String findId = "";
    private String findContent="";
    private String appreciateNum = "";
    private String type = "";
    private FindEntity findEntity;

    @Override
    protected int layoutId() {
        return R.layout.find_details_activity;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initData() {
        tv_title.setText("详情");
        findEntity = ZzRouter.getIntentData(this,FindEntity.class);
        findId = findEntity.noticeId;
        findContent = findEntity.content;
        type = findEntity.type;
        tv_num_data.setText(findEntity.appreciateNum);//点赞数
        tv_title_faxian.setText(findEntity.title);
        tv_time_faxian.setText(findEntity.createTime);

        find_details_context.getSettings().setJavaScriptEnabled(true);
        WebSettings settings = find_details_context.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        settings.setUseWideViewPort(true);
//        settings.setLoadWithOverviewMode(true);

        find_details_context.getSettings().setDefaultTextEncodingName("UTF-8");//设置默认为utf-8
        find_details_context.loadData(findContent.replace("\\",""),"text/html;charset=UTF-8", null);

        if ("1".equals(type)){
            tv_type.setText("文章标签：经验/观点");
        }else if ("2".equals(type)){
            tv_type.setText("文章标签：爱车养护");
        }else if ("3".equals(type)){
            tv_type.setText("文章标签：教程");
        }else{
            tv_type.setText("文章标签：推荐");
        }
    }

    @OnClick({R.id.tv_back,R.id.tv_num_data})
    public void onViewClicked(View view) {
        AnimUtils.clickAnimator(view);
        switch (view.getId()) {
            case R.id.tv_back://返回
                finish();
                break;
            case R.id.tv_num_data://点赞
                mPresenter.appreciate(findId);
                break;
            default:
        }
    }

    //点赞返回数据
    @Override
    public void appreciateCallBack(AppreciateEntity data) {
        tv_num_data.setText(data.appreciateNum);
    }
}
