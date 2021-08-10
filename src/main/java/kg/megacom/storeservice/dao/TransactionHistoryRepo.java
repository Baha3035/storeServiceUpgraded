package kg.megacom.storeservice.dao;

import kg.megacom.storeservice.models.entities.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Long> {
}
