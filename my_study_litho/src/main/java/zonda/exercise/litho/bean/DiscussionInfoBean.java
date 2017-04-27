package zonda.exercise.litho.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

class DiscussionInfoBean {
    @SerializedName("pk")
    private String pk;
    @SerializedName("title")
    private String title;
    @SerializedName("stitle")
    private String stitle;
    @SerializedName("pic")
    private String pic;
    @SerializedName("large_pic")
    private String largePic;
    @SerializedName("api_url")
    private String apiUrl;
    @SerializedName("block_color")
    private String blockColor;
    @SerializedName("subscribe_count")
    private String subscribeCount;
    @SerializedName("post_count")
    private String postCount;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLargePic() {
        return largePic;
    }

    public void setLargePic(String largePic) {
        this.largePic = largePic;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getBlockColor() {
        return blockColor;
    }

    public void setBlockColor(String blockColor) {
        this.blockColor = blockColor;
    }

    public String getSubscribeCount() {
        return subscribeCount;
    }

    public void setSubscribeCount(String subscribeCount) {
        this.subscribeCount = subscribeCount;
    }

    public String getPostCount() {
        return postCount;
    }

    public void setPostCount(String postCount) {
        this.postCount = postCount;
    }
}
