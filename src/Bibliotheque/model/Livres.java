package Bibliotheque.model;

public class Livres {

    // Variables
    private String ISBN;
    private String nom;
    private String auteur;
    private String edition;
    private int nbrExemplaire;

    // Constructeur


    public Livres() {
    }

    public Livres(String ISBN, String nom, String auteur, String edition, int nbrExemplaire) {
        this.ISBN = ISBN;
        this.nom = nom;
        this.auteur = auteur;
        this.edition = edition;
        this.nbrExemplaire = nbrExemplaire;
    }

    // Getter/Setter


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

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
}
