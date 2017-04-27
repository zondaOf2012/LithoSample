package zonda.exercise.litho.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zonda.exercise.litho.postlist.PostListService;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class AppApiClient {

    private final static AppApiClient INSTANCE_CLIENT = new AppApiClient();

    private final Retrofit mAppRetrofit;

    private PostListService mPostListService;

    private AppApiClient() {
        mAppRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static PostListService getPostListService() {
        return INSTANCE_CLIENT.createPostListService();
    }

    private PostListService createPostListService() {
        if (mPostListService == null) {
            mPostListService = mAppRetrofit.create(PostListService.class);
        }
        return mPostListService;
    }
}
