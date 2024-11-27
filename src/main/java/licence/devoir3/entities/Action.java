package licence.devoir3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @Column(name = "idAction", nullable = false)
    private Integer id;

    @Column(name = "nomAction", nullable = false, length = 50)
    private String nomAction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

}