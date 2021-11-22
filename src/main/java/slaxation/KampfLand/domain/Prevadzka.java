package slaxation.KampfLand.domain;

import javax.persistence.*;
import java.sql.Time;
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

    @OneToMany(mappedBy = "prevadzka")
    private Set<Tovar> tovary;


    public Prevadzka(){

    }

    public Prevadzka(String adresa, Time otvHodiny, Time zatvHodiny, Obchod obchod, Set<Tovar> tovary) {
        this.adresa = adresa;
        this.otvHodiny = otvHodiny;
        this.zatvHodiny = zatvHodiny;
        this.obchod = obchod;
        this.tovary = tovary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prevadzka prevadzka = (Prevadzka) o;

        if (previd != prevadzka.previd) return false;
        if (adresa != null ? !adresa.equals(prevadzka.adresa) : prevadzka.adresa != null) return false;
        if (otvHodiny != null ? !otvHodiny.equals(prevadzka.otvHodiny) : prevadzka.otvHodiny != null) return false;
        if (zatvHodiny != null ? !zatvHodiny.equals(prevadzka.zatvHodiny) : prevadzka.zatvHodiny != null) return false;
        if (obchod != null ? !obchod.equals(prevadzka.obchod) : prevadzka.obchod != null) return false;
        return tovary != null ? tovary.equals(prevadzka.tovary) : prevadzka.tovary == null;
    }

    @Override
    public int hashCode() {
        int result = previd;
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (otvHodiny != null ? otvHodiny.hashCode() : 0);
        result = 31 * result + (zatvHodiny != null ? zatvHodiny.hashCode() : 0);
        result = 31 * result + (obchod != null ? obchod.hashCode() : 0);
        result = 31 * result + (tovary != null ? tovary.hashCode() : 0);
        return result;
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
