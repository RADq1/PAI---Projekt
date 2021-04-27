package interfaces;

import entities.Wypozyczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WypozyczenieRepo extends JpaRepository<Long, Wypozyczenie> {
}
