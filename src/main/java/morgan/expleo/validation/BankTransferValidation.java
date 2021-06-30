package morgan.expleo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BankTransferValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface BankTransferValidation {

    String message() default "Invalid Bank Transfer";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
