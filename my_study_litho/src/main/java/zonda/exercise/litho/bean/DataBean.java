package zonda.exercise.litho.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class DataBean {
    @SerializedName("discussion_info")
    private DiscussionInfoBean discussionInfo;
    @SerializedName("info")
    private InfoBean info;
    @SerializedName("posts")
    private List<PostsBean> posts;

    public DiscussionInfoBean getDiscussionInfo() {
        return discussionInfo;
    }

    public void setDiscussionInfo(DiscussionInfoBean discussionInfo) {
        this.discussionInfo = discussionInfo;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }
}
