package wyp.aut.wypa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.Usterki;
@Repository
public interface UsterkiRepo extends JpaRepository<Usterki,Long> {
}
