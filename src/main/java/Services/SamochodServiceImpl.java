package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SamochodRepository;

@Service
public class SamochodServiceImpl implements SamochodService {

   @Autowired
   private SamochodRepository samochodRepository;



}
