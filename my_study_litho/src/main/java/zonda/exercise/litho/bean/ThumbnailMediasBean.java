package zonda.exercise.litho.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class ThumbnailMediasBean {
    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("w")
    private String w;
    @SerializedName("h")
    private String h;
    @SerializedName("url")
    private String url;
    @SerializedName("m_url")
    private String mUrl;
    @SerializedName("s_url")
    private String sUrl;
    @SerializedName("min_url")
    private String minUrl;
    @SerializedName("raw_url")
    private String rawUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMUrl() {
        return mUrl;
    }

    public void setMUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getSUrl() {
        return sUrl;
    }

    public void setSUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getMinUrl() {
        return minUrl;
    }

    public void setMinUrl(String minUrl) {
        this.minUrl = minUrl;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }
}
