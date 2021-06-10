package wyp.aut.wypa.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

public class WypozyczenieTemp {

    String idSamochodu;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataWypożyczenia;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataOddania;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate terminOddania;

    public WypozyczenieTemp() {
    }

    public WypozyczenieTemp(String idSamochodu, LocalDate dataWypożyczenia, LocalDate dataOddania, LocalDate terminOddania) {
        this.idSamochodu = idSamochodu;
        this.dataWypożyczenia = dataWypożyczenia;
        this.dataOddania = dataOddania;
        this.terminOddania = terminOddania;
    }

    public String getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(String idSamochodu) {
        this.idSamochodu = idSamochodu;
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
}
