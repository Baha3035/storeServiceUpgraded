package kg.megacom.storeservice.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transactions_products")
public class TransactionProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "transactions_id")
    private Transaction transaction;
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Product product;
    private double price;
    private int productCount;
}
