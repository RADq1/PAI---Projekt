package wyp.aut.wypa.entities;

import wyp.aut.wypa.Enums.Stanowisko;

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
    Double Pensja=2800.00;
    @Column
    Stanowisko stanowisko;

    //TODO to samo co u Klienta, login, haslo, email.

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Oddzial pracownik_oddzialu;


 /*   @OneToOne(mappedBy = "czasPracyPracownika")
    private CzasPracy czasPracy;
*/
    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, Stanowisko stanowisko, Oddzial pracownik_oddzialu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.pracownik_oddzialu = pracownik_oddzialu;
    }

    public Long getIdPracownik() {
        return idPracownik;
    }

    public void setIdPracownik(Long idPracownik) {
        this.idPracownik = idPracownik;
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

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Oddzial getPracownik_oddzialu() {
        return pracownik_oddzialu;
    }

    public void setPracownik_oddzialu(Oddzial pracownik_oddzialu) {
        this.pracownik_oddzialu = pracownik_oddzialu;
    }

 /*   public CzasPracy getCzasPracy() {
        return czasPracy;
    }

    public void setCzasPracy(CzasPracy czasPracy) {
        this.czasPracy = czasPracy;
    }*/

    public Double getPensja() {
        return Pensja;
    }

    public void setPensja(Double pensja) {
        Pensja = pensja;
    }
}
