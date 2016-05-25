package com.example.lzd_develop.sechandtreak.doman;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzd-develop on 16-5-1.
 */
public class OtherCommodity implements Serializable {


    public OtherCommodity() {
    }

    /**
     * commId : 商品id
     * title : 商品标题
     * seller : 卖家
     * sellerId : 卖家用户id
     * commpic : 商品图片
     * firPrice : 原价
     * secPrice : 二手价格
     */


    private List<CommBean> comm;

    private int MSG;

    public List<CommBean> getComm() {
        if (comm == null) {
            comm = new ArrayList<>();
        }
        return comm;
    }

    public void setComm(List<CommBean> comm) {
        this.comm = comm;
    }

    public int getMSG() {
        return MSG;
    }


    public static class CommBean implements Serializable {
        private int commId;
        private String title;
        private String seller;
        private String sellerPic;
        private int sellerId;
        private String commpic;
        private int firPrice;
        private int secPrice;

        public int getCommId() {
            return commId;
        }

        public void setCommId(int commId) {
            this.commId = commId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSeller() {
            return seller;
        }

        public void setSeller(String seller) {
            this.seller = seller;
        }

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public String getCommpic() {
            return commpic;
        }

        public void setCommpic(String commpic) {
            this.commpic = commpic;
        }

        public int getFirPrice() {
            return firPrice;
        }

        public void setFirPrice(int firPrice) {
            this.firPrice = firPrice;
        }

        public int getSecPrice() {
            return secPrice;
        }

        public void setSecPrice(int secPrice) {
            this.secPrice = secPrice;
        }

        public String getSellerPic() {
            return sellerPic;
        }

        public void setSellerPic(String sellerPic) {
            this.sellerPic = sellerPic;
        }
    }
}
