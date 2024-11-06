package MainTest;

import ClassManager.ClientManager;
import ClassManager.CommandeManager;
import ClassManager.FactureManager;
import ClassManager.UtilisateurManager;
import Model.Client;
import Model.Commande;
import Model.Facture;
import Model.Utilisateur;
import JPA.JPA;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Test_2 {
    public static void main(String[] args) {
        EntityManager em = JPA.getEntityManager();
        //creer utilisateur :
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Utilisateur user1 = UtilisateurManager.createUser("Boualam","younesse","Assistant");
        Utilisateur user2 = UtilisateurManager.createUser("barahal","ayoub","Assistant");
        Utilisateur user3 = UtilisateurManager.createUser("agoujil","khaoula","Assistante");
        //afficher users
        UtilisateurManager.readUser();
        //creer client ;
        Client cl1 = ClientManager.createClient("houji","Mohammed","salam agadir","0666887455");
        ClientManager.readClient();
        //creer commande :
        LocalDate date = LocalDate.of(2024,10,10);
        LocalDate date2 = LocalDate.of(2025,10,18);
        Commande commande= CommandeManager.createCommande(date,cl1);
        commande.setClient(cl1);
        commande.setDateCom(date2);
        CommandeManager.updateCommande(commande);
        //CommandeManager.deleteCommande(commande);
        CommandeManager.readCommande();
        //Creer facture :
        Utilisateur U1=em.find(Utilisateur.class, 1);
        Facture F1= FactureManager.createFacture(date2,1599,U1);
        Facture F2= FactureManager.createFacture(date,599,user1);
        Facture F3= FactureManager.createFacture(date2,200,user2);
        Facture F4= FactureManager.createFacture(date,300,user3);

       FactureManager.readFacture();




        // afficher facture :
       // FactureManager.readFacture();

        // modifier facture :
        //FactureManager.updateFacture(F1,String.valueOf(LocalDate.now()),1000,user2);

        // supprimer facture :
        //FactureManager.deleteFacture(F1.getNumFact());

    }
}
