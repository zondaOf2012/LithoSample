package zonda.exercise.litho.postlist;

import android.graphics.Color;
import android.support.annotation.DrawableRes;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaJustify;

import zonda.exercise.litho.R;

import static android.widget.ImageView.ScaleType.CENTER_INSIDE;
import static com.facebook.litho.annotations.ResType.INT;
import static com.facebook.litho.annotations.ResType.STRING;

/**
 * Created by zhuqiuzhu on 17/4/26.
 */
@LayoutSpec
public class ActionItemComponentSpec {

    /**
     * @param c          组件上下文
     * @param iconResId  Item 的图标资源
     * @param actionText Action 的个数
     * @return 返回帖子行为视图组件
     */
    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop(resType = INT) @DrawableRes int iconResId,
            @Prop(resType = STRING) String actionText) {

        return Row.create(c)
                .child(
                        Image.create(c)
                                .drawableRes(iconResId)
                                .scaleType(CENTER_INSIDE)
                                .withLayout()
                                .aspectRatio(1)
                                .widthRes(R.dimen.post_list_action_image_square)
                )
                .child(
                        Text.create(c)
                                .text(actionText)
                                .textSizeDip(8)
                                .textColor(Color.GRAY)
                                .withLayout()
                                .marginDip(YogaEdge.LEFT, 5)
                )
                .justifyContent(YogaJustify.CENTER)//main axis 水平主轴
                //.alignSelf()
                //.alignContent()
                .alignItems(YogaAlign.CENTER)//cross axis 垂直交叉轴
                .paddingDip(YogaEdge.ALL, 16)
                .build();
    }
}
