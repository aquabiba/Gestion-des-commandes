package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numCom")
    private int numCom;

    @Column(name = "datecom")
    private LocalDate dateCom;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "numcl", nullable = false)
    private Client client;

    public Commande(LocalDate dateCom, Client client) {

        this.dateCom = dateCom;
        this.client = client;
    }
    public Commande() {}

    public int getNumCom() {
        return numCom;
    }

    public void setNumCom(int numCom) {
        this.numCom = numCom;
    }

    public LocalDate getDateCom() {
        return dateCom;
    }

    public void setDateCom(LocalDate dateCom) {
        this.dateCom = dateCom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return
                "numCom=" + numCom +
                ", dateCom=" + dateCom +
                ", client=" + client
                ;
    }
}
