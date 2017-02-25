package com.milin.springcloud.simpileservice.models;

/**
 * Created by Administrator on 2017/2/25.
 */
public class LoggerDTO extends  ModelBase {

    private String packageName;
    private String configuredLevel;
    private String effectiveLevel;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getConfiguredLevel() {
        return configuredLevel;
    }

    public void setConfiguredLevel(String configuredLevel) {
        this.configuredLevel = configuredLevel;
    }

    public String getEffectiveLevel() {
        return effectiveLevel;
    }

    public void setEffectiveLevel(String effectiveLevel) {
        this.effectiveLevel = effectiveLevel;
    }
}
