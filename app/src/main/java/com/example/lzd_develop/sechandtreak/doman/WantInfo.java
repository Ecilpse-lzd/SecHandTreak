package com.example.lzd_develop.sechandtreak.doman;

import java.util.List;

/**
 * Created by lzd-develop on 16-5-20.
 */
public class WantInfo extends Info{

    /**
     * wantId : 12
     * wantPip
     * wantTime : 1994年8月6日
     * wantTitle : 求购标题
     * wantContent : 求购内容
     * wanterId : 456
     * wanterIsVerification : true
     * wanterPic : 求购者头像
     * wantPrice : 99400
     * wantWords : [{"worldId":156,"worldWriterID":1566,"worldWriter":"留言作者","worldContent":"留言内容"}]
     */

    private int wantId;
    private String wantTime;
    private String wantTitle;
    private String wantContent;
    private int wanterId;
    private boolean wanterIsVerification;
    private String wanterPic;
    private int wantPrice;
    private String wantWriter;
    private int MSG;

    /**
     * worldId : 156
     * worldWriterID : 1566
     * worldWriter : 留言作者
     * worldContent : 留言内容
     */

    private List<WantWordsBean> wantWords;

    public int getWantId() {
        return wantId;
    }

    public void setWantId(int wantId) {
        this.wantId = wantId;
    }

    public String getWantTime() {
        return wantTime;
    }

    public void setWantTime(String wantTime) {
        this.wantTime = wantTime;
    }

    public String getWantTitle() {
        return wantTitle;
    }

    public void setWantTitle(String wantTitle) {
        this.wantTitle = wantTitle;
    }

    public String getWantContent() {
        return wantContent;
    }

    public void setWantContent(String wantContent) {
        this.wantContent = wantContent;
    }

    public int getWanterId() {
        return wanterId;
    }

    public void setWanterId(int wanterId) {
        this.wanterId = wanterId;
    }

    public boolean isWanterIsVerification() {
        return wanterIsVerification;
    }

    public void setWanterIsVerification(boolean wanterIsVerification) {
        this.wanterIsVerification = wanterIsVerification;
    }

    public String getWanterPic() {
        return wanterPic;
    }

    public void setWanterPic(String wanterPic) {
        this.wanterPic = wanterPic;
    }

    public int getWantPrice() {
        return wantPrice;
    }

    public void setWantPrice(int wantPrice) {
        this.wantPrice = wantPrice;
    }

    public List<WantWordsBean> getWantWords() {
        return wantWords;
    }

    public void setWantWords(List<WantWordsBean> wantWords) {
        this.wantWords = wantWords;
    }

    public String getWantWriter() {
        return wantWriter;
    }

    public void setWantWriter(String wantWriter) {
        this.wantWriter = wantWriter;
    }

    public int getMSG() {
        return MSG;
    }

    public void setMSG(int MSG) {
        this.MSG = MSG;
    }

    public static class WantWordsBean {
        private int worldId;
        private int worldWriterID;
        private String worldWriter;
        private String worldContent;

        public int getWorldId() {
            return worldId;
        }

        public void setWorldId(int worldId) {
            this.worldId = worldId;
        }

        public int getWorldWriterID() {
            return worldWriterID;
        }

        public void setWorldWriterID(int worldWriterID) {
            this.worldWriterID = worldWriterID;
        }

        public String getWorldWriter() {
            return worldWriter;
        }

        public void setWorldWriter(String worldWriter) {
            this.worldWriter = worldWriter;
        }

        public String getWorldContent() {
            return worldContent;
        }

        public void setWorldContent(String worldContent) {
            this.worldContent = worldContent;
        }
    }
}
