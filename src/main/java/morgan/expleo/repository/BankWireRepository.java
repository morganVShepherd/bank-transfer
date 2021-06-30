package morgan.expleo.repository;

import morgan.expleo.entity.BankTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankWireRepository extends JpaRepository<BankTransferEntity, Long> {

    BankTransferEntity save(BankTransferEntity bankTransferEntity);

}
