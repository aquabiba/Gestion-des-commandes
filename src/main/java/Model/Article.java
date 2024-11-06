package Model;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeart")
    private int codeArt;

    private String desArt;
    private String couleur;
    private Double puArt;
    private int qteStock;

    public Article( String desArt, String couleur, double puArt, int qteStock) {

        this.desArt = desArt;
        this.couleur = couleur;
        this.puArt = puArt;
        this.qteStock = qteStock;
    }
    public Article() {}

    public int getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(int codeArt) {
        this.codeArt = codeArt;
    }

    public String getDesArt() {
        return desArt;
    }

    public void setDesArt(String desArt) {
        this.desArt = desArt;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Double getPuArt() {
        return puArt;
    }

    public void setPuArt(Double puArt) {
        this.puArt = puArt;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    @Override
    public String toString() {
        return " \n" +
                "codeArt=" + codeArt +
                ", desArt='" + desArt + '\'' +
                ", couleur='" + couleur + '\'' +
                ", puArt=" + puArt +
                ", qteStock=" + qteStock
                ;
    }
}
