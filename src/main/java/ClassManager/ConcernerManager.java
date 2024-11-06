package ClassManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import JPA.JPA;
import Model.Concerner;
import Model.concerner_PK;

import java.util.List;

public class ConcernerManager {

    private static EntityManager em = JPA.getEntityManager();
    private static final EntityTransaction tx = em.getTransaction();

    private static void executeTransaction(Runnable action) {
        try {
            tx.begin();
            action.run();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // Create a new Concerner record
    public static void createConcerner(concerner_PK pk, int quantity) {
        executeTransaction(() -> {
            Concerner concerner = new Concerner(pk, quantity);
            em.persist(concerner);
            System.out.println("Concerner record created successfully!");
        });
    }

    // Read a Concerner record by its ID
    public static void readConcerner(int id) {
        List<Concerner> concerners=em.createQuery("select c from Concerner c ", Concerner.class).getResultList();
        System.out.println("--------------------------  Factures List  --------------------------------");
        for(Concerner c : concerners){
            System.out.println("Num de Facture : "+c.getPk().getNumfact()+"\t Num de Commande  : "+
                    c.getPk().getNumcom()+" Code Article : "+c.getPk().getCodeart()+" Quantité Commander"+c.getQtecom());
        }
    }

    // Update a Concerner record by its ID
    public static void updateConcerner(int id, int quantity) {
        executeTransaction(() -> {
            Concerner concerner = em.find(Concerner.class, id);
            if (concerner == null) {
                System.out.println("Concerner record not found.");
            } else {
                concerner.setQtecom(quantity);
                em.merge(concerner);
                System.out.println("Concerner record updated successfully!");
            }
        });
    }

    // Delete a Concerner record by its ID
    public static void deleteConcerner(int id) {
        executeTransaction(() -> {
            Concerner concerner = em.find(Concerner.class, id);
            if (concerner != null) {
                em.remove(concerner);
                System.out.println("Concerner record deleted successfully!");
            } else {
                System.out.println("Concerner record not found.");
            }
        });
    }
}
