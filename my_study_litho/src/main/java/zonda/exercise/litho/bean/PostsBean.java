package zonda.exercise.litho.bean;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class PostsBean implements android.os.Parcelable {
    @SerializedName("pk")
    private String pk;
    @SerializedName("discussion_id")
    private String discussionId;
    @SerializedName("auther")
    private AutherBean auther;
    @SerializedName("title")
    private String title;
    @SerializedName("date")
    private String date;
    @SerializedName("content")
    private String content;
    @SerializedName("comment_count")
    private String commentCount;
    @SerializedName("hot_num")
    private String hotNum;
    @SerializedName("like_num")
    private String likeNum;
    @SerializedName("list_date")
    private String listDate;
    @SerializedName("weburl")
    private String weburl;
    @SerializedName("content_url")
    private String contentUrl;
    @SerializedName("comment_list_url")
    private String commentListUrl;
    @SerializedName("is_liked")
    private String isLiked;
    @SerializedName("additional_info")
    private AdditionalInfoBean additionalInfo;
    @SerializedName("special_info")
    private SpecialInfoBean specialInfo;
    @SerializedName("list_tip")
    private List<String> listTip;
    @SerializedName("thumbnail_medias")
    private List<ThumbnailMediasBean> thumbnailMedias;
    @SerializedName("medias")
    private List<ThumbnailMediasBean> mediasX;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(String discussionId) {
        this.discussionId = discussionId;
    }

    public AutherBean getAuther() {
        return auther;
    }

    public void setAuther(AutherBean auther) {
        this.auther = auther;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getHotNum() {
        return hotNum;
    }

    public void setHotNum(String hotNum) {
        this.hotNum = hotNum;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public String getListDate() {
        return listDate;
    }

    public void setListDate(String listDate) {
        this.listDate = listDate;
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getCommentListUrl() {
        return commentListUrl;
    }

    public void setCommentListUrl(String commentListUrl) {
        this.commentListUrl = commentListUrl;
    }

    public String getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(String isLiked) {
        this.isLiked = isLiked;
    }

    public AdditionalInfoBean getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(AdditionalInfoBean additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public SpecialInfoBean getSpecialInfo() {
        return specialInfo;
    }

    public void setSpecialInfo(SpecialInfoBean specialInfo) {
        this.specialInfo = specialInfo;
    }

    public List<String> getListTip() {
        return listTip;
    }

    public void setListTip(List<String> listTip) {
        this.listTip = listTip;
    }

    public List<ThumbnailMediasBean> getThumbnailMedias() {
        return thumbnailMedias;
    }

    public void setThumbnailMedias(List<ThumbnailMediasBean> thumbnailMedias) {
        this.thumbnailMedias = thumbnailMedias;
    }

    public List<ThumbnailMediasBean> getMediasX() {
        return mediasX;
    }

    public void setMediasX(List<ThumbnailMediasBean> mediasX) {
        this.mediasX = mediasX;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pk);
        dest.writeString(this.discussionId);
        dest.writeParcelable(this.auther, flags);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.content);
        dest.writeString(this.commentCount);
        dest.writeString(this.hotNum);
        dest.writeString(this.likeNum);
        dest.writeString(this.listDate);
        dest.writeString(this.weburl);
        dest.writeString(this.contentUrl);
        dest.writeString(this.commentListUrl);
        dest.writeString(this.isLiked);
        dest.writeParcelable(this.additionalInfo, flags);
        dest.writeParcelable(this.specialInfo, flags);
        dest.writeStringList(this.listTip);
        dest.writeList(this.thumbnailMedias);
        dest.writeList(this.mediasX);
    }

    public PostsBean() {
    }

    protected PostsBean(Parcel in) {
        this.pk = in.readString();
        this.discussionId = in.readString();
        this.auther = in.readParcelable(AutherBean.class.getClassLoader());
        this.title = in.readString();
        this.date = in.readString();
        this.content = in.readString();
        this.commentCount = in.readString();
        this.hotNum = in.readString();
        this.likeNum = in.readString();
        this.listDate = in.readString();
        this.weburl = in.readString();
        this.contentUrl = in.readString();
        this.commentListUrl = in.readString();
        this.isLiked = in.readString();
        this.additionalInfo = in.readParcelable(AdditionalInfoBean.class.getClassLoader());
        this.specialInfo = in.readParcelable(SpecialInfoBean.class.getClassLoader());
        this.listTip = in.createStringArrayList();
        this.thumbnailMedias = new ArrayList<ThumbnailMediasBean>();
        in.readList(this.thumbnailMedias, ThumbnailMediasBean.class.getClassLoader());
        this.mediasX = new ArrayList<ThumbnailMediasBean>();
        in.readList(this.mediasX, ThumbnailMediasBean.class.getClassLoader());
    }

    public static final Creator<PostsBean> CREATOR = new Creator<PostsBean>() {
        @Override
        public PostsBean createFromParcel(Parcel source) {
            return new PostsBean(source);
        }

        @Override
        public PostsBean[] newArray(int size) {
            return new PostsBean[size];
        }
    };
}
