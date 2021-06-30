package morgan.expleo.service.impl;

import morgan.expleo.dto.BankTransferDTO;
import morgan.expleo.entity.BankTransferEntity;
import morgan.expleo.mapper.BankTransferMapper;
import morgan.expleo.repository.BankWireRepository;
import morgan.expleo.service.BankWireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankWireServiceImpl implements BankWireService {

    @Autowired
    private BankWireRepository bankWireRepository;

    public BankTransferDTO wireTransfer(BankTransferDTO bankTransferDTO) {
        BankTransferEntity bankTransferEntity = bankWireRepository.save(BankTransferMapper.dTOToEntity(bankTransferDTO));
        return BankTransferMapper.entityToDTO(bankTransferEntity);
    }

}
