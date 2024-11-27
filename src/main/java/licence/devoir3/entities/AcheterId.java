package licence.devoir3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AcheterId implements Serializable {
    private static final long serialVersionUID = -2712134436439302276L;
    @Column(name = "numAction", nullable = false)
    private Integer numAction;

    @Column(name = "numTrader", nullable = false)
    private Integer numTrader;

    public Integer getNumAction() {
        return numAction;
    }

    public void setNumAction(Integer numAction) {
        this.numAction = numAction;
    }

    public Integer getNumTrader() {
        return numTrader;
    }

    public void setNumTrader(Integer numTrader) {
        this.numTrader = numTrader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AcheterId entity = (AcheterId) o;
        return Objects.equals(this.numAction, entity.numAction) &&
                Objects.equals(this.numTrader, entity.numTrader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAction, numTrader);
    }

}