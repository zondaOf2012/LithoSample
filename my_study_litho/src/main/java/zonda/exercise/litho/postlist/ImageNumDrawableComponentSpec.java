package zonda.exercise.litho.postlist;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.Log;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Output;
import com.facebook.litho.Size;
import com.facebook.litho.SizeSpec;
import com.facebook.litho.annotations.FromPrepare;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.OnPrepare;
import com.facebook.litho.annotations.Prop;

import zonda.exercise.litho.R;

import static android.R.attr.width;
import static zonda.exercise.litho.data.PostListConstants.LOG_TAG;

/**
 * Created by zhuqiuzhu on 17/4/28.
 */

@MountSpec
public class ImageNumDrawableComponentSpec {

    @OnPrepare
    static void onPrepare(ComponentContext context,
                          Output<Integer> bgColor,
                          Output<Integer> numberColor,
                          Output<Integer> numberTextSize) {
        bgColor.set(Color.BLACK);
        numberColor.set(Color.WHITE);
        numberTextSize.set(context.getResources()
                .getDimensionPixelSize(R.dimen.post_image_num_size));

        Log.i(LOG_TAG, "ImageNumDrawableComponentSpec onPrepare");
    }

    @OnMeasure
    static void onMeasure(
            ComponentContext context,
            ComponentLayout layout,
            int widthSpec,
            int heightSpec,
            Size size) {
        Log.i(LOG_TAG, "ImageNumDrawableComponentSpec onMeasure ");
        // If width is undefined, set default size.
        if (SizeSpec.getMode(widthSpec) == SizeSpec.UNSPECIFIED) {
            size.width = 40;
        } else {
            size.width = SizeSpec.getSize(widthSpec);
        }

        // If height is undefined, use 1.5 aspect ratio.
        if (SizeSpec.getMode(heightSpec) == SizeSpec.UNSPECIFIED) {
            size.height = (int) (width * 1.5);
        } else {
            size.height = SizeSpec.getSize(heightSpec);
        }
    }

//    @OnMeasure
//    static void onMeasure(
//            ComponentContext c,
//            ComponentLayout layout,
//            int widthSpec,
//            int heightSpec,
//            Size size) {
//
//        Log.i(LOG_TAG, "ImageNumDrawableComponentSpec onMeasure ");
//
//        Log.i(LOG_TAG, "ImageNumDrawableComponentSpec onMeasure : \n"
//                + " layout.getWidth(): " + layout.getWidth()
//                + " layout.getHeight(): " + layout.getHeight()
//        + " \nSizeSpec.getSize(widthSpec): " + SizeSpec.getSize(widthSpec)
//        + " SizeSpec.getSize(heightSpec): " + SizeSpec.getSize(heightSpec)
//        + " size.height: " + size.height
//        + " size.width: " + size.width);
//
//        MeasureUtils.measureWithAspectRatio(
//                widthSpec,
//                heightSpec,
//                1,
//                size);
//
//    }

    @OnCreateMountContent
    static ImageNumDrawable onCreateMountContent(ComponentContext c) {
        return new ImageNumDrawable();
    }

    @OnMount
    static void onMount(ComponentContext c, ImageNumDrawable imageNumDrawable,
                        @FromPrepare int bgColor, @FromPrepare int numberColor,
                        @FromPrepare int numberTextSize,
                        @Prop(optional = true) String numberText) {
        imageNumDrawable.init(bgColor, numberColor, numberTextSize, numberText);
    }

    public static class ImageNumDrawable extends Drawable {

        private final Paint mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final TextPaint mNumberPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        private final Rect mNumberBounds = new Rect();
        private String mNumberText;

        ImageNumDrawable() {

        }

        public void init(@ColorInt int bgColor, @ColorInt int numberColor,
                         float numberSize, String numberText) {
            mNumberPaint.setColor(numberColor);
            mNumberPaint.setTextSize(numberSize);
            mBgPaint.setColor(bgColor);
            mNumberText = numberText;
        }

        @Override
        public void draw(@NonNull Canvas canvas) {

            if (mNumberText == null) {
                return;
            }

            final int width = canvas.getWidth();
            final int height = canvas.getHeight();

            Log.i(LOG_TAG, "ImageNumDrawableComponentSpec width: " + width
                    + " height: " + height);

            final int squareLen = Math.min(width, height);

            canvas.drawCircle(width / 2f, height / 2f,
                    squareLen / 2f, mBgPaint);

            FontMetrics fontMetrics = mNumberPaint.getFontMetrics();
            final float lineHeight = fontMetrics.descent - fontMetrics.ascent;
            final float startY = (squareLen - lineHeight) / 2f - fontMetrics.ascent;

            Log.i(LOG_TAG, "ImageNumDrawableComponentSpec lineHeight: " + lineHeight
                    + " squareLen: " + squareLen + " startY: " + startY
                    + " fontMetrics.descent: " + fontMetrics.descent
                    + " fontMetrics.ascent: " + fontMetrics.ascent);

            mNumberPaint.getTextBounds(mNumberText, 0, mNumberText.length(), mNumberBounds);
            final float startX = (squareLen - mNumberBounds.width()) / 2f;
            canvas.drawText(mNumberText, startX, startY, mNumberPaint);
        }

        @Override
        public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

            //no-op
        }

        @Override
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            //no-op
        }

        @Override
        public int getOpacity() {
            return PixelFormat.OPAQUE;
        }

//        /**
//         * Gets the opacity from a color. Inspired by Android ColorDrawable.
//         *
//         * @param color
//         * @return opacity expressed by one of PixelFormat constants
//         */
//        public static int getOpacityFromColor(int color) {
//            int colorAlpha = color >>> 24;
//            if (colorAlpha == 255) {
//                return PixelFormat.OPAQUE;
//            } else if (colorAlpha == 0) {
//                return PixelFormat.TRANSPARENT;
//            } else {
//                return PixelFormat.TRANSLUCENT;
//            }
//        }
    }
}
