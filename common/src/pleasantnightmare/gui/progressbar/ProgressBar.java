package pleasantnightmare.gui.progressbar;

import pleasantnightmare.graphics.Animatable;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.21
 * Time: 13:59:04
 * To change this template use File | Settings | File Templates.
 */
public interface ProgressBar extends Animatable {
    float getMinValue();

    void setMinValue(float minValue);

    float getMaxValue();

    void setMaxValue(float maxValue);

    float getCurrentValue();

    void setCurrentValue(float currentValue);

    float getPercentage();

    void setPercentage(float percentage);
}
