package zonda.exercise.litho.postlist;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zonda.exercise.litho.BaseActivity;
import zonda.exercise.litho.R;
import zonda.exercise.litho.bean.DataBean;
import zonda.exercise.litho.bean.PostListResult;
import zonda.exercise.litho.bean.PostsBean;
import zonda.exercise.litho.data.AppApiClient;
import zonda.exercise.litho.data.PostListConstants;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class PostListActivity extends BaseActivity {

    private PostListFragment mContentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_base_content);
        if (savedInstanceState == null) {
            mContentFragment = PostListFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.base_content, mContentFragment,
                            PostListFragment.class.getName())
                    .commitNow();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Call<PostListResult> result = AppApiClient.getPostListService()
                .getPostListContent(PostListConstants.TEST_API);

        result.enqueue(new Callback<PostListResult>() {
            @Override
            public void onResponse(Call<PostListResult> call, Response<PostListResult> response) {

                if (response == null || !response.isSuccessful()) {
                    return;
                }
                PostListResult postListResult = response.body();
                if (postListResult == null) {
                    return;
                }
                DataBean dataBean = postListResult.getData();
                if (dataBean == null) {
                    return;
                }
                List<PostsBean> postsBeen = dataBean.getPosts();
                if (postsBeen == null) {
                    return;
                }
                mContentFragment.updatePostListData(new ArrayList<>(postsBeen));
            }

            @Override
            public void onFailure(Call<PostListResult> call, Throwable t) {

            }
        });

    }
}





