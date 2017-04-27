package zonda.exercise.litho;

import android.app.Application;

import com.facebook.soloader.SoLoader;

/**
 * Created by zhuqiuzhu on 17/4/24.
 */

public class LithoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SoLoader.init(this, false);
    }
}
