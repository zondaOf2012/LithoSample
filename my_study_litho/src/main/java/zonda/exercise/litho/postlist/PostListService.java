package zonda.exercise.litho.postlist;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import zonda.exercise.litho.bean.PostListResult;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public interface PostListService {

    @GET
    @NonNull
    Call<PostListResult> getPostListContent(@Url String apiUrl);
}
