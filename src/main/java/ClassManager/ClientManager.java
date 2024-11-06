package ClassManager;

import JPA.JPA;
import Model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.List;

public class ClientManager {
    private static final EntityManager em = JPA.getEntityManager();
    private static final EntityTransaction tx = em.getTransaction();

    public ClientManager() {
    }

    public static Client createClient(String N, String P, String A, String T) {
        Client cl = new Client(N,P,A,T);
        try{
            tx.begin();
            em.persist(cl);
            tx.commit();
            System.out.println("Client cree avec succes !!");
        }catch (Exception e){
            if(tx.isActive()){tx.rollback();}
            e.printStackTrace();
        }
        return cl;
    }

    public static void deleteClient(Client cl) {
        try{
            tx.begin();
            em.remove(cl);
            tx.commit();
            System.out.println("Client supprime avec succes !!");
        }catch (Exception e){
            if(tx.isActive()){tx.rollback();}
            e.printStackTrace();
        }
    }

    public static void updateClient(int id,String N, String P, String A,String T) {

        try{
            tx.begin();
            Client cl = em.find(Client.class, id);
            if (cl==null){
                System.out.println("ce client n'existe pas !!");
            }else {
                cl.setNomCl(N);
                cl.setPrenomCl(P);
                cl.setAdresseCl(A);
                cl.setTelCl(T);
                em.merge(cl);
                System.out.println("le client N° :"+cl.getNumCl()+" , est modifie avec succes ");
                tx.commit();
            }
        }catch (Exception e){
            if(tx.isActive()){tx.rollback();}
            e.printStackTrace();
        }
    }

    public static void readClient() {
        List<Client> clients=em.createQuery("select c from Client c",Client.class).getResultList();
        System.out.println("--------------------------  Client --------------------------------");
        for(Client client : clients){
            System.out.println("ID : "+client.getNumCl()+"\t Nom : "+client.getNomCl()+"\t Prenom : "+client.getPrenomCl()+"\t Adresse : "
                    +client.getAdresseCl()+"\t Tel :"+client.getTelCl());
        }
    }

}
