package wyp.aut.wypa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wyp.aut.wypa.entities.Token;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {

    Token findByValue(String value);
}
