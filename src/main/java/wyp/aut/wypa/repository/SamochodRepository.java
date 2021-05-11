package wyp.aut.wypa.repository;

import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.Samochod;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface SamochodRepository extends JpaRepository<Samochod,Long> {
}
