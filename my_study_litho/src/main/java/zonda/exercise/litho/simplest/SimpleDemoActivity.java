package zonda.exercise.litho.simplest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;

import java.util.ArrayList;
import java.util.List;

import zonda.exercise.litho.R;
import zonda.exercise.litho.bean.AutherBean;
import zonda.exercise.litho.bean.PostsBean;
import zonda.exercise.litho.bean.ThumbnailMediasBean;
import zonda.exercise.litho.postlist.PostListItemComponent;

public class SimpleDemoActivity extends AppCompatActivity {

    public final static String FLAG_KEY = "flag_key";

    public final static int FLAG_HELLO_WORLD = 1;

    public final static int FLAG_LITHO_ITEM = 2;

    public final static int FLAG_LAYOUT_ITEM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int flag = getIntent().getIntExtra(FLAG_KEY, -1);

        flag = FLAG_LITHO_ITEM;

        switch (flag) {
            case FLAG_HELLO_WORLD:
                helloWorld();
                break;
            case FLAG_LITHO_ITEM:
                createItemContent();
                break;
            case FLAG_LAYOUT_ITEM:
            default:
                setContentView(R.layout.activity_item_demo);
                break;
        }
    }

    private void createItemContent() {

        final ComponentContext c = new ComponentContext(this);
        final LithoView lithoView = LithoView.create(this,
                PostListItemComponent.create(c)
                        .postsBean(createTestPostsBean())
                        .build()
        );
        setContentView(lithoView);
    }

    private void helloWorld() {
        final ComponentContext c = new ComponentContext(this);

        final LithoView lithoView = LithoView.create(this,
                Text.create(c)
                        .text("Hello world!")
                        .textSizeDip(18)
                        .build()
        );
        setContentView(lithoView);
    }

    PostsBean createTestPostsBean() {
        PostsBean postsBean = new PostsBean();
        postsBean.setCommentCount("5");
        postsBean.setHotNum("9000");
        postsBean.setLikeNum("100");
        postsBean.setDate(getString(R.string.test_post_date));
        postsBean.setContent(getString(R.string.test_post_content));

        AutherBean autherBean = new AutherBean();
        autherBean.setName("zonda");
        postsBean.setAuther(autherBean);

        List<ThumbnailMediasBean> mediasBeen = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mediasBeen.add(new ThumbnailMediasBean());
        }
        postsBean.setThumbnailMedias(mediasBeen);

        return postsBean;
    }
}
