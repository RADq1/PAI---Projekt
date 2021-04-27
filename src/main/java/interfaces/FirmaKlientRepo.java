package interfaces;

import entities.FirmaKlient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmaKlientRepo extends JpaRepository<Long, FirmaKlient> {
}
