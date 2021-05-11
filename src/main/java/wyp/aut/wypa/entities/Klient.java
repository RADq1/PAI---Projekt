package wyp.aut.wypa.entities;


import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idKlient;
    @Column
    String imie;
    @Column
    String nazwisko;
    @Column(length = 9) //dlugosc numeru telefonu - 9 cyfer
    String nrTel;
    @Column(length = 11) //dlugosc peselu - 11 cyfer
    String PESEL;
    //login oraz haslo dodatkowo do indywidualnych kont
    @Column(unique = true, length = 15)
    String login;
            //TODO  Jesli login sie powtorzy, wywali strone
            //    //Zrobic zabezpieczenie, zeby wyskakiwal blad na stronie zamiast crasha.

    @Column(length = 30)
    String haslo;

    //TODO Chyba zapomnielismy o płci i mailu? ale czy jest konieczna?

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_Klient")
    private FirmaKlient pracownik_firmy;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "KlientKtoryWypozyczylAuto")
    private List<Wypozyczenie> autaWypozyczonePrzezKlienta = new ArrayList<>();

    //Konstruktor do wypelnienia rejestracji
    public Klient(String login, String haslo, String imie, String nazwisko, String nrTel, String PESEL) {
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTel = nrTel;
        this.PESEL = PESEL;
    }

    public Klient() {

    }
}
