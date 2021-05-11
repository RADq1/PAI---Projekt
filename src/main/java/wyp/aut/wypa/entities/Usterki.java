package wyp.aut.wypa.entities;

import javax.persistence.*;

@Entity
public class Usterki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Samochod usterkaPojazdu;
}
