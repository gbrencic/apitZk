package pleasantnightmare.gui.progressbar;

import pleasantnightmare.entity.Body;
import pleasantnightmare.entity.BasicRoles;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.21
 * Time: 13:58:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractProgressBarImpl extends Body implements ProgressBar {
    private float minValue = 0;
    private float maxValue = 0;
    private float currentValue = 0;
    private float percentage = 0;

    protected AbstractProgressBarImpl(String id, int posX, int posY, BasicRoles role, float minValue, float maxValue, float currentValue) {
        super(id,posX, posY, role);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = currentValue;
        calculatePercentage();
    }

    private void calculatePercentage() {
        this.percentage = (currentValue / maxValue) * 100;
    }

    public float getMinValue() {
        return minValue;
    }

    public void setMinValue(float minValue) {
        if (minValue > maxValue || minValue < 0)
            throw new IllegalArgumentException("Min value " + minValue + " must be lower than max value " + maxValue + "and grater than 0");
        this.minValue = minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        if (maxValue < minValue)
            throw new IllegalArgumentException("Max value " + minValue + " must be lower than min value " + maxValue);
        this.maxValue = maxValue;
    }

    public float getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(float currentValue) {
        if (currentValue < minValue || currentValue > maxValue)
            throw new IllegalArgumentException("Current value " + currentValue + "must be between " + minValue + " and " + maxValue);
        this.currentValue = currentValue;
        calculatePercentage();
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
