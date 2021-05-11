package wyp.aut.wypa.repository;

import wyp.aut.wypa.entities.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PracownikRepo extends JpaRepository<Pracownik,Long> {
}
