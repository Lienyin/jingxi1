package com.jxxc.jingxi.ui.setmealpay;


import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jxxc.jingxi.R;
import com.jxxc.jingxi.entity.backparameter.RecommendComboInfoEntity;
import com.jxxc.jingxi.http.ZzRouter;
import com.jxxc.jingxi.mvp.MVPBaseActivity;
import com.jxxc.jingxi.ui.main.firstfragment.MyImgScroll;
import com.jxxc.jingxi.ui.setmealpayinfo.SetMealPayInfoActivity;
import com.jxxc.jingxi.utils.AnimUtils;
import com.jxxc.jingxi.utils.AppUtils;
import com.jxxc.jingxi.utils.MyImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class SetMealPayActivity extends MVPBaseActivity<SetMealPayContract.View, SetMealPayPresenter> implements SetMealPayContract.View {

    @BindView(R.id.tv_back)
    TextView tv_back;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.myvp)
    MyImgScroll myPager;
    @BindView(R.id.vb)
    LinearLayout ovalLayout;
    @BindView(R.id.tv_pay_set_meal_name)
    TextView tv_pay_set_meal_name;
    @BindView(R.id.tv_pay_set_meal_num)
    TextView tv_pay_set_meal_num;
    @BindView(R.id.tv_pay_set_meal_con)
    TextView tv_pay_set_meal_con;
    @BindView(R.id.tv_pay_set_meal_money)
    TextView tv_pay_set_meal_money;
    @BindView(R.id.ll_pay_set_meal)
    LinearLayout ll_pay_set_meal;
    private List<View> listViews; // 图片组
    private RecommendComboInfoEntity.RecommendCombo recommendComboInfoEntity;
    @Override
    protected int layoutId() {
        return R.layout.set_meal_pay_activity;
    }

    @Override
    public void initData() {
        tv_title.setText("套餐详情");
        recommendComboInfoEntity = ZzRouter.getIntentData(this,RecommendComboInfoEntity.RecommendCombo.class);
        if (!AppUtils.isEmpty(recommendComboInfoEntity)){
            tv_pay_set_meal_name.setText(recommendComboInfoEntity.comboName);
            tv_pay_set_meal_num.setText("已售 "+recommendComboInfoEntity.salesVolume);
            tv_pay_set_meal_con.setText(recommendComboInfoEntity.comboComment);
            tv_pay_set_meal_money.setText("￥"+recommendComboInfoEntity.totalPrice);


//            if (recommendComboInfoEntity.imgUrls.length > 0){
//                //开始滚动(默认添加一张图片)
//                myPager.start(this, listViews, 4000, ovalLayout,
//                        R.layout.ad_bottom_item, R.id.ad_item_v,
//                        R.mipmap.dot_focused, R.mipmap.dot_normal);
//
//                listViews = new ArrayList<View>(); // 图片组
//                for (int i = 0; i < recommendComboInfoEntity.imgUrls.length; i++) {
//                    MyImageView imageView = new MyImageView (this);
//                    imageView.setOnClickListener(new View.OnClickListener() {
//                        public void onClick(View v) {// 设置图片点击事件
////                    Toast.makeText(context,
////                            "点击了:" + myPager.getCurIndex(), Toast.LENGTH_SHORT)
////                            .show();
//                        }
//                    });
//                    imageView.setImageURL(recommendComboInfoEntity.imgUrls[i]);
//                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                    listViews.add(imageView);
//                }
//            }
        }
    }

    @OnClick({R.id.tv_back,R.id.ll_pay_set_meal})
    public void onViewClicked(View view) {
        AnimUtils.clickAnimator(view);
        switch (view.getId()) {
            case R.id.tv_back://返回
                finish();
                break;
            case R.id.ll_pay_set_meal://我要预约下单
                ZzRouter.gotoActivity(this, SetMealPayInfoActivity.class,recommendComboInfoEntity);
                break;
            default:
        }
    }
}
