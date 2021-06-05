package wyp.aut.wypa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.Klient;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.Optional;


@Repository
public interface KlientRepo extends JpaRepository<Klient,Long> {
    Boolean existsByUsername(String login);


    Optional<Klient> findByUsername(String login);



}
