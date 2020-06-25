package model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orar")
public class Orar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orarId;
    private Date data;
    private String startHour;
    private String endHour;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sali sali;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name ="orar_cursuri",catalog = "studenti",joinColumns = {
            @JoinColumn(name = "orarID",nullable = false,updatable = false)},
            inverseJoinColumns = {
            @JoinColumn(name = "cursID",nullable = false,updatable = false)
            })
    private List<Cursuri> cursuriList;

    public void setCursuriList(List<Cursuri> cursuriList) {
        this.cursuriList = cursuriList;
    }

    public List<Cursuri> getCursuriList() {
        return cursuriList;
    }

    public int getOrarId() {
        return orarId;
    }

    public void setOrarId(int orarId) {
        this.orarId = orarId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public void setSali(Sali sali) {
        this.sali = sali;
    }

    public Sali getSali() {
        return sali;
    }
}
