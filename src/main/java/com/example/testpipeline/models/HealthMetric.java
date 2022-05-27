package com.example.testpipeline.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HealthMetric {

    private DeviceType deviceType;
    private int DeviceId;
    private int val;
}
