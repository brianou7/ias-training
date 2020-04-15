package com.ias.training.two.time.services.contracts;

import com.ias.training.two.time.domain.DayTime;

import java.util.List;

public interface IDayTimesServices {

    public DayTime addDayTime(DayTime dayTime);

    public List<DayTime> getAllDayTimes();

}
