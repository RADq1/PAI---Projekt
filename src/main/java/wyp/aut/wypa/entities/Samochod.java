package wyp.aut.wypa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import wyp.aut.wypa.Enums.Kolor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    int rocznik;
    @Column
    String numerRej;
    @Column
    @Enumerated
    Kolor kolor;
    @Column
    Double pojemnosc;
    @Column
    int przebieg;
    @Column
    Double spalanie;
    //to chyba inaczej bedzie trzeba zrobic.
    //moze enumy?
    @Column
    Double cena24;
    //terminy przegladu date?
    LocalDate terminPrzegladu;
    @Column
    LocalDate OC;
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

    public Samochod() {
    }

    public Samochod(String marka, String model, int rocznik, String numerRej, Kolor kolor, Double pojemnosc, int przebieg, Double spalanie, Double cena24, LocalDate terminPrzegladu, LocalDate OC) {
        this.marka = marka;
        this.model = model;
        this.rocznik = rocznik;
        this.numerRej = numerRej;
        this.kolor = kolor;
        this.pojemnosc = pojemnosc;
        this.przebieg = przebieg;
        this.spalanie = spalanie;
        this.cena24 = cena24;
        this.terminPrzegladu = terminPrzegladu;
        this.OC = OC;
        this.czyWypozyczone = false;
    }

    public Samochod(String marka, String model, int rocznik, String numerRej, Kolor kolor, Double pojemnosc, int przebieg, Double spalanie, Double cena24, LocalDate terminPrzegladu, LocalDate OC, Oddzial samochod_oddzialu) {
        this.marka = marka;
        this.model = model;
        this.rocznik = rocznik;
        this.numerRej = numerRej;
        this.kolor = kolor;
        this.pojemnosc = pojemnosc;
        this.przebieg = przebieg;
        this.spalanie = spalanie;
        this.cena24 = cena24;
        this.terminPrzegladu = terminPrzegladu;
        this.OC = OC;
        this.samochod_oddzialu = samochod_oddzialu;
    }
}
