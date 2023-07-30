package com.muyun.mysqldemo.criteria;

import lombok.Data;

import java.time.Instant;


@Data
public class LogCriteria extends UserCriteria {

    private String operation;

    private Instant startTime;

    private Instant endTime;
}
