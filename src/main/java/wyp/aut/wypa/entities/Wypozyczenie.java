package wyp.aut.wypa.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Wypozyczenie {
    //TODO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    LocalDate dataWypożyczenia;
    @Column
    LocalDate dataOddania;
    @Column
    LocalDate terminOddania;
    @Column
    Boolean czyOddane = false;

    //TODO
    //całkowity koszt, relacje do tabeli klient, samochód oraz pracownik

    //RELACJE
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wypozyczenie_Id")
    private Samochod wypozyczonySamochod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Klient KlientKtoryWypozyczylAuto;
}
