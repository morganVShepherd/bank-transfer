package morgan.expleo.mapper;


import morgan.expleo.dto.BankTransferDTO;
import morgan.expleo.entity.BankTransferEntity;
import morgan.expleo.pojos.CurrencyCodeEnum;

public class BankTransferMapper {

    public static BankTransferEntity dTOToEntity(BankTransferDTO bankTransferDTO) {
        BankTransferEntity bankTransferEntity = new BankTransferEntity();
        bankTransferEntity.setId(bankTransferDTO.getId());
        bankTransferEntity.setAmount(bankTransferDTO.getAmount());
        bankTransferEntity.setBenificiary(bankTransferDTO.getBenificiary());
        bankTransferEntity.setCurrencyCode(bankTransferDTO.getCurrencyCode().toString());
        bankTransferEntity.setCurrentBalance(bankTransferDTO.getCurrentBalance());
        return bankTransferEntity;
    }

    public static BankTransferDTO entityToDTO(BankTransferEntity bankTransferEntity) {
        BankTransferDTO bankTransferDTO = new BankTransferDTO();
        bankTransferDTO.setId(bankTransferEntity.getId());
        bankTransferDTO.setAmount(bankTransferEntity.getAmount());
        bankTransferDTO.setBenificiary(bankTransferEntity.getBenificiary());
        bankTransferDTO.setCurrencyCode(CurrencyCodeEnum.valueOf(bankTransferEntity.getCurrencyCode()));
        bankTransferDTO.setCurrentBalance(bankTransferEntity.getCurrentBalance());
        return bankTransferDTO;
    }

}
