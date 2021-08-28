package Bibliotheque.data_access;

import Bibliotheque.model.Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAOimpl implements SectionDAO{

    @Override
    public boolean insert(Section section) {

        try(
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement();

        ){

           int nbrLinesAffected = stmt.executeUpdate(" INSERT INTO Section VALUES " +
                 "("  +section.getId()+", '"+ section.getName()+"'," +section.getDelegateId()+");");

           return nbrLinesAffected > 0;

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
           return false;




    }

    private Section convertToSection(ResultSet rs) throws SQLException{

        int id = rs.getInt("section_id");
        String name = rs.getString("section_name");
        int delegateId = rs.getInt("delegate_id");

        return new Section(id, name, delegateId);
    }

    @Override
    public Section getOne(Integer id) {
        try (
                Connection connection = ConnexionFactory.getConnection();
                Statement stmt = connection.createStatement(); // objet qui permet de paramétrer la requete
                ResultSet rs = stmt.executeQuery("SELECT * FROM Section WHERE section_id =" + id + ";");
        ) {
            if (rs.next()){

                return convertToSection( rs );

            };

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Section> getAll() {

            try (
                    Connection connection = ConnexionFactory.getConnection();
                    Statement stmt = connection.createStatement(); // objet qui permet de paramétrer la requete
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Section ;");
            ) {

                // rs.next(); // permet de lire ligne par ligne
                List<Section> list = new ArrayList<>();
                while (rs.next()) {
                    list.add(convertToSection(rs));

/*                // extraire données
                int id = rs.getInt("section_id");
                String name = rs.getString("section_name");
                int delegateId = rs.getInt("delegate_id");

                Section section = new Section(id, name, delegateId);*/


                    // EQUIVALENT A
/*                list.add(
                        new Section(
                                rs.getInt("section_id"),
                                 rs.getString("section_name"),
                                   rs.getInt("delegate_id")
                           )
                );*/
                }
                return list;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return null;
        }


    @Override
    public boolean update(Section section) {
        try(

                // On utilise prepare au lieu de create pour éviter d'injecter du codeSQL par des chaines de caractères
                Connection co = ConnexionFactory.getConnection();
                PreparedStatement stmt = co.prepareStatement("UPDATE Section" +
                        " SET section_name = ?, delegate_id = ? " +
                        "WHERE section_id= ?" );

                ){

            stmt.setString(1, section.getName());
            stmt.setInt(2, section.getDelegateId());
            stmt.setInt(3, section.getId());
            int affected = stmt.executeUpdate();

            return affected > 0;


        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        return false;




    }

    @Override
    public boolean delete(Integer id) {

        try (
                Connection co = ConnexionFactory.getConnection();
                Statement stmt = co.createStatement();

                ){

            int affected = stmt.executeUpdate(" DELETE FROM Section WHERE section_id =  "+ id );
            return affected > 0;
        }
        catch( SQLException ex){
            ex.printStackTrace();
        }
        return false;

    }
}
