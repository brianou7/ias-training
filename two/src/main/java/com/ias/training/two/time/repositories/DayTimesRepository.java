package com.ias.training.two.time.repositories;

import com.ias.training.two.time.domain.DayTime;
import com.ias.training.two.time.repositories.contracts.IDayTimesRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("in-memory")
public class DayTimesRepository implements IDayTimesRepository {

    private List<DayTime> dayTimes = new ArrayList<>();

    @Override
    public Boolean exist(DayTime item){
        return dayTimes.contains(item);
    }

    @Override
    public DayTime insertOne(DayTime newItem) {
        dayTimes.add(newItem);
        return newItem;
    }

    @Override
    public List<DayTime> findAll() {
        return this.dayTimes;
    }

}
