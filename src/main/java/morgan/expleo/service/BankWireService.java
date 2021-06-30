package morgan.expleo.service;

import morgan.expleo.dto.BankTransferDTO;
import org.springframework.stereotype.Service;

@Service
public interface BankWireService {

    BankTransferDTO wireTransfer(BankTransferDTO bankTransferDTO);
}
