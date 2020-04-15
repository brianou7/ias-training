package com.ias.training.two.time.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ias.training.two.time.domain.Hour;
import com.ias.training.two.time.serializers.HourAdapter;

public class GsonExample {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Hour.class, new HourAdapter())
                .create();

        Hour hour = Hour.of(120);
        System.out.println(hour.toString());
        System.out.println(gson.toJson(hour));
        System.out.println(gson.fromJson("12", Hour.class));

    }
}
