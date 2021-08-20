package Bibliotheque;

public class Livres {

    // Variables
    private String nom;
    private String auteur;
    private String edition;
    private int nbrExemplaire;

    // Constructeur
    public Livres(String nom, String auteur, String edition, int nbrExemplaire) {
        this.nom = nom;
        this.auteur = auteur;
        this.edition = edition;
        this.nbrExemplaire = nbrExemplaire;
    }

    // Getter/Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getNbrExemplaire() {
        return nbrExemplaire;
    }

    public void setNbrExemplaire(int nbrExemplaire) {
        this.nbrExemplaire = nbrExemplaire;
    }

    public void menuLivre(){
        System.out.println("1. Consulter la liste des livres");
        System.out.println("2. Modification d'un livre");
        System.out.println("3. Ajout ou suppression d'un exemplaire");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. quitter");

    }

}
