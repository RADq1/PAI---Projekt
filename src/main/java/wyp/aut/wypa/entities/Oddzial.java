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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "samochod_oddzialu")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Samochod> samochody = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pracownik_oddzialu")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Pracownik> pracownicy = new ArrayList<>();

}
