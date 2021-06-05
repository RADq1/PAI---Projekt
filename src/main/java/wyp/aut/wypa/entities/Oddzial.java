package wyp.aut.wypa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "oddzial")
public class Oddzial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    String miejscowosc;
    //TODO
    //Właściciel jak ma być zrobiony w sumie?

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "samochod_oddzialu")
    @LazyCollection(LazyCollectionOption.FALSE)
     List<Samochod> samochody = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pracownik_oddzialu")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Pracownik> pracownicy = new ArrayList<>();

    public Oddzial() {
    }

    public Oddzial(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public List<Samochod> getSamochody() {
        return samochody;
    }

    public void setSamochody(List<Samochod> samochody) {
        this.samochody = samochody;
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
