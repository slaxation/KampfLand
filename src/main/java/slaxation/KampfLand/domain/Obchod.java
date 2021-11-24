package slaxation.KampfLand.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "obchod")
public class Obchod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int obchod_id;

    @Column(name = "nazov_obchodu")
    private String nazov;

    @Transient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obchod")
    private Set<Prevadzka> prevadzky = new HashSet<>();

    public Obchod() {
    }

    public Obchod(String nazov, Set<Prevadzka> prevadzky) {
        this.nazov = nazov;
        this.prevadzky = prevadzky;
    }

    public int getObchod_id() {
        return obchod_id;
    }

    public void setObchod_id(int obchod_id) {
        this.obchod_id = obchod_id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }


    public Set<Prevadzka> getPrevadzky() {
        return prevadzky;
    }

    public void setPrevadzky(Set<Prevadzka> prevadzky) {
        this.prevadzky = prevadzky;
    }
}


