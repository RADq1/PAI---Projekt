package wyp.aut.wypa.entities;


import com.sun.istack.NotNull;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Klient implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idKlient;
    @Column
    String imie;
    @Column
    String nazwisko;
    @Column(length = 9) //dlugosc numeru telefonu - 9 cyfer
            String nrTel;

    //TODO UNIKALNY PESEl //zrobione
    @Column(unique = true, length = 11)
    String PESEL;
    //login oraz haslo dodatkowo do indywidualnych kont
    @Column(unique = true, length = 15)
    String username;
    @Column(name = "email")
    String email;

    @Column
    String password;
    @Column
    String role;




    //TODO Chyba zapomnielismy o płci i mailu? ale czy jest konieczna?

    //Patryk po co ta relacja?
    //klient moze byc sluzbowy i dlatego jest powiazany z firma
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_Klient")
    private FirmaKlient pracownik_firmy;


    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "KlientKtoryWypozyczylAuto")
    private List<Wypozyczenie> autaWypozyczonePrzezKlienta = new ArrayList<>();

    public Klient(String imie, String nazwisko, String nrTel, String PESEL, String username, String password, String role, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTel = nrTel;
        this.PESEL = PESEL;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Klient() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
