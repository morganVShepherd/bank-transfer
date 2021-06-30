package morgan.expleo.banktransfer;

import morgan.expleo.dto.BankTransferDTO;
import morgan.expleo.entity.BankTransferEntity;
import morgan.expleo.mapper.BankTransferMapper;
import morgan.expleo.pojos.CurrencyCodeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class UnitTest {

    BigDecimal AMOUNT = new BigDecimal(10);
    String  BENEFICIARY = "beneficiary";
    CurrencyCodeEnum CURRENCY_CODE = CurrencyCodeEnum.USD;
    BigDecimal CURRENT_BALANCE = new BigDecimal(100);
    @Test
    void testMapperEntityToDTO() {
        BankTransferDTO bankTransferDTO = new BankTransferDTO();
        bankTransferDTO.setAmount(AMOUNT);
        bankTransferDTO.setBenificiary(BENEFICIARY);
        bankTransferDTO.setCurrencyCode(CURRENCY_CODE);
        bankTransferDTO.setCurrentBalance(CURRENT_BALANCE);
        BankTransferEntity bankTransferEntity = BankTransferMapper.dTOToEntity(bankTransferDTO);
        Assertions.assertEquals(bankTransferEntity.getAmount(),AMOUNT);
        Assertions.assertEquals(bankTransferEntity.getBenificiary(),BENEFICIARY);
        Assertions.assertEquals(bankTransferEntity.getCurrentBalance(),CURRENT_BALANCE);
        Assertions.assertEquals(bankTransferEntity.getCurrencyCode(),CURRENCY_CODE.name());
    }
}
