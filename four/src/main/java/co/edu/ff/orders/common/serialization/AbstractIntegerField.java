package co.edu.ff.orders.common.serialization;

import com.google.gson.JsonElement;

public abstract class AbstractIntegerField extends AbstractNotNullField {

    protected AbstractIntegerField(Integer value) {
        super(value);
    }

    public static Integer getJsonValue(JsonElement jsonElement) {
        return jsonElement.getAsInt();
    }
}
