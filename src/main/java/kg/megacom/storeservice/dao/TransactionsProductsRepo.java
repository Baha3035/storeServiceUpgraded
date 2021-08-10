package kg.megacom.storeservice.dao;

import kg.megacom.storeservice.models.entities.TransactionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsProductsRepo extends JpaRepository<TransactionProduct, Long> {
}
