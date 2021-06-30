package morgan.expleo.controller;


import morgan.expleo.dto.BankTransferDTO;
import morgan.expleo.service.BankWireService;
import morgan.expleo.validation.BankTransferValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class BankWireController {

    @Autowired
    private BankWireService bankWireService;

    @PostMapping("/wire-transfer")
    public ResponseEntity create(@BankTransferValidation @RequestBody BankTransferDTO bankTransferDTO) {
        return new ResponseEntity(bankWireService.wireTransfer(bankTransferDTO), HttpStatus.CREATED);
    }

}
