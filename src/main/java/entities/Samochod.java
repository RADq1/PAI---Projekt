package entities;

import Enums.Kolor;

import javax.persistence.*;
import java.time.LocalDate;

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

}
