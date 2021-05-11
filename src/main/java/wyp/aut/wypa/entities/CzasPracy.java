package wyp.aut.wypa.entities;

import javax.persistence.*;

@Entity
public class CzasPracy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Pracownik czasPracyPracownika;
}
