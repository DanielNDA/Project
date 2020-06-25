package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesori")
public class Profesori {
    @Id
    private int cnpProfesor;
    private String numeProfesor;
    private String prenumeProfesor;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "profesoriList")
    private List<Cursuri> cursuriList;

    public int getCnpProfesor() {
        return cnpProfesor;
    }

    public void setCnpProfesor(int cnpProfesor) {
        this.cnpProfesor = cnpProfesor;
    }

    public String getNumeProfesor() {
        return numeProfesor;
    }

    public void setNumeProfesor(String numeProfesor) {
        this.numeProfesor = numeProfesor;
    }

    public String getPrenumeProfesor() {
        return prenumeProfesor;
    }

    public void setPrenumeProfesor(String prenumeProfesor) {
        this.prenumeProfesor = prenumeProfesor;
    }
}
