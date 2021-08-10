package kg.megacom.storeservice.dao;

import kg.megacom.storeservice.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    @Query(value = "SELECT * FROM prices p WHERE p.products_id = ?1 and CURRENT_TIMESTAMP BETWEEN p.start_date and p.end_date",nativeQuery = true)
    Price findPriceByProductIdAndCurrentPriceBetweenSysdate(Long id);
}
