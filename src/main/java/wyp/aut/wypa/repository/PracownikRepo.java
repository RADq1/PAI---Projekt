package wyp.aut.wypa.repository;

import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PracownikRepo extends JpaRepository<Pracownik,Long> {
}
