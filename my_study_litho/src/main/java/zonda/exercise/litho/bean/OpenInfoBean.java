package zonda.exercise.litho.bean;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

class OpenInfoBean implements android.os.Parcelable {
    @SerializedName("open_detail_url")
    private String openDetailUrl;

    public String getOpenDetailUrl() {
        return openDetailUrl;
    }

    public void setOpenDetailUrl(String openDetailUrl) {
        this.openDetailUrl = openDetailUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.openDetailUrl);
    }

    public OpenInfoBean() {
    }

    protected OpenInfoBean(Parcel in) {
        this.openDetailUrl = in.readString();
    }

    public static final Creator<OpenInfoBean> CREATOR = new Creator<OpenInfoBean>() {
        @Override
        public OpenInfoBean createFromParcel(Parcel source) {
            return new OpenInfoBean(source);
        }

        @Override
        public OpenInfoBean[] newArray(int size) {
            return new OpenInfoBean[size];
        }
    };
}
