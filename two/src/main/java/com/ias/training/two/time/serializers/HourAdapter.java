package com.ias.training.two.time.serializers;

import com.google.gson.*;
import com.ias.training.two.time.domain.Hour;

import java.lang.reflect.Type;

public class HourAdapter implements JsonDeserializer<Hour>, JsonSerializer<Hour> {

    @Override
    public Hour deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Hour.of(jsonElement.getAsInt());
    }

    @Override
    public JsonElement serialize(Hour hour, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(hour.getValue());
    }
}
