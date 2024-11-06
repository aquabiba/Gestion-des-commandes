package ClassManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import JPA.JPA;
import Model.Utilisateur;

import java.util.List;

public class UtilisateurManager {

    private static final EntityManager em= JPA.getEntityManager();
    //private static final EntityTransaction tx= em.getTransaction();

    private static void executeTransaction(Runnable action) {
        EntityManager em= JPA.getEntityManager();
        EntityTransaction tx= em.getTransaction();
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

    public static Utilisateur createUser(String nom, String prenom, String fonction) {
        EntityManager em= JPA.getEntityManager();
        EntityTransaction tx= em.getTransaction();
        Utilisateur U1 = new Utilisateur(nom, prenom, fonction);
        try{
            tx.begin();
            em.persist(U1);
            tx.commit();
        }catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }


        //       Utilisateur u= new Utilisateur(nom, prenom, fonction);
//        executeTransaction(() -> {
//            //Utilisateur user = new Utilisateur(nom, prenom, fonction);
//            em.persist(u);
//            System.out.println("Utilisateur ajouté avec succès !");
//        });
//        //em.close();
        return U1;
    }

    public static void readUser() {
        List<Utilisateur> utilisateurs=em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
        System.out.println("--------------------------  Utilisateur List  --------------------------------");
        for(Utilisateur utilisateur : utilisateurs){
            System.out.println("Code de l\'Utilisateur : "+utilisateur.getCodeUt()+"\t Nom  : "+utilisateur.getNomUt()+" Prenom : "+utilisateur.getPrenomUt()+"\t Fonction "+utilisateur.getFonction());
        }
    }

    public static void deleteUser(int id) {
        executeTransaction(() -> {
            Utilisateur user = em.find(Utilisateur.class, id);
            if (user != null) {
                em.remove(user);
                System.out.println("Utilisateur supprimé avec succès !");
            } else {
                System.out.println("Utilisateur introuvable.");
            }
        });
    }

    public static void updateUser(Utilisateur U, String nom, String prenom, String fonction) {
        executeTransaction(() -> {
            Utilisateur user = em.find(Utilisateur.class, U.getCodeUt());
            if (user == null) {
                System.out.println("Utilisateur introuvable.");
            } else {
                user.setNomUt(nom);
                user.setPrenomUt(prenom);
                user.setFonction(fonction);
                em.merge(user);
                System.out.println("Utilisateur mis à jour avec succès !");
            }
        });
    }
}
