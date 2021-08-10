package kg.megacom.storeservice.models.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction_history")
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double moneyPaid;
    @ManyToOne
    @JoinColumn(name = "transactions_id")
    private Transaction transaction;
    private double excess;
    private double debt;
    @CreationTimestamp
    private LocalDateTime addDate;
}
