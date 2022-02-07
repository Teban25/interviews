package com.quickreview.interviews.model;

import lombok.Data;

import java.util.Map;

@Data
public class InstanceDto {

    private String instanceId;
    private String imageId;
    private String instanceType;
    private String stateName;
    private String monitoringState;
    private Map<String, String> tags;
}
