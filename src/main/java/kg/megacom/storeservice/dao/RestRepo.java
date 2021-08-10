package kg.megacom.storeservice.dao;

import kg.megacom.storeservice.models.entities.Rest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestRepo extends JpaRepository<Rest, Long> {
}
