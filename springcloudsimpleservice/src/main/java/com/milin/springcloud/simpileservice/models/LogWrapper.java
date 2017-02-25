package com.milin.springcloud.simpileservice.models;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/2/25.
 */
public class LogWrapper extends ModelBase {

    private String[] levels;
    private Map<String, Map<String, String>> loggers;
    private static final String CONFIGURED_LEVEL = "configuredLevel";
    private static final String EFFECTIVE_LEVEL = "effectiveLevel";

    public String[] getLevels() {
        return levels;
    }

    public void setLevels(String[] levels) {
        this.levels = levels;
    }

    public Map<String, Map<String, String>> getLoggers() {
        return loggers;
    }

    public void setLoggers(Map<String, Map<String, String>> loggers) {
        this.loggers = loggers;
    }

    public List<LoggerDTO> loggerDTOList() {
        return this.getLoggers().entrySet().stream().map(entry -> {
            LoggerDTO dto = new LoggerDTO();
            dto.setPackageName(entry.getKey());
            dto.setConfiguredLevel(entry.getValue().get(CONFIGURED_LEVEL));
            dto.setEffectiveLevel(entry.getValue().get(EFFECTIVE_LEVEL));
            return dto;
        }).collect(Collectors.toList());
    }

}
