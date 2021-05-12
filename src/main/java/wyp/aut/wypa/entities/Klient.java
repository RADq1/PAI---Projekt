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
            //TODO UNIKALNY PESEL
    String PESEL;
    //login oraz haslo dodatkowo do indywidualnych kont
    @Column(unique = true, length = 15)
    String login;

    @Column(length = 30)
    String haslo;

    //TODO Chyba zapomnielismy o płci i mailu? ale czy jest konieczna?

    //Patryk po co ta relacja?
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

    public Long getIdKlient() {
        return idKlient;
    }

    public void setIdKlient(Long idKlient) {
        this.idKlient = idKlient;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Klient() {

    }
}
