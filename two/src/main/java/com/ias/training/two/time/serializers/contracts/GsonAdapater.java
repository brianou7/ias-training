package com.ias.training.two.time.serializers.contracts;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

/**
 * Contract Gson's adapters.
 */
public interface GsonAdapater<T> extends JsonSerializer<T>, JsonDeserializer<T> {
}
