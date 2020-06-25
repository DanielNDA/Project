package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursuri")
public class Cursuri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cursId;
    private String numeCurs;
    private String descriere;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "cursuriList")
    private List<Orar> orarList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="cursuri_profesori", catalog = "studenti",
            joinColumns = {
                    @JoinColumn(name="cursId", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name="cnpProfesor", nullable = false, updatable = false)
            })
    private List<Profesori> profesoriList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="cursuri_studenti", catalog = "studenti",
            joinColumns = {
                    @JoinColumn(name="cursId", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name="cnpStudent", nullable = false, updatable = false)
            })
    private List<Studenti> studentiList;

    public void setStudentiList(List<Studenti> studentiList) {
        this.studentiList = studentiList;
    }

    public List<Studenti> getStudentiList() {
        return studentiList;
    }

    public void setProfesoriList(List<Profesori> profesoriList) {
        this.profesoriList = profesoriList;
    }

    public List<Profesori> getProfesoriList() {
        return profesoriList;
    }

    public List<Orar> getOrarList() {
        return orarList;
    }

    public void setOrarList(List<Orar> orarList) {
        this.orarList = orarList;
    }

    public int getCursId() {
        return cursId;
    }

    public void setCursId(int cursId) {
        this.cursId = cursId;
    }

    public String getNumeCurs() {
        return numeCurs;
    }

    public void setNumeCurs(String numeCurs) {
        this.numeCurs = numeCurs;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
