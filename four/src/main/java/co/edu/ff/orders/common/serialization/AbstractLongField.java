package co.edu.ff.orders.common.serialization;

import com.google.gson.JsonElement;

public abstract class AbstractLongField extends AbstractNotNullField {

    protected AbstractLongField(Long value) {
        super(value);
    }

    public static Long getJsonValue(JsonElement jsonElement) {
        return jsonElement.getAsLong();
    }
}
