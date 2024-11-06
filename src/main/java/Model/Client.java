package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numcl")
    private int numCl;
    @Column(name = "nomcl")
    private String nomCl;
    @Column(name = "prenomcl")
    private String prenomCl;
    @Column(name = "adressecl")
    private String adresseCl;
    @Column(name = "telcl")
    private String telCl;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    public Client(String nomCl, String prenomCl, String adresseCl, String telCl, List<Commande> commandes) {
        this.nomCl = nomCl;
        this.prenomCl = prenomCl;
        this.adresseCl = adresseCl;
        this.telCl = telCl;
        this.commandes = commandes;
    }

    public Client(int numCl, String nomCl, String prenomCl, String adresseCl, String telCl) {
        this.numCl = numCl;
        this.nomCl = nomCl;
        this.prenomCl = prenomCl;
        this.adresseCl = adresseCl;
        this.telCl = telCl;
    }

    public Client(String nomCl, String prenomCl, String adresseCl, String telCl) {
        this.nomCl = nomCl;
        this.prenomCl = prenomCl;
        this.adresseCl = adresseCl;
        this.telCl = telCl;
    }

    public Client() {}

    public String getNomCl() {
        return nomCl;
    }

    public void setNomCl(String nomCl) {
        this.nomCl = nomCl;
    }

    public String getPrenomCl() {
        return prenomCl;
    }

    public void setPrenomCl(String prenomCl) {
        this.prenomCl = prenomCl;
    }

    public String getAdresseCl() {
        return adresseCl;
    }

    public void setAdresseCl(String adresseCl) {
        this.adresseCl = adresseCl;
    }

    public String getTelCl() {
        return telCl;
    }

    public void setTelCl(String telCl) {
        this.telCl = telCl;
    }

    public int getNumCl() {
        return numCl;
    }

    public void setNumCl(int numCl) {
        this.numCl = numCl;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return
                "numCl=" + numCl +
                ", nomCl='" + nomCl + '\'' +
                ", prenomCl='" + prenomCl + '\'' +
                ", adresseCl='" + adresseCl + '\'' +
                ", telCl='" + telCl + '\''
                ;
    }
}
