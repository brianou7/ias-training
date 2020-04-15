package com.ias.training.two.time.controllers;

import com.ias.training.two.time.domain.Time;
import com.ias.training.two.time.services.TimeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/time/")
public class TimeController {

    @Autowired
    TimeServices services;

    @GetMapping("now")
    public Time now() {
        Time time = services.getTimeNow();
        return time;
    }
}
