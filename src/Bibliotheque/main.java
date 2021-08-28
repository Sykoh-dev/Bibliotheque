package Bibliotheque;
import Bibliotheque.data_access.*;
import Bibliotheque.model.*;

import java.util.List;
import java.util.Scanner;
import static Bibliotheque.model.Menu.*;

public class main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        char choix;
        LivresDAO dao = new LivresDAOimpl();
        ClientsDAO dao1 = new ClientsDAOimpl();
        EmpruntsDAO dao2= new EmpruntsDAOimpl();


        // Boucle principial du menu de gestion des choix avec traitement de mauvaise saissie
        do{

            menuPrincipal();

            choix = sc.nextLine().charAt(0);

            if ( (choix=='1') || (choix=='2') || (choix=='3') || (choix=='4'))  {
                switch ( choix ){
                    case '1':
                        do{
                        menuLivre();
                        choix = sc.nextLine().charAt(0);
                        switch (choix){
                            case '1':
                                List<Livres> livres = dao.getAll();
                                livres.forEach((livres1 -> System.out.format("%s - %s - %s - %s - %d\n", livres1.getISBN(),livres1.getNom(),livres1.getAuteur(),livres1.getEdition(),livres1.getNbrExemplaire())));
                                break;
                                // Mdoifictation des exemplaires d'un livre
                            case '2':
                                Livres livres3 = Menu.updateLivre();
                                if (dao.update( livres3))
                                    System.out.println("succes");
                                else
                                    System.out.println("failure");
                                break;
                            case '3':
                                Livres livres1 = Menu.creationLivre();
                                if (dao.insert(livres1))
                                    System.out.println("Succes");
                                else
                                    System.out.println("failure");
                                break;
                            case '4':
                                String ISBN = Menu.supLivre();
                                if(dao.delete(ISBN) )
                                    System.out.println("succes");
                                else
                                    System.out.println("failure");
                                break;
                            case '5':

                                break;
                        }
                        }while ( (choix!='5'));
                        break;

                    case '2':
                        do{
                        menuClients();
                        choix = sc.nextLine().charAt(0);
                            switch (choix){
                                case '1':
                                    Clients clients2 = Menu.creationClients();
                                    if (dao1.insert(clients2))
                                        System.out.println("Succes");
                                    else
                                        System.out.println("failure");
                                    break;
                                case '2':
                                    String client_id = Menu.supClients();
                                    if(dao1.delete(client_id))
                                        System.out.println("succes");
                                    else
                                        System.out.println("failure");
                                    break;
                                case '3':
                                    Clients clients3 = Menu.updateClient();
                                    if (dao1.update(clients3))
                                        System.out.println("succes");
                                    else
                                        System.out.println("failure");
                                    break;
                                case '4':
                                    List<Clients> clients = dao1.getAll();
                                    clients.forEach((clients1 -> System.out.format("%s - %s - %s - %s - %s - %s - %s - %s - %s\n", clients1.getId(), clients1.getNom(), clients1.getPrenom(), clients1.getNumero(), clients1.getRue(), clients1.getVille(), clients1.getCodePostal(), clients1.getMail(), clients1.getStatut())));
                                    break;
                                case '5':

                                    break;
                            }
                        }while ( (choix!='5'));
                        break;

                    case '3':
                        do{
                        menuEmprunt();
                        choix = sc.nextLine().charAt(0);
                            switch (choix){
                                case '1':
                                    List<Emprunts> emprunts = dao2.getAll();
                                    emprunts.forEach((emprunts1 -> System.out.format("%s - %s - %s - %s - %s\n", emprunts1.getId(),emprunts1.getNomLivre(),emprunts1.getNomClient(),emprunts1.getDateEmprunt(),emprunts1.getDateRetour())));
                                    break;
                                case '2':
                                    Emprunts emprunts1 = Menu.creationEmprunt();
                                    if (dao2.insert(emprunts1))
                                        System.out.println("Succes");
                                    else
                                        System.out.println("failure");
                                    break;
                                case '3':
                                    String id = Menu.supEmprunt();
                                    if(dao2.delete(id) )
                                        System.out.println("succes");
                                    else
                                        System.out.println("failure");
                                    break;
                                case '4':

                                    break;

                            }
                        }while ( (choix!='4'));
                        break;
                }


            }
            // Message d'erreur si mauvaise saissie
            else{
                System.out.println("Choix invalide veuillez recommencez");
                choix = sc.nextLine().charAt(0);
            }
        }while ( (choix!='4'));








        /*System.out.println("---GET ALL---");
        SectionDAO dao = new SectionDAOimpl();

        List<Section> sections = dao.getAll();

        sections.forEach((sect -> System.out.format("%d - %s - %d\n", sect.getId(), sect.getName(), sect.getDelegateId())));

        System.out.println("---GET ONE---");
        Section section = dao.getOne(1010);
        System.out.format("%d - %s - %d\n", section.getId(), section.getName(), section.getDelegateId());

        System.out.println("----INSERT---");
        Section section1 = new Section(999, "test insert",12);
        if (dao.insert(section1))
            System.out.println("Succes");
        else
            System.out.println("failure");

        System.out.println("---UPDATE---");
        section1.setName("Test modified");
        section1.setDelegateId(18974);
        if (dao.update( section1 ))
        System.out.println("succes");
        else
        System.out.println("failure");

        section = dao.getOne(999);
        System.out.format("%d - %s - %d\n", section.getId(), section.getName(), section.getDelegateId());

        System.out.println("---DELETE----");
        if(dao.delete(section1.getId()) )
            System.out.println("succes");
        else
            System.out.println("failure");*/
    }
}
