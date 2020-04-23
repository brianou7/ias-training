package co.edu.ff.orders.product.serialization;

import co.edu.ff.orders.common.serialization.GsonAdapter;
import co.edu.ff.orders.common.serialization.IPrimitiveSerializable;
import com.google.gson.*;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;
import java.util.function.Function;

@RequiredArgsConstructor
public class StringValueAdapter<T extends IPrimitiveSerializable<String>> implements GsonAdapter<T> {

    Function<String, T> factory;

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return factory.apply(json.getAsString());
    }

    @Override
    public JsonElement serialize(T source, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(source.valueOf());
    }
}
