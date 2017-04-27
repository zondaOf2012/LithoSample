package zonda.exercise.litho.data;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;

/**
 * Created by zhuqiuzhu on 17/4/26.
 */

public interface Datum {

    Component createComponent(ComponentContext c);
}
