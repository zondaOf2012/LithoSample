package zonda.exercise.litho.postlist;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

@LayoutSpec
public class PostListComponentSpec {

    private static final String POST_LIST_COMPONENT_KEY = "post_list_component_key";

    @OnCreateLayout
    static ComponentLayout onCreatePostListLayout(
            ComponentContext c,
            @Prop final RecyclerBinder recyclerBinder) {

//        final RecyclerBinder recyclerBinder = new RecyclerBinder(c,
//                new LinearLayoutInfo(c, OrientationHelper.VERTICAL, false));

        return Recycler.create(c)
                .binder(recyclerBinder)
                .withLayout()
                .flexShrink(0)
                .testKey(POST_LIST_COMPONENT_KEY)
                .build();
    }
}
