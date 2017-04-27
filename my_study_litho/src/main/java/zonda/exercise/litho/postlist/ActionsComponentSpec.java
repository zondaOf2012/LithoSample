package zonda.exercise.litho.postlist;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.yoga.YogaAlign;

import zonda.exercise.litho.R;

import static com.facebook.litho.annotations.ResType.STRING;

/**
 * Created by zhuqiuzhu on 17/4/26.
 */

@LayoutSpec
public class ActionsComponentSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop(resType = STRING) String hotNum,
            @Prop(resType = STRING) String commentNum,
            @Prop(resType = STRING) String likeNum) {

        return Row.create(c)
                .child(
                        ActionItemComponent.create(c)
                                .actionText(hotNum)
                                .iconResId(android.R.drawable.btn_star)
                                .withLayout()
                                .flex(1)
                )
                .child(
                        Row.create(c)
                                .widthPx(1)
                                .heightDip(20)
                                .backgroundRes(R.color.divider_color)
                )
                .child(
                        ActionItemComponent.create(c)
                                .actionText(commentNum)
                                .iconResId(android.R.drawable.btn_star)
                                .withLayout()
                                .flex(1)
                )
                .child(
                        Row.create(c)
                                .widthPx(1)
                                .heightDip(20)
                                .backgroundRes(R.color.divider_color)
                )
                .child(
                        ActionItemComponent.create(c)
                                .actionText(likeNum)
                                .iconResId(android.R.drawable.btn_star)
                                .withLayout()
                                .flex(1)
                )
                .alignItems(YogaAlign.CENTER)
                .build();
    }
}
