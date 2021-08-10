package kg.megacom.storeservice.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rests")
public class Rest {
    @OneToOne
    @JoinColumn(name = "products_id")
    private Product product;
    private int amount;
}
