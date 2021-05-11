package wyp.aut.wypa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.Wypozyczenie;
@Repository
public interface WypozyczanieRepo extends JpaRepository<Wypozyczenie,Long> {

}
