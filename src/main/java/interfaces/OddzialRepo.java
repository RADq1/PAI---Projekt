package interfaces;

import entities.Oddzial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OddzialRepo extends JpaRepository<Long, Oddzial> {
}
