package Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class concerner_PK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "numfact")
    private int numfact;
    @Column(name = "codeart")
    private int codeart;
    @Column(name = "numcom")
    private int numcom;

    public concerner_PK(int codeart, int numfact, int numcom) {
        this.codeart = codeart;
        this.numfact = numfact;
        this.numcom = numcom;
    }
    public concerner_PK() {}
    public int getCodeart() {
        return codeart;
    }
    public void setCodeart(int codeart) {
        this.codeart = codeart;
    }
    public int getNumfact() {
        return numfact;
    }
    public void setNumfact(int numfact) {
        this.numfact = numfact;
    }
    public int getNumcom() {
        return numcom;
    }
    public void setNumcom(int numcom) {
        this.numcom = numcom;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        concerner_PK that = (concerner_PK) o;
        return codeart == that.codeart && numfact == that.numfact && numcom == that.numcom;
    }
    @Override
    public int hashCode() {
        return Objects.hash(codeart, numfact, numcom);
    }
}
