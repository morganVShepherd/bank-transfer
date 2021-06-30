package morgan.expleo.validation;


import lombok.extern.slf4j.Slf4j;
import morgan.expleo.dto.BankTransferDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

@Slf4j
public class BankTransferValidator implements ConstraintValidator<BankTransferValidation, BankTransferDTO> {

    @Override
    public boolean isValid(BankTransferDTO bankTransferDTO, ConstraintValidatorContext context) {

        if (bankTransferDTO.getAmount().compareTo(BigDecimal.ZERO) < 1) {
            log.error("Transfer amount cannot be negative or Zero");
            return false;
        }
        if (bankTransferDTO.getAmount().compareTo(bankTransferDTO.getCurrentBalance()) > 0) {
            log.error("You cannot transfer more than you own");
            return false;
        }
        return true;
    }

}