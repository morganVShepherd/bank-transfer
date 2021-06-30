package morgan.expleo.banktransfer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import morgan.expleo.dto.BankTransferDTO;
import morgan.expleo.entity.BankTransferEntity;
import morgan.expleo.pojos.CurrencyCodeEnum;
import morgan.expleo.repository.BankWireRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    BigDecimal AMOUNT = new BigDecimal(10.00);
    String BENEFICIARY = "beneficiary";
    CurrencyCodeEnum CURRENCY_CODE = CurrencyCodeEnum.USD;
    BigDecimal CURRENT_BALANCE = new BigDecimal(100.00);


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BankWireRepository bankWireRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCreateBankTransfer() throws Exception {
        BankTransferDTO bankTransferDTO = new BankTransferDTO();
        bankTransferDTO.setAmount(AMOUNT);
        bankTransferDTO.setBenificiary(BENEFICIARY);
        bankTransferDTO.setCurrencyCode(CURRENCY_CODE);
        bankTransferDTO.setCurrentBalance(CURRENT_BALANCE);

        ObjectMapper objectMapper = new ObjectMapper();

        MvcResult result =mockMvc.perform(post("/wire-transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bankTransferDTO))
                .characterEncoding("utf-8"))
                .andReturn();

        Integer id = JsonPath.read(result.getResponse().getContentAsString(), "$.id");

        BankTransferEntity bankTransferEntity = bankWireRepository.findById(new Long(id)).get();

        Assertions.assertEquals(bankTransferEntity.getAmount().compareTo(AMOUNT),0);
        Assertions.assertEquals(bankTransferEntity.getBenificiary(),BENEFICIARY);
        Assertions.assertEquals(bankTransferEntity.getCurrentBalance().compareTo(CURRENT_BALANCE),0);
        Assertions.assertEquals(bankTransferEntity.getCurrencyCode(),CURRENCY_CODE.name());


    }

}
