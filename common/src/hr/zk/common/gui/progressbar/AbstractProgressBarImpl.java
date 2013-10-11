package hr.zk.common.gui.progressbar;

import hr.zk.common.entity.DefaultEntity;
import hr.zk.common.entity.Role;

/**
 * Created by IntelliJ IDEA.
 * User: gbrencic
 * Date: 2010.04.21
 * Time: 13:58:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractProgressBarImpl extends DefaultEntity implements ProgressBar {
    private float minValue;
    private float maxValue;
    private float currentValue = 0;
    private float percentage = 0;

    protected AbstractProgressBarImpl(Long id, String name, int posX, int posY, Role role, float minValue, float maxValue, float currentValue) {
        super(id, name, posX, posY, role);
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
