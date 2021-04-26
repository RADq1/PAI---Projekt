package entities;


import javax.persistence.*;

@Entity
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idKlient;
    @Column
    String imie;
    @Column
    String nazwisko;
    @Column
    String nrTel;
    @Column
    String PESEL;

    //TODO
    //Relacja do firmaKlient


}
