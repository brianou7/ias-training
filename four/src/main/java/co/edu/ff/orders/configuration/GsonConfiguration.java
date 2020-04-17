package co.edu.ff.orders.configuration;

import co.edu.ff.orders.common.serialization.AbstractStringField;
import co.edu.ff.orders.product.domain.fields.*;
import co.edu.ff.orders.product.serialization.PrimitiveValueAdapter;
import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.Username;
import co.edu.ff.orders.user.exceptions.UserException;
import co.edu.ff.orders.user.serialization.StringValueAdapter;
import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.function.Function;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson gson(){
        Function<String, Password> creator = new Function<String, Password>() {
            @Override
            public Password apply(String s) {
                return Password.of(s);
            }
        };

        return new GsonBuilder()
                .registerTypeAdapter(Id.class, new PrimitiveValueAdapter<>(Id::of, Id::getJsonValue))
                .registerTypeAdapter(Name.class, new PrimitiveValueAdapter<>(Name::of, Name::getJsonValue))
                .registerTypeAdapter(Description.class, new PrimitiveValueAdapter<>(Description::of, Description::getJsonValue))
                .registerTypeAdapter(Price.class, new PrimitiveValueAdapter<>(Price::of, Price::getJsonValue))
                .registerTypeAdapter(Stock.class, new PrimitiveValueAdapter<>(Stock::of, Stock::getJsonValue))
                .registerTypeAdapter(TaxRate.class, new PrimitiveValueAdapter<>(TaxRate::of, TaxRate::getJsonValue))
                .registerTypeAdapter(Username.class, new StringValueAdapter<>(Username::of))
                .registerTypeAdapter(Password.class, new StringValueAdapter<Password>(creator))
                .registerTypeAdapter(UserException.class, new JsonSerializer<UserException>() {
                    @Override
                    public JsonElement serialize(UserException src, Type typeOfSrc, JsonSerializationContext context) {
                        JsonObject jsonObject = new JsonObject();
                        String message = src.getMessage();
                        JsonPrimitive errorValue = new JsonPrimitive(message);
                        jsonObject.add("error", errorValue);
                        return jsonObject;
                    }
                })
                .create();
    }
}
