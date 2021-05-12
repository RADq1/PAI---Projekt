package wyp.aut.wypa.entities;

import javax.persistence.*;

@Entity
public class Usterki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String nazwa;
    @Column
    String opis;
    @Column
    Boolean czyNaprawione = false;
    //TODO
    //Numer rejestracyjny samochodu to musi byc relacja do tabeli
    //samochod obstawiam, jakis pomysl?
    @Column
    Boolean wyslaneDoNaprawy=false;
    //tu pewnie przycisk sie zrobi wyslij do naprawy i boolean sie bedzie zmienial na true.

    //RELACJE
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Samochod usterkaPojazdu;
}
