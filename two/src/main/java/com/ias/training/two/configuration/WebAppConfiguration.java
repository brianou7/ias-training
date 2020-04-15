package com.ias.training.two.configuration;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class WebAppConfiguration implements WebMvcConfigurer {

    private final Gson gson;

    @Autowired
    public WebAppConfiguration(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter(gson);
        converters.add(gsonHttpMessageConverter);
    }
}
