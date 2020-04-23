package co.edu.ff.orders.product.serialization;

import co.edu.ff.orders.common.serialization.GsonAdapter;
import co.edu.ff.orders.common.serialization.IPrimitiveSerializable;
import com.google.gson.*;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.function.Function;

@RequiredArgsConstructor
public class BigDecimalValueAdapter<T extends IPrimitiveSerializable<BigDecimal>> implements GsonAdapter<T> {

    private final Function<BigDecimal, T> factory;

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return factory.apply(json.getAsBigDecimal());
    }

    @Override
    public JsonElement serialize(T source, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(source.valueOf());
    }

}
