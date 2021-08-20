package Bibliotheque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choix;

        Bibliotheque bibliotheque = new Bibliotheque();
        Livres livre = new Livres(null,null, null,0);
        Emprunts emprunt = new Emprunts("L'île mystérieuse","Widart", "14/02/2021", "En cours");
        Clients client = new Clients("Widart","Jerome", "8","Ateliers","Chenois","6761","j.w@outlook.com","Actif");

        // Création du menu de départ pour la gestion de la bibliothèque
        System.out.println("\nBienvenue à la bibliothèque " + bibliotheque.getNom() + " de " + bibliotheque.getVille());
        System.out.println(" Que désirez-vous faire");
        System.out.println(" ----------------------");
        System.out.println("\n 1. Gestion des livres");
        System.out.println(" 2. Gestion des clients");
        System.out.println(" 3. Gestion des emprunts");
        System.out.println(" 4. Quitter ");

        choix = sc.nextLine().charAt(0);

        // Choix d'un sous menu
        while ( (choix!='4')){
            if ( (choix=='1') || (choix=='2') || (choix=='3')){
                switch ( choix ){
                    case '1':
                        livre.menuLivre();
                        break;

                    case '2':
                        client.menuClients();
                        break;

                    default:
                        emprunt.menuEmprunt();
                }
                choix = sc.nextLine().charAt(0);

            }
            // Message d'erreur si mauvaise saissie
            else{
                System.out.println("Choix invalide veuillez recommencez");
                choix = sc.nextLine().charAt(0);
            }
        }





    }
}
