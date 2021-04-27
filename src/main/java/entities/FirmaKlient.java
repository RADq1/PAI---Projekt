package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FirmaKlient {
    @Id
    @GeneratedValue
    Long idFirmaKlient;
    @Column
    String NIP;
    @Column
    String nazwa;
}
