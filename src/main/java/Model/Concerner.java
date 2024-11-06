package Model;

import javax.persistence.*;

@Entity
@Table(name = "concerner")
public class Concerner  {
    @EmbeddedId
    private concerner_PK pk;
    @Column(name = "qtecom")
    private int qtecom;

    public Concerner(concerner_PK pk, int qtecom) {
        this.pk = pk;
        this.qtecom = qtecom;
    }

    public Concerner() {
    }

    public concerner_PK getPk() {
        return pk;
    }
    public void setPk(concerner_PK pk) {
        this.pk = pk;
    }

    public int getQtecom() {
        return qtecom;
    }

    public void setQtecom(int qtecom) {
        this.qtecom = qtecom;
    }
}
