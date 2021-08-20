package Bibliotheque;

public class Clients {
    private String nom;
    private String prenom;
    private String numero;
    private String rue;
    private String ville;
    private String codePostal;
    private String mail;
    private String statut;

    public Clients(String nom, String prenom, String numero, String rue, String ville, String codePostal, String mail, String statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.mail = mail;
        this.statut = statut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

   public void menuClients(){
    System.out.println("1. Ajout d'un client");
    System.out.println("2. Supprimer un client");
    System.out.println("3. Modifier un client");
    System.out.println("4. Rechercher un client");
    System.out.println("5. quitter");
}
}
