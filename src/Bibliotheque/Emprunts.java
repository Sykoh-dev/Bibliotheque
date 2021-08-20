package Bibliotheque;

public class Emprunts {

    // Variables
    private String nomLivre;
    private String nomClient;
    private String dateEmprunt;
    private String dateRetour;

    // Constructeur
    public Emprunts(String nomLivre, String nomClient, String dateEmprunt, String dateRetour) {
        this.nomLivre = nomLivre;
        this.nomClient = nomClient;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    // Getter/Setter
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

    public void menuEmprunt(){
        System.out.println("1. Consulter les emprunts");
        System.out.println("2. Historique des emprunts");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Restituer un livre");
        System.out.println("5. quitter");
    }
}
