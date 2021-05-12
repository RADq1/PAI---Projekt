package wyp.aut.wypa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.CzasPracy;
@Repository
public interface CzasPracyRepo extends JpaRepository<CzasPracy,Long> {
}
