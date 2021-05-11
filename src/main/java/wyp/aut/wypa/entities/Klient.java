package wyp.aut.wypa.entities;


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
    @Column
    String nrTel;
    @Column
    String PESEL;

    //TODO
    //Relacja do firmaKlient

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_Klient")
    private FirmaKlient pracownik_firmy;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "KlientKtoryWypozyczylAuto")
    private List<Wypozyczenie> autaWypozyczonePrzezKlienta = new ArrayList<>();


}
