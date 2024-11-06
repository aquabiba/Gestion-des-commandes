package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numfact", nullable = false)
    private int numFact;

    private LocalDate dateFact;
    private double montant;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codeut")
    private Utilisateur utilisateur;

    public Facture() {}

    public Facture(LocalDate dateFact, double montant, Utilisateur utilisateur) {
        this.dateFact = dateFact;
        this.montant = montant;
        this.utilisateur = utilisateur;
    }

    public int getNumFact() {
        return numFact;
    }

    public void setNumFact(int numFact) {
        this.numFact = numFact;
    }

    public LocalDate getDateFact() {
        return dateFact;
    }

    public void setDateFact(LocalDate dateFact) {
        this.dateFact = dateFact;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return
                "numFact=" + numFact +
                ", dateFact=" + dateFact +
                ", montant=" + montant +
                ", utilisateur=" + utilisateur
                ;
    }

}

