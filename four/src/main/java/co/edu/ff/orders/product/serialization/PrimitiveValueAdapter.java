package co.edu.ff.orders.product.serialization;

import co.edu.ff.orders.common.serialization.GsonAdapter;
import co.edu.ff.orders.common.serialization.IPrimitiveSerializable;
import com.google.gson.*;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;
import java.util.function.Function;

@RequiredArgsConstructor
public class PrimitiveValueAdapter<T extends IPrimitiveSerializable<Long>, R> implements GsonAdapter<T> {

    private final Function<R, T> factory;
    private final Function<JsonElement, R> getJson;

    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return factory.apply(getJson.apply(jsonElement));
    }

    @Override
    public JsonElement serialize(T source, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(source.valueOf());
    }
}
