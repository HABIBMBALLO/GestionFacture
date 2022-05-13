package sn.simplon.metier;

import com.sun.source.tree.TryTree;
import sn.simplon.entities.Reglement;

import java.text.SimpleDateFormat;

public class ReglementImpl implements IReglement{

   private DB db = new DB();
   private int ok;
    @Override
    public int add(Reglement r) {
        String sql ="INSERT INTO reglement VALUES(NULL, ?, ?)";

        try {
            db.initPrepart(sql);
            //Gestion des dates en java
            SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
            db.getPstm().setString(1, sdf.format(r.getDate()));
            db.getPstm().setInt(2, r.getFacture().getIdF());

            ok = db.executeMaj();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
}
