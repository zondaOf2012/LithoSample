package zonda.exercise.litho.postlist;

import android.util.Log;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Image;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaPositionType;

import zonda.exercise.litho.R;

import static android.widget.ImageView.ScaleType.CENTER_CROP;
import static android.widget.ImageView.ScaleType.FIT_XY;
import static com.facebook.yoga.YogaEdge.LEFT;
import static zonda.exercise.litho.data.PostListConstants.LOG_TAG;

/**
 * Created by zhuqiuzhu on 17/4/27.
 */

@LayoutSpec
public class ImagesComponentSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(
            ComponentContext c,
            @Prop String[] imageUrlArray) {

        Log.i(LOG_TAG, "ImagesComponentSpec onCreateLayout is run " +
                "imageUrlArray.length : " + imageUrlArray.length);

        final ComponentLayout.ContainerBuilder rootBuilder = Column.create(c)
//                .child(
//                        Row.create(c)
//                                .backgroundRes(R.color.divider_color)
//                                .heightPx(1)
//                                .widthPercent(100f)
//                )
                ;

        final ComponentLayout.ContainerBuilder imagesBuilder = Row.create(c);

        if (imageUrlArray.length > 3 || imageUrlArray.length == 1) {
            imagesBuilder
                    .child(
                            Image.create(c)
                                    .drawableRes(R.color.colorAccent)
                                    .scaleType(FIT_XY)
                                    .withLayout()
                                    .widthPercent(100f)
                                    .aspectRatio(16 / 9f)
                    );
        } else {
            final float count = Math.min(imageUrlArray.length, 3);
            for (int i = 0; i < count; i++) {
                final boolean hasLeftMargin = (i != 0);
                imagesBuilder
                        .child(
                                Image.create(c)
                                        .drawableRes(R.color.colorAccent)
                                        .scaleType(CENTER_CROP)
                                        .withLayout()
                                        .widthPercent(100 / count)
                                        .aspectRatio(1f)
                                        .flex(1)
                                        .marginDip(LEFT, hasLeftMargin ? 8 : 0)
                        );
            }
//            imagesBuilder.justifyContent(SPACE_BETWEEN);
        }

        if (imageUrlArray.length > 3) {
            imagesBuilder.child(
//                    ImageNumViewComponent.create(c)
//                            .number(String.valueOf(imageUrlArray.length))
//                            .withLayout()
//                            .positionType(YogaPositionType.ABSOLUTE)
//                            .positionDip(YogaEdge.RIGHT, 4)
//                            .positionDip(YogaEdge.BOTTOM, 4)
//                            .widthDip(20)
//                            .heightDip(20)

                    ImageNumDrawableComponent.create(c)
                            .numberText(String.valueOf(imageUrlArray.length))
                            .withLayout()
                            .positionType(YogaPositionType.ABSOLUTE)
                            .positionDip(YogaEdge.RIGHT, 4)
                            .positionDip(YogaEdge.BOTTOM, 4)
                            .widthDip(20)
                            .heightDip(20)
            );
        }

        rootBuilder.child(imagesBuilder);

        return rootBuilder.build();
    }
}
