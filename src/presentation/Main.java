package presentation;

import sn.simplon.entities.Facture;
import sn.simplon.metier.FactureImpl;
import sn.simplon.metier.IFacture;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args)  throws ParseException {
        Facture f = new Facture();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        f.setDate(sdf.parse("2022-05-13"));
        f.setDate(null);
        f.setConsommation(9999);
        f.setPrix(9999);
        f.setPaiement(true);

        IFacture iFacture = new FactureImpl();
        IFacture.add(f);
    }
}
