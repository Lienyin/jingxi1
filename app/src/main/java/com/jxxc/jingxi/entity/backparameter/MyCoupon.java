package com.jxxc.jingxi.entity.backparameter;

import java.io.Serializable;

/**
 * @authorfeisher on 2017/12/1.12:51
 * email:458079442@qq.com
 */

public class MyCoupon implements Serializable {
    public int counponId;
    public String counponName;
    public int couponRuleType;
    public int status;
    public String statusName;
    public double money;
    public double doorsillMoney;
    public double discount;
    public String startTime;
    public String endTime;
    public String useTime;
    public String createTime;

    public boolean isForbidden;

    public boolean isForbidden() {
        return isForbidden;
    }

    public void setForbidden(boolean forbidden) {
        isForbidden = forbidden;
    }
}
