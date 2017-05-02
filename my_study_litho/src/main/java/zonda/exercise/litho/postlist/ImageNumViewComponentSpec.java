package zonda.exercise.litho.postlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;

import zonda.exercise.litho.R;

import static com.facebook.litho.annotations.ResType.STRING;
import static zonda.exercise.litho.data.PostListConstants.LOG_TAG;

/**
 * Created by zhuqiuzhu on 17/4/28.
 */

@MountSpec
public class ImageNumViewComponentSpec {

    @OnCreateMountContent
    static ImageNumView onCreateMountContent(ComponentContext c) {
        return new ImageNumView(c);
    }

    @OnMount
    static void onMount(
            ComponentContext c,
            ImageNumView imageNumView,
            @Prop(resType = STRING) String number) {
        imageNumView.setNumber(number);
    }

    public static class ImageNumView extends View {

        private String number;

        //private int circleBgColor;

        private TextPaint textPaint;
        private Paint circleBgPaint;

        private Rect numberBounds = new Rect();

        public ImageNumView(Context context) {
            super(context);
            init();
        }

        public ImageNumView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
            textPaint.setColor(Color.WHITE);
            textPaint.setTextSize(getResources()
                    .getDimensionPixelSize(R.dimen.post_image_num_size));

            circleBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            circleBgPaint.setColor(Color.BLACK);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);

            final int width = canvas.getWidth();
            final int height = canvas.getHeight();

            final int squareLen = Math.min(width, height);

            canvas.drawCircle(width / 2f, height / 2f,
                    squareLen / 2f, circleBgPaint);

            FontMetrics fontMetrics = textPaint.getFontMetrics();
            final float lineHeight = fontMetrics.descent - fontMetrics.ascent;
            final float startY = (squareLen - lineHeight) / 2f - fontMetrics.ascent;

            Log.i(LOG_TAG, "ImageNumViewComponentSpec lineHeight: " + lineHeight
                    + " squareLen: " + squareLen + " startY: " + startY
                    + " fontMetrics.descent: " + fontMetrics.descent
                    + " fontMetrics.ascent: " + fontMetrics.ascent);

            textPaint.getTextBounds(number, 0, number.length(), numberBounds);
            final float startX = (squareLen - numberBounds.width()) / 2f;
            canvas.drawText(number, startX, startY, textPaint);
        }

        public void setNumber(String number) {
            this.number = number;
            invalidate();
        }
    }
}
