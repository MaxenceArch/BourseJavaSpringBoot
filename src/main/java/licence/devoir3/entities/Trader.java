package licence.devoir3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trader")
public class Trader {
    @Id
    @Column(name = "idTrader", nullable = false)
    private Integer id;

    @Column(name = "nomTrader", nullable = false, length = 50)
    private String nomTrader;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomTrader() {
        return nomTrader;
    }

    public void setNomTrader(String nomTrader) {
        this.nomTrader = nomTrader;
    }

}