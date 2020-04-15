package com.ias.training.two.time.repositories.contracts;

import com.ias.training.two.time.domain.DayTime;

import java.util.List;

public interface IDayTimesRepository {

    public Boolean exist(DayTime item);

    public DayTime insertOne(DayTime newItem);

    public List<DayTime> findAll();

}
