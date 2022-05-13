package sn.simplon.entities;

import java.util.Date;
import java.util.zip.DataFormatException;

public class Reglement {
    private int idR;
    private Date date;
    private Facture facture = new Facture();

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
