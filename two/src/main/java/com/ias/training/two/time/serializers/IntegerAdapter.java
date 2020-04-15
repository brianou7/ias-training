package com.ias.training.two.time.serializers;

import com.google.gson.*;
import com.ias.training.two.time.serializers.contracts.GsonAdapater;
import com.ias.training.two.time.serializers.contracts.IntegerSerializable;

import java.lang.reflect.Type;
import java.util.function.Function;

public class IntegerAdapter<T extends IntegerSerializable> implements GsonAdapater<T> {

    private final Function<Integer, T> factory;

    public IntegerAdapter(Function<Integer, T> factory) {
        this.factory = factory;
    }

    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return factory.apply(jsonElement.getAsInt());
    }

    @Override
    public JsonElement serialize(T source, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(source.valueOf());
    }
}
