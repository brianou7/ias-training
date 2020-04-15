package com.ias.training.two.time.controllers;

import com.ias.training.two.time.domain.DayTime;
import com.ias.training.two.time.services.contracts.IDayTimesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class DayControllers {

    @Autowired
    private IDayTimesServices services;

    @GetMapping("times")
    public List<DayTime> getDayTimes() {
        return services.getAllDayTimes();
    }

    @PostMapping("times")
    public DayTime addDayTime(@RequestBody DayTime newItem) {
        return services.addDayTime(newItem);
    }
}
