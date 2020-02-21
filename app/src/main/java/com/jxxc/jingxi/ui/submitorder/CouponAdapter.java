package com.jxxc.jingxi.ui.submitorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jxxc.jingxi.R;
import com.jxxc.jingxi.entity.backparameter.MyCoupon;
import com.jxxc.jingxi.utils.AppUtils;

import java.util.List;

public class CouponAdapter extends BaseAdapter {
    private Context context;
    private int defaultSelection=-1;
    private List<MyCoupon> list;

    public CouponAdapter(Context context){
        this.context=context;
    }

    public void setData(List<MyCoupon> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.coupon_adapter,null);
            holder.tv_coupon_money = convertView.findViewById(R.id.tv_coupon_money);
            holder.tv_coupon_memo = convertView.findViewById(R.id.tv_coupon_memo);
            holder.iv_coupon = convertView.findViewById(R.id.iv_coupon);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        MyCoupon data = list.get(position);
        holder.tv_coupon_money.setText(data.money+"元优惠券");
        if (!AppUtils.isEmpty(data.doorsillMoney)){
            holder.tv_coupon_memo.setText(data.doorsillMoney);
        }else{
            holder.tv_coupon_memo.setText("");
        }
        final ViewHolder finalHolder = holder;
        if (position == defaultSelection) {// 选中时设置单纯颜色
            holder.iv_coupon.setSelected(true);
        } else {// 未选中时设置selector
            holder.iv_coupon.setSelected(false);
        }
        return convertView;
    }

    class ViewHolder{
        TextView tv_coupon_money;
        TextView tv_coupon_memo;
        ImageView iv_coupon;
    }

    /**
     * @param position
     * 设置高亮状态的item
     */
    public void setSelectPosition(int position) {
        if (!(position < 0 || position > list.size())) {
            defaultSelection = position;
            notifyDataSetChanged();
        }else{
            defaultSelection = -1;
            notifyDataSetChanged();
        }
    }
}
