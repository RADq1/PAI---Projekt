package wyp.aut.wypa.Services;


import wyp.aut.wypa.entities.Samochod;

import java.util.Optional;

public interface SamochodService {

  Samochod updateCar(Samochod samochod);

    Optional<Samochod> getSamochod(Long samochodId);

    Samochod addCar(Samochod samochod);
}
