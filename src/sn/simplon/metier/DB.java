package sn.simplon.metier;

import javax.sql.ConnectionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    //pour la connexion
    private Connection cnx;
    //pour les resultats des requettes de type SELECT
    private ResultSet rs;
    //pour les requettes preparees
    private PreparedStatement pstm;
    //pour les resultats des requettes de type mis a jour MAJ(INSERT,UPDATE,DELETE)
    private int ok;

    private void getConnection() {
        String url = "jdbc:mysql://localhost:3306/gestionFacture";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx =DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void initPrepart(String sql) {

        try {
            getConnection();
            pstm = cnx.prepareStatement(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet executeSelect() {
        try {
            rs = pstm.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
    public void closeConnection(){
        try{
            if(cnx != null)
                cnx.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }
}


 

