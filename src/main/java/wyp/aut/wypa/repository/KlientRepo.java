package wyp.aut.wypa.repository;

import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface KlientRepo extends JpaRepository<Klient,Long> {
}
