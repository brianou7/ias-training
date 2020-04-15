package com.ias.training.two.time.serializers;

import com.google.gson.*;
import com.ias.training.two.time.domain.Second;

import java.lang.reflect.Type;

public class SecondAdapter implements JsonDeserializer<Second>, JsonSerializer<Second> {

    @Override
    public Second deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Second.of(jsonElement.getAsInt());
    }

    @Override
    public JsonElement serialize(Second second, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(second.getValue());
    }
}
