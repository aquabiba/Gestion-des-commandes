package ClassManager;

import JPA.JPA;
import Model.Article;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ArticleManager {

    private final EntityManager em;
    private final EntityTransaction tx;

    public ArticleManager() {
        this.em = JPA.getEntityManager();
        this.tx = em.getTransaction();
    }

    private void executeTransaction(Runnable action) {

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

    public void createArticle(String des, String couleur, double pu, int qte) {
        executeTransaction(() -> {
            Article article = new Article(des, couleur, pu, qte);
            em.persist(article);
            System.out.println("Article ajouté avec succès !");
        });
    }

    public void readArticle(int id) {
        Article article = em.find(Article.class, id);
        if (article == null) {
            System.out.println("L'article à afficher est inexistant !");
        } else {
            System.out.println("Description de l'article : \n" + article);
        }
    }

    public void updateArticle(int id, String des, String couleur, double pu, int qte) {
        executeTransaction(() -> {
            Article article = em.find(Article.class, id);
            if (article == null) {
                System.out.println("L'article à modifier est inexistant !");
            } else {
                article.setDesArt(des);
                article.setCouleur(couleur);
                article.setPuArt(pu);
                article.setQteStock(qte);
                em.merge(article);
                System.out.println("Article mis à jour avec succès !");
            }
        });
    }

    public void deleteArticle(int id) {
        executeTransaction(() -> {
            Article article = em.find(Article.class, id);
            if (article == null) {
                System.out.println("L'article à supprimer est inexistant !");
            } else {
                em.remove(article);
                System.out.println("Article supprimé avec succès !");
            }
        });
    }
}
