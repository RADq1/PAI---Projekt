package wyp.aut.wypa.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FirmaKlient {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String NIP;
    @Column
    String nazwa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pracownik_firmy")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Klient> pracownicy_firmy = new ArrayList<>();
}
