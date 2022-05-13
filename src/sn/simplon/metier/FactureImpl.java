package sn.simplon.metier;

import sn.simplon.entities.Facture;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FactureImpl implements IFacture{
    private DB db = new DB();
    private ResultSet rs;
    private int ok;
    // insertion
    @Override
    public int add(Facture f) {
        String sql = "INSERT INTO facture VALUES(NULL,?,?,?,?)";
        try {
            db.initPrepart(sql);
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            db.getPstm().setString(1, sdf.format(f.getDate()));
            db.getPstm().setInt(2, f.getConsommation());
            db.getPstm().setInt(3, f.getPrix());
            db.getPstm().setBoolean(4, f.isPaiement());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
    @Override
    public List<Facture> liste() {
        List<Facture> factures = new ArrayList<Facture>();
        String sql = "SELECT * FROM facture";
        try {
            db.initPrepart(sql);
            rs = db.executeSelect();
            while (rs.next()){
                Facture f = new Facture();
                f.setIdF(rs.getInt(1));
                SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
                f.setDate(sdf.parse(rs.getString(2)));
                f.setConsommation(rs.getInt(3));
                f.setPrix(rs.getInt(4));
                f.setPaiement(rs.getBoolean(5));

                factures.add(f);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return factures;
    }
    @Override
    public int update(Facture f) {
        String sql = "UPDATE facture SET paiement = ? WHERE idF = ?";
        try {
            db.initPrepart(sql);
            db.getPstm().setBoolean(1, f.isPaiement());
            db.getPstm().setInt(2, f.getIdF());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

}
