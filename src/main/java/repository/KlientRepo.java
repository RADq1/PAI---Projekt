package repository;

import entities.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface KlientRepo extends JpaRepository<Klient,Long> {
}
