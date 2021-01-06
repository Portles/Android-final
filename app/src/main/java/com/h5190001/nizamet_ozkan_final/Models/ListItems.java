package com.h5190001.nizamet_ozkan_final.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListItems {

    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Tags")
    @Expose
    private String Tags;
    @SerializedName("RelaseDate")
    @Expose
    private String RelaseDate;
    @SerializedName("Logo")
    @Expose
    private String Logo;
    @SerializedName("BigPic")
    @Expose
    private String BigPic;
    @SerializedName("Detail")
    @Expose
    private String Detail;

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getBigPic() {
        return BigPic;
    }

    public void setBigPic(String bigPic) {
        BigPic = bigPic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getRelaseDate() {
        return RelaseDate;
    }

    public void setRelaseDate(String relaseDate) {
        RelaseDate = relaseDate;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

}
