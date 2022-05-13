package presentation;

import sn.simplon.entities.Facture;
import sn.simplon.entities.Reglement;
import sn.simplon.metier.FactureImpl;
import sn.simplon.metier.IFacture;
import sn.simplon.metier.IReglement;
import sn.simplon.metier.ReglementImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args)  throws ParseException, IOException {
       /* Facture f = new Facture();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        f.setDate(sdf.parse("2022-05-13"));
        f.setDate(null);
        f.setConsommation(9999);
        f.setPrix(9999);
        f.setPaiement(true);

        IFacture iFacture = new FactureImpl();
        int ok = iFacture.add(f);
        System.out.println(ok);*/
        /*Reglement r = new Reglement();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        r.setDate(sdf.parse("2022-05-12"));
        Facture f = new Facture();
        f.setIdF(2);

        //reglement facture numero 2
        IReglement iReglement = new ReglementImpl();
        iReglement.add(r);

        //mis a jour de la facture
        f.setPaiement(true);
        IFacture iFacture = new FactureImpl();
        iFacture.update(f);*/

        IFacture iFacture = new FactureImpl();
        File etatFacture = new File("etatFacture.csv");
        List<Facture> factures = iFacture.liste();
        FileWriter fileWriter = new FileWriter(etatFacture);
        fileWriter.append("ID;Date\n;Consommation\n;Prix;Paiement\n");
        for (Facture f: factures){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fact = f.getIdF()+";"+sdf.format(f.getDate())
                    +";"+f.getConsommation()+";"+f.getPrix()
                    +";"+f.isPaiement()+"\n";
            fileWriter.write(fact);
        }
        fileWriter.close();
        System.out.println("fichier cree");
    }
}
