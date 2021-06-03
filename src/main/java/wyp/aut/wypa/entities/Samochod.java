package wyp.aut.wypa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import wyp.aut.wypa.Enums.Kolor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    int rocznik;
    @Column
    String numerRej;
    @Column
    @Enumerated
    Kolor kolor;
    @Column
    Double pojemnosc;
    @Column
    int przebieg;
    @Column
    Double spalanie;
    //to chyba inaczej bedzie trzeba zrobic.
    //moze enumy?
    @Column
    Double cena24;
    //terminy przegladu date?
    LocalDate terminPrzegladu;
    @Column
    LocalDate OC;
    @Column
    Boolean czyWypozyczone=false;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
     Oddzial samochod_oddzialu;

    @OneToOne(mappedBy = "wypozyczonySamochod")
     Wypozyczenie wypozyczenie;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usterkaPojazdu")
    @LazyCollection(LazyCollectionOption.FALSE)
     List<Usterki> usterkiAuta = new ArrayList<>();

    public Samochod() {
    }

    public Samochod(String marka, String model, int rocznik, String numerRej, Kolor kolor, Double pojemnosc, int przebieg, Double spalanie, Double cena24, LocalDate terminPrzegladu, LocalDate OC) {
        this.marka = marka;
        this.model = model;
        this.rocznik = rocznik;
        this.numerRej = numerRej;
        this.kolor = kolor;
        this.pojemnosc = pojemnosc;
        this.przebieg = przebieg;
        this.spalanie = spalanie;
        this.cena24 = cena24;
        this.terminPrzegladu = terminPrzegladu;
        this.OC = OC;
        this.czyWypozyczone = false;
    }

    public Samochod(String marka, String model, int rocznik, String numerRej, Kolor kolor, Double pojemnosc, int przebieg, Double spalanie, Double cena24, LocalDate terminPrzegladu, LocalDate OC, Oddzial samochod_oddzialu) {
        this.marka = marka;
        this.model = model;
        this.rocznik = rocznik;
        this.numerRej = numerRej;
        this.kolor = kolor;
        this.pojemnosc = pojemnosc;
        this.przebieg = przebieg;
        this.spalanie = spalanie;
        this.cena24 = cena24;
        this.terminPrzegladu = terminPrzegladu;
        this.OC = OC;
        this.samochod_oddzialu = samochod_oddzialu;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public String getNumerRej() {
        return numerRej;
    }

    public void setNumerRej(String numerRej) {
        this.numerRej = numerRej;
    }

    public Kolor getKolor() {
        return kolor;
    }

    public void setKolor(Kolor kolor) {
        this.kolor = kolor;
    }

    public Double getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(Double pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public Double getSpalanie() {
        return spalanie;
    }

    public void setSpalanie(Double spalanie) {
        this.spalanie = spalanie;
    }

    public Double getCena24() {
        return cena24;
    }

    public void setCena24(Double cena24) {
        this.cena24 = cena24;
    }

    public LocalDate getTerminPrzegladu() {
        return terminPrzegladu;
    }

    public void setTerminPrzegladu(LocalDate terminPrzegladu) {
        this.terminPrzegladu = terminPrzegladu;
    }

    public LocalDate getOC() {
        return OC;
    }

    public void setOC(LocalDate OC) {
        this.OC = OC;
    }

    public Boolean getCzyWypozyczone() {
        return czyWypozyczone;
    }

    public void setCzyWypozyczone(Boolean czyWypozyczone) {
        this.czyWypozyczone = czyWypozyczone;
    }

    public Long getIdSamochod() {
        return idSamochod;
    }

    public void setIdSamochod(Long idSamochod) {
        this.idSamochod = idSamochod;
    }

    public Oddzial getSamochod_oddzialu() {
        return samochod_oddzialu;
    }

    public void setSamochod_oddzialu(Oddzial samochod_oddzialu) {
        this.samochod_oddzialu = samochod_oddzialu;
    }

    public Wypozyczenie getWypozyczenie() {
        return wypozyczenie;
    }

    public void setWypozyczenie(Wypozyczenie wypozyczenie) {
        this.wypozyczenie = wypozyczenie;
    }

    public List<Usterki> getUsterkiAuta() {
        return usterkiAuta;
    }

    public void setUsterkiAuta(List<Usterki> usterkiAuta) {
        this.usterkiAuta = usterkiAuta;
    }


}
