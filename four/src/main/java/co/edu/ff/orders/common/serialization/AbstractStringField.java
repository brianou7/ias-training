package co.edu.ff.orders.common.serialization;

import com.google.gson.JsonElement;

public abstract class AbstractStringField extends AbstractNotNullField {

    protected AbstractStringField(String value) {
        super(value);
    }

    public static String getJsonValue(JsonElement jsonElement) {
        return jsonElement.getAsString();
    }
}
