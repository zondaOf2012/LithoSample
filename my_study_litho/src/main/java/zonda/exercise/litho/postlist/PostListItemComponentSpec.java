package zonda.exercise.litho.postlist;

import android.graphics.Color;
import android.support.annotation.NonNull;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;

import zonda.exercise.litho.R;
import zonda.exercise.litho.bean.PostsBean;

/**
 * Created by zhuqiuzhu on 17/4/26.
 */

@LayoutSpec
public class PostListItemComponentSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop @NonNull PostsBean postsBean) {

        return Column.create(c)
                .child(
                        LandlordComponent.create(c)
                                .autherBean(postsBean.getAuther())
                                .date(postsBean.getDate())
                )
                .child(
                        Text.create(c)
                                .textColor(Color.BLACK)
                                .text(postsBean.getContent())
                                .textSizeRes(R.dimen.content_text_size)
                                .withLayout()
                                .paddingRes(YogaEdge.LEFT, R.dimen.avatar_margin)
                                .paddingRes(YogaEdge.RIGHT, R.dimen.avatar_margin)
                                .paddingRes(YogaEdge.BOTTOM, R.dimen.avatar_margin)
                )
                .child(
                        ImagesComponent.create(c)
                                .imageUrlArray(new String[80])
                )
                .child(
                        Row.create(c)
                                .backgroundRes(R.color.divider_color)
                                .heightPx(1)
                                .widthPercent(80f)
                                .alignSelf(YogaAlign.CENTER)
                )
                .child(
                        ActionsComponent.create(c)
                                .commentNum(postsBean.getCommentCount())
                                .hotNum(postsBean.getHotNum())
                                .likeNum(postsBean.getLikeNum())
                )
                .build();
    }

}
