package com.ias.training.two.time.services;

import com.ias.training.two.configuration.domain.Settings;
import com.ias.training.two.time.domain.*;
import com.ias.training.two.time.repositories.contracts.IDayTimesRepository;
import com.ias.training.two.time.services.contracts.IDayTimesServices;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class TimeServices implements IDayTimesServices {

    private Unit unit;
    private IDayTimesRepository dayTimesRepository;

    @Autowired
    public TimeServices(@Qualifier("in-memory") IDayTimesRepository dayTimesRepository, Settings settings){
        this.dayTimesRepository = dayTimesRepository;
        this.unit = settings.getUnit();
    }

    public Time getTimeNow() {
        LocalTime now = LocalTime.now();

        return Time.from(
                Hour.of(now.getHour()),
                Minute.of(now.getMinute()),
                Second.of(now.getSecond()),
                Unit.totalUnitFromMidnight(unit, now)
        );
    }

    @Override
    public DayTime addDayTime(DayTime dayTime) {
        if (dayTimesRepository.exist(dayTime)) {
            throw new IllegalArgumentException("This DayTime is already exist!");
        }

        return dayTimesRepository.insertOne(dayTime);
    }

    @Override
    public List<DayTime> getAllDayTimes() {
        return dayTimesRepository.findAll();
    }

}
