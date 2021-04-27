package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Wypozyczenie {
    //TODO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idWypozyczenie;
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
}
