package zonda.exercise.litho.postlist;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.ImageView.ScaleType;

import com.facebook.litho.Column;
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

import zonda.exercise.litho.R;
import zonda.exercise.litho.bean.AutherBean;

import static com.facebook.litho.annotations.ResType.STRING;

/**
 * Created by zhuqiuzhu on 17/4/26.
 */
@LayoutSpec
public class LandlordComponentSpec {

    public final static String AVATAR_KEY = "avatar_key";

    public final static String LANDLORD_NAME_KEY = "landlord_name_key";

    public final static String POST_PUBLISH_DATE_KEY = "post_publish_date_key";


    /**
     * 创建帖子列表的楼主信息的 Spec
     *
     * @param c          组件上下文
     * @param autherBean 楼主信息
     * @param date       帖子发布日期
     * @return 返回楼主信息的布局
     */
    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop @NonNull AutherBean autherBean,
            @Prop(resType = STRING) @NonNull String date) {

        return Row.create(c)
                .child(
                        Image.create(c)
                                .key(AVATAR_KEY)
                                .scaleType(ScaleType.FIT_XY)
                                .drawableRes(R.mipmap.ic_launcher)
                                .withLayout()
                                .widthRes(R.dimen.avatar_square)
                                .heightRes(R.dimen.avatar_square)
                                .aspectRatio(1f)
                                .alignSelf(YogaAlign.CENTER)
                                .marginRes(YogaEdge.ALL, R.dimen.avatar_margin)
                )
                .child(
                        Column.create(c)
                                .child(
                                        Text.create(c)
                                                .key(LANDLORD_NAME_KEY)
                                                .text(autherBean.getName())
                                                .textColor(Color.BLUE)
                                                .textSizeRes(R.dimen.landlord_name_text_size)
                                                .withLayout()
                                                .alignSelf(YogaAlign.FLEX_START)
                                )
                                .child(
                                        Text.create(c)
                                                .key(POST_PUBLISH_DATE_KEY)
                                                .text(date)
                                                .textColor(Color.GRAY)
                                                .textSizeRes(R.dimen.post_publish_date_text_size)
                                                .withLayout()
                                )
                                .alignSelf(YogaAlign.CENTER)

                )
                .build();
    }
}
