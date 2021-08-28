package Bibliotheque.data_access;

import Bibliotheque.model.Clients;
import Bibliotheque.model.Emprunts;
import Bibliotheque.model.Livres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpruntsDAOimpl implements EmpruntsDAO {

    @Override
    public boolean insert(Emprunts emprunts) {
        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();

        ){

            int nbrLinesAffected = stmt.executeUpdate(" INSERT INTO Emprunts VALUES " +
                    "('" + emprunts.getId()+ "','" +emprunts.getNomLivre()+ "','" +emprunts.getNomClient()+ "','" +emprunts.getDateEmprunt()+ "','" +emprunts.getDateRetour()+"');");


            return nbrLinesAffected > 0;

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Emprunts getOne(String titre) {
        return null;
    }

    private Emprunts convertToEmprunts(ResultSet rs) throws SQLException{

        String emprunt_id = rs.getString("emprunt_id");
        String emprunt_ISBNLivre = rs.getString("emprunt_ISBNLivre");
        String emprunt_IDUsager= rs.getString("emprunt_IDUsager");
        String emprunt_dateEmprunt = rs.getString("emprunt_dateEmprunt");
        String emprunt_dateRetour = rs.getString("emprunt_dateRetour");


        return new Emprunts(emprunt_id, emprunt_ISBNLivre, emprunt_IDUsager, emprunt_dateEmprunt, emprunt_dateRetour);
    }

    @Override
    public List<Emprunts> getAll() {
        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Emprunts ;");
        ){

            List<Emprunts> list = new ArrayList<>();
            while (rs.next()){
                list.add(convertToEmprunts(rs));
            }
            return list;

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Emprunts emprunts) {
        return false;
    }

    @Override
    public boolean delete(String emprunt_id) {
        try (
                Connection co = ConnexionFactory.getConnection();
                PreparedStatement stmt = co.prepareStatement(" DELETE FROM Emprunts WHERE emprunt_id = ? " );

        ){
            stmt.setString(1,emprunt_id);
            int affected = stmt.executeUpdate();
            return affected > 0;
        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
