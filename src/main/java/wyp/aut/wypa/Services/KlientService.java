package wyp.aut.wypa.Services;


import wyp.aut.wypa.entities.Klient;

public interface KlientService {
    //w interfejsie tworzymy funkcje z parametrami
    void addKlient(Klient klient);

    public Boolean checkLogin(String login);

    public Boolean checkPassword(String login, String haslo);

    public void sendToken(Klient klient);



}
