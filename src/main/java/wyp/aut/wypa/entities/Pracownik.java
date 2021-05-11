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
    Stanowisko stanowisko;

    //TODO to samo co u Klienta, login, haslo, email.

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oddzial_id")
    private Oddzial pracownik_oddzialu;


    @OneToOne(mappedBy = "czasPracyPracownika")
    private CzasPracy czasPracy;
}