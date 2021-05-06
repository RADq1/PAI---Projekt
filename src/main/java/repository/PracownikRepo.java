package repository;

import entities.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PracownikRepo extends JpaRepository<Pracownik,Long> {
}
