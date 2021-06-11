package wyp.aut.wypa.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CzasPracy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Long idCzasPracy;
    //@Column
    //PRACOWNIK
    @Column
    LocalDateTime startPracy;
    @Column
    LocalDateTime koniecPracy;
    @Column
    String nadgodziny;
    @Column
    String sumaGodzin;
    @Column
    LocalDate data;
/*    @OneToOne(cascade = CascadeType.ALL)
    private Pracownik czasPracyPracownika;*/
}
