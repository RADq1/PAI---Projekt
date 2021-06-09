package wyp.aut.wypa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.repository.SamochodRepository;

import java.util.Optional;

@Service
public class SamochodServiceImpl implements SamochodService {

   @Autowired
   private SamochodRepository samochodRepository;




   @Override
   public Samochod updateCar(Samochod samochod) {
 return samochodRepository.save(samochod);
   }

   @Override
   public Optional<Samochod> getSamochod(Long samochodId) {
      return samochodRepository.findById(samochodId);
   }


   @Override
   public Samochod setSamochod(Samochod samochod) {
      return samochodRepository.save(samochod);
   }
}
