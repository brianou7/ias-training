package co.edu.ff.orders.common.serialization;

import com.google.gson.JsonElement;

/**
 * Primitive serializable
 *
 * @param <T> any primitive java data type
 */
public interface IPrimitiveSerializable<T> {

    T valueOf();

}
