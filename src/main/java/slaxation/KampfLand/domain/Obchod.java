package slaxation.KampfLand.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "obchod")
public class Obchod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int obchod_id;

    @Column(name = "nazov_obchodu")
    private String nazov;

    @OneToMany(mappedBy = "obchod")
    private Set<Prevadzka> prevadzky;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Obchod obchod = (Obchod) o;

        if (obchod_id != obchod.obchod_id) return false;
        if (nazov != null ? !nazov.equals(obchod.nazov) : obchod.nazov != null) return false;
        return prevadzky != null ? prevadzky.equals(obchod.prevadzky) : obchod.prevadzky == null;
    }

    @Override
    public int hashCode() {
        int result = obchod_id;
        result = 31 * result + (nazov != null ? nazov.hashCode() : 0);
        result = 31 * result + (prevadzky != null ? prevadzky.hashCode() : 0);
        return result;
    }
}
