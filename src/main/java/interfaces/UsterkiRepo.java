package interfaces;

import entities.Usterki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface UsterkiRepo extends JpaRepository<Long, Usterki> {

}
