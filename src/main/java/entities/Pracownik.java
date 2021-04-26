package entities;

import Enums.Stanowisko;

import javax.persistence.*;

@Entity
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPracownik;
    @Column
    String imie;
    @Column
    String nazwisko;
    @Column
    Stanowisko stanowisko;
    //@Column
    //TODO
    //oddział
}
