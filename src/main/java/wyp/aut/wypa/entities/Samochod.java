package wyp.aut.wypa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import wyp.aut.wypa.Enums.Kolor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Samochod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSamochod;
    @Column
    String marka;
    @Column
    String model;
    @Column
    String rocznik;
    @Column
    String numerRej;
    @Column
    @Enumerated
    Kolor kolor;
    @Column
    String pojemnosc;
    @Column
    String przebieg;
    @Column
    String spalanie;
    //to chyba inaczej bedzie trzeba zrobic.
    //moze enumy?
    @Column
    String cena24;
    //terminy przegladu date?
    LocalDate terminPrzegladu;
    @Column
    String OC;
    @Column
    Boolean czyWypozyczone=false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Oddzial samochod_oddzialu;

    @OneToOne(mappedBy = "wypozyczonySamochod")
    private Wypozyczenie wypozyczenie;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usterkaPojazdu")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Usterki> usterkiAuta = new ArrayList<>();

}
