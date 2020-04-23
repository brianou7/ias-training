package co.edu.ff.orders.product.serialization;

import co.edu.ff.orders.common.serialization.GsonAdapter;
import co.edu.ff.orders.common.serialization.IPrimitiveSerializable;
import com.google.gson.*;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.lang.reflect.Type;
import java.util.function.Function;

@RequiredArgsConstructor
public class LongValueAdapter<T extends IPrimitiveSerializable<Long>> implements GsonAdapter<T> {

    private final Function<Long, T> factory;

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return factory.apply(json.getAsLong());
    }

    @Override
    public JsonElement serialize(T source, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(source.valueOf());
    }

}
