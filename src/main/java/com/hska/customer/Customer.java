package com.hska.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customer {
    @Id
    private String id;
    private String vorname;
    private String nachname;
    private String adresse;
    private int gehalt;

    public Customer(){

    }

    public Customer(String vorname, String nachname, String adresse, int gehalt) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.gehalt = gehalt;
    }

    public String getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getGehalt() {
        return gehalt;
    }

}
