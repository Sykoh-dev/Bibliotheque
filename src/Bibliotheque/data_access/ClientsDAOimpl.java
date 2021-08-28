package Bibliotheque.data_access;

import Bibliotheque.model.Clients;
import Bibliotheque.model.Livres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAOimpl implements ClientsDAO {

    @Override
    public boolean insert(Clients client) {
        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();

        ){

            int nbrLinesAffected = stmt.executeUpdate(" INSERT INTO Clients VALUES " +
                   "('" + client.getId()+ "','" +client.getNom()+ "','" +client.getPrenom()+ "','" +client.getNumero()+ "','" +client.getRue()+ "','" +client.getVille()+ "','" +client.getCodePostal()+ "','" +client.getMail()+ "','" +client.getStatut()+"');");


            return nbrLinesAffected > 0;

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Clients getOne(String titre) {
        return null;
    }

    private Clients convertToClients(ResultSet rs) throws SQLException{

        String client_id = rs.getString("client_id");
        String client_nom = rs.getString("client_nom");
        String client_prenom = rs.getString("client_prenom");
        String client_numero = rs.getString("client_numero");
        String client_rue = rs.getString("client_rue");
        String client_ville = rs.getString("client_ville");
        String client_codePostal = rs.getString("client_codePostal");
        String client_mail = rs.getString("client_mail");
        String client_statut = rs.getString("client_statut");

        return new Clients(client_id, client_nom, client_prenom, client_numero, client_rue, client_ville, client_codePostal, client_mail, client_statut);
    }

    @Override
    public List<Clients> getAll() {
        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Clients ;");
        ){

            List<Clients> list = new ArrayList<>();
            while (rs.next()){
                list.add(convertToClients(rs));
            }
            return list;

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Clients client) {
        try(


                Connection co = ConnexionFactory.getConnection();
                PreparedStatement stmt = co.prepareStatement("UPDATE Clients" +
                        " SET client_statut = ? " +
                        "WHERE client_id = ?" );

        ){

            stmt.setString(1, client.getStatut());
            stmt.setString(2, client.getId());
            int affected = stmt.executeUpdate();

            return affected > 0;


        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String client_id) {
        try (
                Connection co = ConnexionFactory.getConnection();
                PreparedStatement stmt = co.prepareStatement(" DELETE FROM Clients WHERE client_id = ? " );

        ){
            stmt.setString(1,client_id);
            int affected = stmt.executeUpdate();
            return affected > 0;
        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

}
