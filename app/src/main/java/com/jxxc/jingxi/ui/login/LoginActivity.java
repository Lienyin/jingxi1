package com.jxxc.jingxi.ui.login;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hss01248.dialog.StyledDialog;
import com.jxxc.jingxi.http.ZzRouter;
import com.jxxc.jingxi.ui.main.MainActivity;
import com.jxxc.jingxi.utils.AnimUtils;
import com.jxxc.jingxi.R;
import com.jxxc.jingxi.mvp.MVPBaseActivity;
import com.jxxc.jingxi.utils.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 登录
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    @BindView(R.id.btn_qiye)
    Button btn_qiye;
    @BindView(R.id.btn_geren)
    Button btn_geren;
    @BindView(R.id.tv_msg_login)
    TextView tv_msg_login;
    @BindView(R.id.tv_pw_login)
    TextView tv_pw_login;
    @BindView(R.id.gerenView)
    View gerenView;
    @BindView(R.id.qiyeView)
    View qiyeView;
    @BindView(R.id.msgView)
    View msgView;

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
}

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_qiye,R.id.btn_geren,R.id.tv_msg_login,R.id.tv_pw_login})
    public void onViewClicked(View view) {
        AnimUtils.clickAnimator(view);
        switch (view.getId()) {
            case R.id.btn_qiye://企业用户
                gerenView.setVisibility(View.GONE);
                qiyeView.setVisibility(View.VISIBLE);
                msgView.setVisibility(View.GONE);
                break;
            case R.id.btn_geren://个人用户
                gerenView.setVisibility(View.VISIBLE);
                qiyeView.setVisibility(View.GONE);
                msgView.setVisibility(View.GONE);
                break;
            case R.id.tv_msg_login://短信验证码
                gerenView.setVisibility(View.GONE);
                qiyeView.setVisibility(View.GONE);
                msgView.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_pw_login://账户密码登录
                gerenView.setVisibility(View.VISIBLE);
                qiyeView.setVisibility(View.GONE);
                msgView.setVisibility(View.GONE);
                break;
            default:
        }
    }

    @Override
    public void loginCallBack() {
        ZzRouter.gotoActivity(this, MainActivity.class);
    }
}
