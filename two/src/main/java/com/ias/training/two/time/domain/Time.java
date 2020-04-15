package com.ias.training.two.time.domain;

import lombok.Value;

@Value(staticConstructor = "from")
public class Time {

    Hour hour;
    Minute minute;
    Second second;
    Long fromMidnight;

}
