package wyp.aut.wypa.entities;

import javax.persistence.*;

@Entity
public class Wypozyczenie {
    //TODO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wypozyczenie_Id")
    private Samochod wypozyczonySamochod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Klient KlientKtoryWypozyczylAuto;
}
