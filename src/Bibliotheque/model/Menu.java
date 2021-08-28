package Bibliotheque.model;

import java.util.Scanner;

public class Menu {



    public static void menuPrincipal(){
        System.out.println("\nBienvenue à la bibliothèque ");
        System.out.println(" ----------------------");
        System.out.println(" Que désirez-vous faire");
        System.out.println(" ----------------------");
        System.out.println("\n 1. Gestion des livres");
        System.out.println(" 2. Gestion des clients");
        System.out.println(" 3. Gestion des emprunts");
        System.out.println(" 4. Quitter ");
    }

    public static void menuLivre(){
        System.out.println("   -----------------------------");
        System.out.println("1. Consulter la liste des livres");
        System.out.println("2. Modification d'un livre");
        System.out.println("3. Ajout d'un livre");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. quitter");
        System.out.println("   -----------------------------");

    }

    public static void menuEmprunt(){
        System.out.println("   ----------------------");
        System.out.println("1. Consulter les emprunts");
        System.out.println("2. Emprunter un livre");
        System.out.println("3. Restituer un livre");
        System.out.println("4. quitter");
        System.out.println("   ----------------------");
    }

    public static void menuClients(){
        System.out.println("   -----------------");
        System.out.println("1. Ajout d'un client");
        System.out.println("2. Supprimer un client");
        System.out.println("3. Modifier un client");
        System.out.println("4. Rechercher un client");
        System.out.println("5. quitter");
        System.out.println("   -----------------");
    }

    public static Livres creationLivre(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'ISBN");
        String ISBN = sc.nextLine();
        System.out.println("Entrez le titre du livre");
        String nom = sc.nextLine();
        System.out.println("Entrez l'auteur");
        String auteur = sc.nextLine();
        System.out.println("Entrez l'édition");
        String edition = sc.nextLine();
        System.out.println("Entrez le nombre(s) d'exemplaire(s)");
        int nbrExemplaire = Integer.parseInt(sc.nextLine());

        return new Livres( ISBN, nom, auteur, edition, nbrExemplaire );


    }

    public static String supLivre(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'ISBN");
        String ISBN = sc.nextLine();

        return (ISBN);

    }
    public static Livres updateLivre(){

        Scanner sc = new Scanner(System.in);

        Livres livres3 = new Livres();

        System.out.println("Entrez le nombre d'exemplaire à changer");
        int nbrExemplaire = Integer.parseInt(sc.nextLine());

        System.out.println("Indiquez l'ISBN du livre correspondant");
        String ISBNUpdate = sc.nextLine();

        livres3.setNbrExemplaire(nbrExemplaire);
        livres3.setISBN(ISBNUpdate);

        return livres3;

            }


    public static Clients creationClients(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'id client ");
        String client_id  = sc.nextLine();
        System.out.println("Entrez le nom du client");
        String client_nom = sc.nextLine();
        System.out.println("Entrez le prenom du client");
        String client_prenom = sc.nextLine();
        System.out.println("Entrez le numéro ");
        String client_numero = sc.nextLine();
        System.out.println("Entrez la rue");
        String client_rue = sc.nextLine();
        System.out.println("Entrez la ville");
        String client_ville = sc.nextLine();
        System.out.println("Entrez le code postal ");
        String client_codePostal = sc.nextLine();
        System.out.println("Entrez le mail ");
        String client_mail = sc.nextLine();
        System.out.println("Entrez le statut ");
        String client_statut = sc.nextLine();

        return new Clients( client_id, client_nom, client_prenom, client_numero, client_rue, client_ville, client_codePostal, client_mail, client_statut );


    }

    public static String supClients(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'id client à supprimer'");
        String client_id = sc.nextLine();

        return (client_id);

    }

    public static Clients updateClient(){

        Scanner sc = new Scanner(System.in);

        Clients clients3 = new Clients();

        System.out.println("Entrez le statut à changer");
        String statut = sc.nextLine();

        System.out.println("Indiquez l'id du client");
        String client_id = sc.nextLine();

        clients3.setStatut(statut);
        clients3.setId(client_id);

        return clients3;

    }

    public static Emprunts creationEmprunt(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'id de l'emprunt'");
        String id = sc.nextLine();
        System.out.println("Entrez l'ISBN du livre");
        String nomLivre = sc.nextLine();
        System.out.println("Entrez le nom du client");
        String nomClient = sc.nextLine();
        System.out.println("Entrez la date d'emprunt");
        String dateEmprunt = sc.nextLine();
        System.out.println("Entrez la date de retour prévue");
        String dateRetour = sc.nextLine();

        return new Emprunts( id, nomLivre, nomClient, dateEmprunt, dateRetour );


    }

    public static String supEmprunt(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez l'id de l'emprunt pour faire le retour");
        String id = sc.nextLine();

        return (id);

    }
}
