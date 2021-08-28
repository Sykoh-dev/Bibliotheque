package Bibliotheque.model;

public class Emprunts {

    // Variables
    private String id;
    private String nomLivre;
    private String nomClient;
    private String dateEmprunt;
    private String dateRetour;

    // Constructeur


    public Emprunts() {
    }

    public Emprunts(String id, String nomLivre, String nomClient, String dateEmprunt, String dateRetour) {
        this.id = id;
        this.nomLivre = nomLivre;
        this.nomClient = nomClient;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    // Getter/Setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }
}
