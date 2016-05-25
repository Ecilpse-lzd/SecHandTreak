package com.example.lzd_develop.sechandtreak.doman;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lzd-develop on 16-5-2.
 */
public class OtherWantBuy implements Serializable {


    /**
     * msg : 信息
     * items : [{"itemid":"条目编号","title":"标题","context":"内容","price":"价格","time":"时间","sellcount":"竞标数"}]
     */

    private int msg;
    /**
     * itemid : 条目编号
     * title : 标题
     * context : 内容
     * price : 价格
     * time : 时间
     * sellcount : 竞标数
     */

    private List<ItemBean> items;

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public List<ItemBean> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<ItemBean> items) {
        this.items = items;
    }

    public static class ItemBean implements Comparable<ItemBean>,Serializable{
        private int itemid;
        private String title;
        private String context;
        private int price;
        private String time;
        private int sellcount;

        public int getItemid() {
            return itemid;
        }

        public void setItemid(int itemid) {
            this.itemid = itemid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getSellcount() {
            return sellcount;
        }

        public void setSellcount(int sellcount) {
            this.sellcount = sellcount;
        }

        @Override
        public int compareTo(ItemBean another) {
            return (another.getPrice()-price);
        }
    }
}
