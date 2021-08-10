package kg.megacom.storeservice.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double price;
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Product product;
    private LocalDate startDate;
    private LocalDate endDate;
}
