package Bibliotheque.data_access;

import Bibliotheque.model.Livres;
import Bibliotheque.model.Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivresDAOimpl implements LivresDAO {

    @Override
    public boolean insert(Livres livres) {
        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();

        ){

            int nbrLinesAffected = stmt.executeUpdate(" INSERT INTO Livres VALUES " +
                    "('"  +livres.getISBN()+ "','" + livres.getNom()+ "','" + livres.getAuteur()+ "','"+ livres.getEdition()+ "'," + livres.getNbrExemplaire()+");");


            return nbrLinesAffected > 0;

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    private Livres convertToLivres(ResultSet rs) throws SQLException{

        String ISBN = rs.getString("ISBN");
        String titre = rs.getString("livre_titre");
        String auteur = rs.getString("livre_auteur");
        String edition= rs.getString("livre_edition");
        int exemplaire = rs.getInt("livre_nbrExemplaires");

        return new Livres(ISBN, titre, auteur, edition, exemplaire);
    }

    @Override
    public Livres getOne(String titre) {
        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM livres WHERE livre_titre ="+ titre + ";");
        ){
            if ( rs.next()){
                return convertToLivres( rs );
            }


        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Livres> getAll() {
        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM livres ;");
        ){

            List<Livres> list = new ArrayList<>();
            while (rs.next()){
                list.add(convertToLivres(rs));
            }
            return list;

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Livres Livres) {
        try(


                Connection co = ConnexionFactory.getConnection();
                PreparedStatement stmt = co.prepareStatement("UPDATE Livres" +
                        " SET livre_nbrExemplaires = ? " +
                        "WHERE ISBN = ?" );

        ){

            stmt.setInt(1, Livres.getNbrExemplaire());
            stmt.setString(2, Livres.getISBN());
            int affected = stmt.executeUpdate();

            return affected > 0;


        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String ISBN) {
        try (
                Connection co = ConnexionFactory.getConnection();
                PreparedStatement stmt = co.prepareStatement(" DELETE FROM Livres WHERE ISBN = ? " );

        ){
            stmt.setString(1,ISBN);
            int affected = stmt.executeUpdate();
            return affected > 0;
        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
