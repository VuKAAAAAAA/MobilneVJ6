package com.example.firebasejetpack;

public class Predavanje {
      int godina;
      String ime;
      String predavac;

    public Predavanje(int broj, String naziv, String profesor) {
        this.godina = broj;
        this.ime = naziv;
        this.predavac = profesor;
    }

    public Predavanje() {
        // default constructor
    }

    public  int getGodina() {
        return godina;
    }
    public  void setGodina(int godina) {
        this.godina = godina;
    }

    public  String getIme() {
        return ime;
    }
    public  void setIme(String ime) {
        this.ime = ime;
    }

    public  String getPredavac() {
        return predavac;
    }
    public  void setPredavac(String predavac) {
        this.predavac = predavac;
    }
}
