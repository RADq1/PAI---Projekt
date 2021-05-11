package wyp.aut.wypa.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyp.aut.wypa.repository.SamochodRepository;

@Service
public class SamochodServiceImpl implements SamochodService {

   @Autowired
   private SamochodRepository samochodRepository;



}
