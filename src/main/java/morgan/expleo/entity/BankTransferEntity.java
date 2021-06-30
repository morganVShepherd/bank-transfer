package morgan.expleo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "bank_transfer")
public class BankTransferEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bank_transfer_sequence"
    )
    @SequenceGenerator(
            name = "bank_transfer_sequence",
            allocationSize = 1
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "benefeciary")
    private String benificiary;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency_code")
    private String currencyCode;

}
