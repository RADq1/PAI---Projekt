package wyp.aut.wypa.Services;


import wyp.aut.wypa.entities.Klient;
import wyp.aut.wypa.entities.Samochod;

public interface KlientService {
    //w interfejsie tworzymy funkcje z parametrami
    void addKlient(Klient klient);

    public Boolean checkLogin(String login);

    public Boolean checkPassword(String login, String haslo);

<<<<<<< Updated upstream
=======
    public void sendToken(Klient klient);

    public void orderCar(Samochod samochod);


>>>>>>> Stashed changes

}
