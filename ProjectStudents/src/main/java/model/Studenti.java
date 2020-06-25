package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studenti")
public class Studenti {
    @Id
    private int cnpStudent;
    private String numeStudent;
    private String prenumeStudent;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "studentiList")
    private List<Cursuri> cursuriList;

    public void setCursuriList(List<Cursuri> cursuriList) {
        this.cursuriList = cursuriList;
    }

    public List<Cursuri> getCursuriList() {
        return cursuriList;
    }

    public int getCnpStudent() {
        return cnpStudent;
    }

    public void setCnpStudent(int cnpStudent) {
        this.cnpStudent = cnpStudent;
    }

    public String getNumeStudent() {
        return numeStudent;
    }

    public void setNumeStudent(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public String getPrenumeStudent() {
        return prenumeStudent;
    }

    public void setPrenumeStudent(String prenumeStudent) {
        this.prenumeStudent = prenumeStudent;
    }


}
