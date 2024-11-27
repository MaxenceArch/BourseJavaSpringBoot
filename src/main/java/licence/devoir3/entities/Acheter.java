package licence.devoir3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "acheter")
public class Acheter {
    @EmbeddedId
    private AcheterId id;

    @Column(name = "montantAchat", nullable = false)
    private Double montantAchat;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    public AcheterId getId() {
        return id;
    }

    public void setId(AcheterId id) {
        this.id = id;
    }

    public Double getMontantAchat() {
        return montantAchat;
    }

    public void setMontantAchat(Double montantAchat) {
        this.montantAchat = montantAchat;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

}