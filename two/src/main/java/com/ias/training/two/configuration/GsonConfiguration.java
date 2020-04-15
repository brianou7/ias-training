package com.ias.training.two.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ias.training.two.time.domain.Hour;
import com.ias.training.two.time.domain.Minute;
import com.ias.training.two.time.domain.Second;
import com.ias.training.two.time.serializers.HourAdapter;
import com.ias.training.two.time.serializers.IntegerAdapter;
import com.ias.training.two.time.serializers.MinuteAdapter;
import com.ias.training.two.time.serializers.SecondAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson gson() {

        /*Function<Integer, Hour> factory = new Function<Integer, Hour>() {
            @Override
            public Hour apply(Integer integer) {
                return Hour.of(integer);
            }
        };*/
        //Function<Integer, Hour> factory = integer -> Hour.of(integer);
        //Function<Integer, Hour> factory = Hour::of;

        return new GsonBuilder()
                //.registerTypeAdapter(Hour.class, new IntegerAdapter<Hour>(factory))
                .registerTypeAdapter(Hour.class, new IntegerAdapter<>(Hour::of))
                .registerTypeAdapter(Minute.class, new MinuteAdapter())
                .registerTypeAdapter(Second.class, new SecondAdapter())
                .create();
    }
}
