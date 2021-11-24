package slaxation.KampfLand.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prevadzka")
public class Prevadzka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prev_id", nullable = false)
    private int previd;

    @Column(name = "adresa", columnDefinition = "varchar(255)", nullable = false)
    private String adresa;

    @Column(name = "otv_hodiny", columnDefinition = "TIME default '00:00:00'")
    private Time otvHodiny;

    @Column(name = "zatv_hodiny", columnDefinition = "TIME default '00:00:00'")
    private Time zatvHodiny;


    @ManyToOne
    @JoinColumn(name = "obchod_id", nullable = false)
    private Obchod obchod;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prevadzka")
    private Set<Tovar> tovary = new HashSet<>();


    public Prevadzka(){

    }

    public Prevadzka(String adresa, Time otvHodiny, Time zatvHodiny, Obchod obchod, Set<Tovar> tovary) {
        this.adresa = adresa;
        this.otvHodiny = otvHodiny;
        this.zatvHodiny = zatvHodiny;
        this.obchod = obchod;
        this.tovary = tovary;
    }



    public int getPrevid() {
        return previd;
    }

    public void setPrevid(int id) { this.previd = id; }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Time getOtvHodiny() {
        return otvHodiny;
    }

    public void setOtvHodiny(Time otvHodiny) {
        this.otvHodiny = otvHodiny;
    }

    public Time getZatvHodiny() {
        return zatvHodiny;
    }

    public void setZatvHodiny(Time zatvHodiny) {
        this.zatvHodiny = zatvHodiny;
    }

    public Obchod getObchod() {return obchod;}

    public void setObchod(Obchod obchod) {this.obchod = obchod;}

    public Set<Tovar> getTovary() {
        return tovary;
    }

    public void setTovary(Set<Tovar> tovary) {
        this.tovary = tovary;
    }
}
