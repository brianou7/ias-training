package com.ias.training.two.time.serializers;

import com.google.gson.*;
import com.ias.training.two.time.domain.Minute;

import java.lang.reflect.Type;

public class MinuteAdapter implements JsonDeserializer<Minute>, JsonSerializer<Minute> {

    @Override
    public Minute deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Minute.of(jsonElement.getAsInt());
    }

    @Override
    public JsonElement serialize(Minute minute, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(minute.getValue());
    }
}
