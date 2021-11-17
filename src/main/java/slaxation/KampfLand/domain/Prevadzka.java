package slaxation.KampfLand.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obchod_id")
    private Obchod obchod;

    @OneToMany(fetch = FetchType.LAZY, mappedBy =  "prevadzka")
    private List<Tovar> tovarList;

    public Prevadzka(String adresa, Time otvHodiny, Time zatvHodiny, Obchod obchod) {
        this.adresa = adresa;
        this.otvHodiny = otvHodiny;
        this.zatvHodiny = zatvHodiny;
        this.obchod = obchod;
    }

    public int getPrevid() {
        return previd;
    }

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


}
