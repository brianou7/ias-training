package co.edu.ff.orders.common.serialization;

import co.edu.ff.orders.common.validations.Preconditions;

/**
 * Abastract class to any simple serializable field.
 *
 * @param <T> any java primtive value.
 */
public abstract class AbstractNotNullField<T> implements IPrimitiveSerializable<T> {

    protected AbstractNotNullField(T value) {
        Preconditions.checkNotNull(value);
    }

}
