package co.edu.ff.orders.common.serialization;

import com.google.gson.JsonElement;

import java.math.BigDecimal;

public abstract class AbstractBigDecimalField extends AbstractNotNullField {

    protected AbstractBigDecimalField(BigDecimal value) {
        super(value);
    }

    public static BigDecimal getJsonValue(JsonElement jsonElement) {
        return jsonElement.getAsBigDecimal();
    }

}
