package zonda.exercise.litho.bean;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

class AdditionalInfoBean implements android.os.Parcelable {
    @SerializedName("title")
    private String title;
    @SerializedName("article_pk")
    private String articlePk;
    @SerializedName("author")
    private String author;
    @SerializedName("pic")
    private String pic;
    @SerializedName("open_info")
    private OpenInfoBean openInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticlePk() {
        return articlePk;
    }

    public void setArticlePk(String articlePk) {
        this.articlePk = articlePk;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public OpenInfoBean getOpenInfo() {
        return openInfo;
    }

    public void setOpenInfo(OpenInfoBean openInfo) {
        this.openInfo = openInfo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.articlePk);
        dest.writeString(this.author);
        dest.writeString(this.pic);
        dest.writeParcelable(this.openInfo, flags);
    }

    public AdditionalInfoBean() {
    }

    protected AdditionalInfoBean(Parcel in) {
        this.title = in.readString();
        this.articlePk = in.readString();
        this.author = in.readString();
        this.pic = in.readString();
        this.openInfo = in.readParcelable(OpenInfoBean.class.getClassLoader());
    }

    public static final Creator<AdditionalInfoBean> CREATOR = new Creator<AdditionalInfoBean>() {
        @Override
        public AdditionalInfoBean createFromParcel(Parcel source) {
            return new AdditionalInfoBean(source);
        }

        @Override
        public AdditionalInfoBean[] newArray(int size) {
            return new AdditionalInfoBean[size];
        }
    };
}
