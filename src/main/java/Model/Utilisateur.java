package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeut")
    private int codeUt;
    private String nomUt;
    private String prenomUt;
    private String fonction;
    @OneToMany(mappedBy = "utilisateur")
    private List<Facture> factures;

    public Utilisateur(String nomUt, String prenomUt, String fonction) {
        this.nomUt = nomUt;
        this.prenomUt = prenomUt;
        this.fonction = fonction;
    }

    public Utilisateur(int codeUt, String nomUt, String prenomUt, String fonction) {
        this.codeUt = codeUt;
        this.nomUt = nomUt;
        this.prenomUt = prenomUt;
        this.fonction = fonction;
    }
    public Utilisateur() {}

    public int getCodeUt() {
        return codeUt;
    }

    public void setCodeUt(int codeUt) {
        this.codeUt = codeUt;
    }

    public String getNomUt() {
        return nomUt;
    }

    public void setNomUt(String nomUt) {
        this.nomUt = nomUt;
    }

    public String getPrenomUt() {
        return prenomUt;
    }

    public void setPrenomUt(String prenomUt) {
        this.prenomUt = prenomUt;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "codeUt=" + codeUt +
                ", nomUt='" + nomUt + '\'' +
                ", prenomUt='" + prenomUt + '\'' +
                ", fonction='" + fonction + '\'' +
                '}';
    }
}

