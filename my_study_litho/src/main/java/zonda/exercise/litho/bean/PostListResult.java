package zonda.exercise.litho.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class PostListResult {


    @SerializedName("stat")
    private String stat;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBean data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
}
