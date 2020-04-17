package co.edu.ff.orders.user.domain;

import co.edu.ff.orders.common.validations.Preconditions;
import co.edu.ff.orders.common.serialization.IPrimitiveSerializable;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value(staticConstructor = "of")
public class Password implements IPrimitiveSerializable<String> {

    String value;

    public Password(String value){
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(StringUtils.isNoneBlank(value));
        Preconditions.checkArgument(value.length() >= 8);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}
