package zonda.exercise.litho.postlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zonda.exercise.litho.bean.PostsBean;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class PostListFragment extends Fragment {

    private static final String ARGS_KEY = "args_key";


    public static PostListFragment newInstance() {
        PostListFragment postListFragment = new PostListFragment();
        return postListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return null;
    }

    public void updatePostListData(ArrayList<PostsBean> postsBeen){
        Bundle argument = new Bundle();
        argument.putParcelableArrayList(ARGS_KEY, postsBeen);
        setArguments(argument);


    }
}
