package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sali")
public class Sali {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaId;
    private String numeSala;

    @OneToMany
    @JoinColumn(name = "sala_id")
    private List<Orar> orar;

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public String getNumeSala() {
        return numeSala;
    }

    public void setNumeSala(String numeSala) {
        this.numeSala = numeSala;
    }

    public void setOrar(List<Orar> orar) {
        this.orar = orar;
    }

    public List<Orar> getOrar() {
        return orar;
    }
}
