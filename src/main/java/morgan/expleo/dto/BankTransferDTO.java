package morgan.expleo.dto;

import lombok.Data;
import morgan.expleo.pojos.CurrencyCodeEnum;

import java.math.BigDecimal;

@Data
public class BankTransferDTO {

    private Long id;
    private String benificiary;
    private BigDecimal currentBalance;
    private BigDecimal amount;
    private CurrencyCodeEnum currencyCode;
}
