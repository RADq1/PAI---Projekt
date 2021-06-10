package wyp.aut.wypa.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataWypożyczenia;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataOddania;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate terminOddania;
    @Column
    Boolean czyOddane = false;

    //TODO
    //całkowity koszt, relacje do tabeli klient, samochód oraz pracownik

    //RELACJE
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "wypozyczenie_Id")
    private Samochod wypozyczonySamochod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Klient KlientKtoryWypozyczylAuto;

    public Wypozyczenie() {
    }

    public Wypozyczenie(LocalDate dataWypożyczenia, LocalDate dataOddania, Samochod wypozyczonySamochod) {
        this.dataWypożyczenia = dataWypożyczenia;
        this.dataOddania = dataOddania;
        this.wypozyczonySamochod = wypozyczonySamochod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataWypożyczenia() {
        return dataWypożyczenia;
    }

    public void setDataWypożyczenia(LocalDate dataWypożyczenia) {
        this.dataWypożyczenia = dataWypożyczenia;
    }

    public LocalDate getDataOddania() {
        return dataOddania;
    }

    public void setDataOddania(LocalDate dataOddania) {
        this.dataOddania = dataOddania;
    }

    public LocalDate getTerminOddania() {
        return terminOddania;
    }

    public void setTerminOddania(LocalDate terminOddania) {
        this.terminOddania = terminOddania;
    }

    public Boolean getCzyOddane() {
        return czyOddane;
    }

    public void setCzyOddane(Boolean czyOddane) {
        this.czyOddane = czyOddane;
    }

    public Samochod getWypozyczonySamochod() {
        return wypozyczonySamochod;
    }

    public void setWypozyczonySamochod(Samochod wypozyczonySamochod) {
        this.wypozyczonySamochod = wypozyczonySamochod;
    }

    public Klient getKlientKtoryWypozyczylAuto() {
        return KlientKtoryWypozyczylAuto;
    }

    public void setKlientKtoryWypozyczylAuto(Klient klientKtoryWypozyczylAuto) {
        KlientKtoryWypozyczylAuto = klientKtoryWypozyczylAuto;
    }
}
