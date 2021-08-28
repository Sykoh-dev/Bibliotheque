package Bibliotheque.data_access;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionFactory  {

    // Connection à la base de donnée SQL server
    public static final String dbURL = "jdbc:sqlserver://localhost:1434;databaseName=Bibliothèque";
    public static final String user = "jerom";
    public static final String pass = "root";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbURL, user, pass);
    }



}

