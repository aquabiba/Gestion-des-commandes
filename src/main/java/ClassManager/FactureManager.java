package ClassManager;

import JPA.JPA;
import Model.Facture;
import Model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

public class FactureManager {
    private static EntityManager em = JPA.getEntityManager();

    public FactureManager() {
        em = JPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
    }

    private static void executeTransaction(Runnable action) {
        EntityManager em = JPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.run();
            tx.commit();
        } catch (RuntimeException  e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }

    public static void readFacture() {
        List<Facture> factures=em.createQuery("select f from Facture f", Facture.class).getResultList();
        System.out.println("--------------------------  Factures List  --------------------------------");
        for(Facture facture : factures){
            System.out.println("Num de Facture : "+facture.getNumFact()+"\t Date  : "+facture.getDateFact()+" Montant : "+facture.getMontant());
        }
    }

    public static void updateFacture(Facture F, LocalDate dateFacture, double montant, Utilisateur utilisateur) {
        executeTransaction(() -> {
            Facture facture = em.find(Facture.class, F.getNumFact());
            if (facture == null) {
                System.out.println("Facture à modifier n'existe pas !");
            } else {
                facture.setDateFact(dateFacture);
                facture.setMontant(montant);
                facture.setUtilisateur(utilisateur);
                em.merge(facture);
                System.out.println("Facture N° " + facture.getNumFact() + " modifiée avec succès !");
            }
        });
    }

    public static void deleteFacture(int id) {
        executeTransaction(() -> {
            Facture facture = em.find(Facture.class, id);
            if (facture == null) {
                System.out.println("Facture à supprimer n'existe pas !");
            } else {
                em.remove(facture);
                System.out.println("Facture N° " + facture.getNumFact() + " supprimée avec succès !");
            }

        });
        //em.close();
    }

    public static Facture createFacture(LocalDate dateFacture, double montant, Utilisateur utilisateur) {
        EntityManager em = JPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Utilisateur U = em.find(Utilisateur.class,utilisateur.getCodeUt());
        Facture factureF = null;
        try{
            tx.begin();
             factureF = new Facture(dateFacture, montant, U);
            em.persist(factureF);
            System.out.println("facture cree avec succes!!");
            tx.commit();
        }catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }finally {
            em.close();
        }
//        executeTransaction(() -> {
//            em.persist(facture);
//            System.out.println("Facture créée avec succès !");
//        });
//        //em.close();
        return factureF;
    }
}
