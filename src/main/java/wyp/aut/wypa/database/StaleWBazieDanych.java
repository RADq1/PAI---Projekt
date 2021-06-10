package wyp.aut.wypa.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wyp.aut.wypa.Enums.Kolor;
import wyp.aut.wypa.Enums.Stanowisko;
import wyp.aut.wypa.entities.Oddzial;
import wyp.aut.wypa.entities.Pracownik;
import wyp.aut.wypa.entities.Samochod;
import wyp.aut.wypa.repository.OddzialRepo;
import wyp.aut.wypa.repository.PracownikRepo;
import wyp.aut.wypa.repository.SamochodRepository;

import java.time.LocalDate;

@Configuration
public class StaleWBazieDanych {




    @Bean
    CommandLineRunner dodanieAut(SamochodRepository samochodRepository, OddzialRepo oddzialRepo, PracownikRepo pracownikRepo)
    {
        return args -> {
            Oddzial oddzialByd = new Oddzial("Bydgoszcz");
            Oddzial oddzialTor = new Oddzial("Toruń");
            Oddzial oddzialGda = new Oddzial("Gdańsk");
            oddzialRepo.save(oddzialByd);
            oddzialRepo.save(oddzialTor);
            oddzialRepo.save(oddzialGda);
            samochodRepository.save(new Samochod("Opel","Astra",2020,"CBY8080DE", Kolor.NIEBIESKI,2.0,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialByd));
            samochodRepository.save(new Samochod("Opel","Vectra",2019,"CBY3600XD", Kolor.BIALY,1.9,145689,5.0,110.0, LocalDate.of(2022,9,22), LocalDate.of(2022,9,22),oddzialByd));
            samochodRepository.save(new Samochod("Ford","Focus",2018,"CBY2514CD", Kolor.GRANATOWY,1.8,135789,5.5,115.0, LocalDate.of(2022,6,23),LocalDate.of(2022,6,23),oddzialByd));
            samochodRepository.save(new Samochod("Ford","Mondeo",2017,"CBYJP2KMD", Kolor.CZERWONY,1.7,185236,5.4,120.0, LocalDate.of(2022,6,24),LocalDate.of(2022,6,24),oddzialByd));
            samochodRepository.save(new Samochod("Subaru","Impreza",2016,"CBY8436CD", Kolor.CZARNY,1.6,194563,8.5,125.0, LocalDate.of(2022,5,18),LocalDate.of(2022,5,18),oddzialByd));
            samochodRepository.save(new Samochod("Fiat","Tipo",2015,"CBY5874FG", Kolor.POMARANCZOWY,1.5,165478,10.0,130.0, LocalDate.of(2022,5,17),LocalDate.of(2022,5,17),oddzialByd));
            samochodRepository.save(new Samochod("Fiat","Panda",2014,"CBY222222", Kolor.SREBRNY,1.4,145632,9.2,120.0, LocalDate.of(2022,2,19),LocalDate.of(2022,2,19),oddzialByd));
            samochodRepository.save(new Samochod("Audi","A8",2014,"COTAM", Kolor.SZARY,1.3,122569,4.4,110.0, LocalDate.of(2022,2,1),LocalDate.of(2022,2,1),oddzialByd));
            samochodRepository.save(new Samochod("Audi","A6",2015,"XDDDDD", Kolor.ZIELONY,1.4,177562,6.2,100.0, LocalDate.of(2022,3,2),LocalDate.of(2022,3,2),oddzialByd));
            samochodRepository.save(new Samochod("BMV","E36",2016,"CBY420EL", Kolor.ZOLTY,1.5,145698,7.4,90.0, LocalDate.of(2022,3,3),LocalDate.of(2022,3,3),oddzialByd));
            samochodRepository.save(new Samochod("BMV","E38",2017,"CBY8877DF", Kolor.SREBRNY,1.6,198698,8.3,85.0, LocalDate.of(2022,3,4), LocalDate.of(2022,3,4),oddzialByd));
            samochodRepository.save(new Samochod("Volvo","V40",2018,"CBY4321KR", Kolor.SREBRNY,1.7,144787,7.0,80.0, LocalDate.of(2022,2,5),LocalDate.of(2022,2,5),oddzialByd));
            samochodRepository.save(new Samochod("Mercedes","W2000",2019,"CBYELO123", Kolor.ZIELONY,1.8,199864,6.0,75.0, LocalDate.of(2022,1,6),LocalDate.of(2022,1,6),oddzialByd));
            pracownikRepo.save(new Pracownik("Marian","Kowalski", Stanowisko.Pracownik,oddzialByd));
            pracownikRepo.save(new Pracownik("Wwiktor","Murawski", Stanowisko.Pracownik,oddzialByd));
            pracownikRepo.save(new Pracownik("Amelia","Nowakoska", Stanowisko.Pracownik,oddzialByd));
            pracownikRepo.save(new Pracownik("Antoni","Ossowski", Stanowisko.Zarzad,oddzialByd));
            samochodRepository.save(new Samochod("Opel","Figo",2020,"CTR54563VF", Kolor.NIEBIESKI,2.0,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Opel","Fagot",2019,"CTR3214GH", Kolor.CZARNY,1.9,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Alfa Romeo","Julietta",2018,"CTR3698JK", Kolor.POMARANCZOWY,1.0,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Alfa Romeo","Cezar",2017,"CTRJK6597", Kolor.SZARY,1.2,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Alfa Romeo","Revenge",2016,"CTRJ547K4", Kolor.ZOLTY,1.1,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Nissan","Quatro",2015,"CTRNHGB36", Kolor.SREBRNY,1.3,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Nissan","Punto",2016,"CTRFV2654", Kolor.ZIELONY,1.4,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Nissan","Cold",2017,"CTRBNJK36", Kolor.CZARNY,1.6,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Citroen","Xerath",2018,"CTR963258", Kolor.ZOLTY,1.5,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Citroen","Aatrox",2019,"CTRZXC123", Kolor.NIEBIESKI,1.8,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Citroen","Alistar",2020,"CTR2589OP", Kolor.GRANATOWY,1.8,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Toyota","Nocturne",2020,"CTR36985", Kolor.BIALY,1.8,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            samochodRepository.save(new Samochod("Toyota","Sett",2020,"CTR2HJKLJ", Kolor.BIALY,1.8,125346,6.5,100.0, LocalDate.of(2022,9,21),LocalDate.of(2022,9,21),oddzialTor));
            pracownikRepo.save(new Pracownik("Adam","Nawałka", Stanowisko.Pracownik,oddzialTor));
            pracownikRepo.save(new Pracownik("Robert","Lewandowski", Stanowisko.Pracownik,oddzialTor));
            pracownikRepo.save(new Pracownik("Jakub","Błaszczykowski", Stanowisko.Pracownik,oddzialTor));
            pracownikRepo.save(new Pracownik("Wojciech","Stefczyk", Stanowisko.Zarzad,oddzialTor));
            samochodRepository.save(new Samochod("Toyota","Chogath",2010,"GDA5621JK", Kolor.GRANATOWY,1.8,159632,7.0,120.0, LocalDate.of(2022,7,12),LocalDate.of(2021,9,3),oddzialGda));
            samochodRepository.save(new Samochod("Toyota","Vayne",2021,"GDA2365BD", Kolor.ZOLTY,1.8,154789,6.6,120.0, LocalDate.of(2022,8,13),LocalDate.of(2022,7,6),oddzialGda));
            samochodRepository.save(new Samochod("Audi","Lucian",2016,"GDA1596FG", Kolor.CZARNY,1.8,135698,6.7,150.0, LocalDate.of(2022,6,15),LocalDate.of(2022,7,22),oddzialGda));
            samochodRepository.save(new Samochod("Audi","Garen",2016,"GDA4569MG", Kolor.ZIELONY,1.7,145236,5.4,140.0, LocalDate.of(2022,5,16),LocalDate.of(2022,6,21),oddzialGda));
            samochodRepository.save(new Samochod("Suzuki","Sett",2018,"GDA7412KV", Kolor.SREBRNY,1.6,178945,9.3,130.0, LocalDate.of(2022,4,17),LocalDate.of(2022,6,30),oddzialGda));
            samochodRepository.save(new Samochod("Suzuki","Sett",2018,"GDA1258NF", Kolor.ZOLTY,1.6,134679,4.9,115.0, LocalDate.of(2022,3,18),LocalDate.of(2022,5,12),oddzialGda));
            samochodRepository.save(new Samochod("BMW","Velkoz",2017,"GDA1489BD", Kolor.GRANATOWY,1.6,125346,4.8,1000.0, LocalDate.of(2022,3,21),LocalDate.of(2022,5,15),oddzialGda));
            samochodRepository.save(new Samochod("BMW","Darius",2021,"GDA9856CF", Kolor.SZARY,1.5,184563,5.3,1321.0, LocalDate.of(2022,4,22),LocalDate.of(2022,4,18),oddzialGda));
            samochodRepository.save(new Samochod("Opel","Demacia",2017,"GDA0369VY", Kolor.POMARANCZOWY,1.5,1774563,9.6,90.0, LocalDate.of(2022,5,23),LocalDate.of(2022,4,19),oddzialGda));
            samochodRepository.save(new Samochod("Opel","Poppy",2010,"GDA0366SG", Kolor.CZERWONY,1.5,80000,3.4,80.0, LocalDate.of(2022,6,25),LocalDate.of(2022,3,20),oddzialGda));
            samochodRepository.save(new Samochod("Polonez","Caro",2011,"GDA0666JV", Kolor.NIEBIESKI,1.4,134689,4.4,150.0, LocalDate.of(2022,6,24),LocalDate.of(2022,3,25),oddzialGda));
            samochodRepository.save(new Samochod("Citroen","Aphelios",2011,"GDA2158MH", Kolor.CZERWONY,1.4,125346,5.5,140.0, LocalDate.of(2022,7,23),LocalDate.of(2022,2,25),oddzialGda));
            samochodRepository.save(new Samochod("Citroen","Gwen",2013,"GDA0147JI", Kolor.ZOLTY,1.4,452361,7.5,130.0, LocalDate.of(2022,7,21),LocalDate.of(2022,2,16),oddzialGda));
            samochodRepository.save(new Samochod("Fiat","Azir",2013,"GDA2137BJ", Kolor.SREBRNY,1.3,201452,6.0,160.0, LocalDate.of(2022,8,22),LocalDate.of(2022,1,3),oddzialGda));
            samochodRepository.save(new Samochod("Fiat","Renekton",2014,"GDA0420VD", Kolor.GRANATOWY,1.3,202013,5.8,125.0, LocalDate.of(2022,8,11),LocalDate.of(2022,1,4),oddzialGda));
            samochodRepository.save(new Samochod("Hyunday","Xerath",2014,"GDA1598CH", Kolor.POMARANCZOWY,1.3,120000,4.8,126.0, LocalDate.of(2022,2,27),LocalDate.of(2022,12,5),oddzialGda));
            samochodRepository.save(new Samochod("KIA","Malphite",2006,"GDA7532NF", Kolor.BIALY,1.2,123654,5.3,139.0, LocalDate.of(2022,2,14),LocalDate.of(2022,12,6),oddzialGda));
            pracownikRepo.save(new Pracownik("Maciej","Rybus", Stanowisko.Pracownik,oddzialGda));
            pracownikRepo.save(new Pracownik("Marcin","Najman", Stanowisko.Pracownik,oddzialGda));
            pracownikRepo.save(new Pracownik("Domino","Jachaś", Stanowisko.Pracownik,oddzialGda));
            pracownikRepo.save(new Pracownik("Bartosz","Walaszek", Stanowisko.Zarzad,oddzialGda));

        };
    }


}
