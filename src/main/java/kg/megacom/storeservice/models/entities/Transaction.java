package kg.megacom.storeservice.models.entities;

import kg.megacom.storeservice.models.enums.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime startDate;
    @UpdateTimestamp
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client client;
}
