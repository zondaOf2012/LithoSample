package zonda.exercise.litho.bean;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class AutherBean implements android.os.Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("uid")
    private String uid;
    @SerializedName("icon")
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.uid);
        dest.writeString(this.icon);
    }

    public AutherBean() {
    }

    protected AutherBean(Parcel in) {
        this.name = in.readString();
        this.uid = in.readString();
        this.icon = in.readString();
    }

    public static final Creator<AutherBean> CREATOR = new Creator<AutherBean>() {
        @Override
        public AutherBean createFromParcel(Parcel source) {
            return new AutherBean(source);
        }

        @Override
        public AutherBean[] newArray(int size) {
            return new AutherBean[size];
        }
    };
}
