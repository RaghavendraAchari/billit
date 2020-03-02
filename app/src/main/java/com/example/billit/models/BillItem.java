package com.example.billit.models;

public class BillItem {
    public int mId;
    public String mTitle;
    private String mImagePath;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String mSubTitle) {
        this.mSubTitle = mSubTitle;
    }

    public String mSubTitle;

    public BillItem(){}

    public BillItem(int id, String title, String subTitle){
        this.mId = id;
        this.mTitle = title;
        this.mSubTitle = subTitle;
    }


}
