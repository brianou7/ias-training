package co.edu.ff.orders.product.serialization;

import co.edu.ff.orders.common.serialization.GsonAdapter;
import co.edu.ff.orders.common.serialization.IPrimitiveSerializable;
import com.google.gson.*;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.function.Function;

@RequiredArgsConstructor
public class IntegerValueAdapter<T extends IPrimitiveSerializable<Integer>> implements GsonAdapter<T> {

    private final Function<Integer, T> factory;

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return factory.apply(json.getAsInt());
    }

    @Override
    public JsonElement serialize(T source, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(source.valueOf());
    }

}
