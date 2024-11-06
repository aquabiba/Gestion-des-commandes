package ClassManager;

import JPA.JPA;
import Model.Client;
import Model.Commande;
import Model.Facture;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CommandeManager {

    public static EntityManager  em=JPA.getEntityManager() ;

    private static void executeTransaction(Runnable action) {
        EntityManager em = JPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.run();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    public static Commande createCommande(LocalDate D, Client cl) {
//        // Validate input
//        if (D == null || cl == null) {
//            throw new IllegalArgumentException("Date and Client must not be null");
//        }
//
//        EntityManager em = JPA.getEntityManager();
//        Commande c = null;
//
//        try {
//            Client cl1 = em.find(Client.class, cl.getNumCl());
//            if (cl1 == null) {
//                throw new IllegalArgumentException("Client not found with the provided ID");
//            }else{
//            c = new Commande(D, cl1);
//            Commande finalC = c;
//            executeTransaction(() -> {
//                this.em.persist(finalC);
//                if(em.find(Commande.class,finalC.getNumCom())==null){
//                    System.out.println("Commande: "+finalC.getNumCom()+" not found ");
//                }else{
//                System.out.println("Commande created successfully!");
//            }});}
//        } catch (Exception e) {
//            System.err.println("Error while creating commande: " + e.getMessage());
//            // Consider rethrowing or handling the exception as appropriate
//        } finally {
//            if (em != null && em.isOpen()) {
//                em.close();
//            }
//        }
        EntityManager em = JPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Client cl1= em.find(Client.class, cl.getNumCl());
        Commande commande=null ;

        try{
            commande = new Commande(D,cl1);
            tx.begin();
            em.persist(commande);
            System.out.println("commande cree avec succes!!");
            tx.commit();
        }catch (Exception e){
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return commande;
    }


    public static void readCommande() {
        List<Commande> commandes=em.createQuery("select c from Commande c", Commande.class).getResultList();
        System.out.println("--------------------------  commande List  --------------------------------");
        if(!commandes.isEmpty()) {
        for(Commande c:commandes) {
            System.out.println("Numero Cmd : "+c.getNumCom()+"\t date cmd : "+c.getDateCom()+"\t client : "+c.getClient().getNomCl());
        }
        }else{
            System.out.println("la liste est vide ");
        }
    }

    public static void updateCommande(Commande c) {
        executeTransaction(()->{
            em.merge(c);
            System.out.println("commade Modifiee avec succes !!");
        });
    }

    public static void deleteCommande(Commande c) {
        EntityManager em = JPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(c);
        tx.commit();
//        executeTransaction(()->{
//            em.remove(c);
//            System.out.println("commade Supprimee avec succes !!");
//        });
    }

}
