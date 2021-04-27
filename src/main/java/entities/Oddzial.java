package entities;

import javax.persistence.*;

@Entity
public class Oddzial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idOddzial;
    @Column
    String Miejscowosc;
    //TODO
    //Właściciel jak ma być zrobiony w sumie?
}
