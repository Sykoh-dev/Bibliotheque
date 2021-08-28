package Bibliotheque;

import Bibliotheque.data_access.ConnexionFactory;

import java.sql.*;
import java.util.Scanner;

public class TestConnection {




    public static void main(String[] args) {


        // Message de connection avec exception
        System.out.println("Trying the connection");
        try(            Connection connection = ConnexionFactory.getConnection()){
            System.out.println("connection succes");



        }
        catch (SQLException ex){
            System.out.println("connection failed");
            System.out.println("Problem " + ex.getMessage());
        }





    }
}
