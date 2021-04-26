package entities;

import Enums.Kolor;

import javax.persistence.*;

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
    Kolor kolor;

}
