package zonda.exercise.litho.bean;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

class SpecialInfoBean implements android.os.Parcelable {
    @SerializedName("item_type")
    private String itemType;
    @SerializedName("medias_count")
    private String mediasCount;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getMediasCount() {
        return mediasCount;
    }

    public void setMediasCount(String mediasCount) {
        this.mediasCount = mediasCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemType);
        dest.writeString(this.mediasCount);
    }

    public SpecialInfoBean() {
    }

    protected SpecialInfoBean(Parcel in) {
        this.itemType = in.readString();
        this.mediasCount = in.readString();
    }

    public static final Creator<SpecialInfoBean> CREATOR = new Creator<SpecialInfoBean>() {
        @Override
        public SpecialInfoBean createFromParcel(Parcel source) {
            return new SpecialInfoBean(source);
        }

        @Override
        public SpecialInfoBean[] newArray(int size) {
            return new SpecialInfoBean[size];
        }
    };
}
