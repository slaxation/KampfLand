package slaxation.KampfLand.domain;

import javax.persistence.*;

@Entity
@Table(name = "tovar")
public class Tovar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tovar_id", nullable = false)
    private int id;

    @Column(name = "nazov")
    private String nazov;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "prev_id", nullable = false)
    private Prevadzka prevadzka;

    @Column(name = "mnozstvo")
    private int mnozstvo;

    public Tovar(String nazov, Category category, Prevadzka prevadzka, int mnozstvo) {
        this.nazov = nazov;
        this.category = category;
        this.prevadzka = prevadzka;
        this.mnozstvo = mnozstvo;
    }

    public int getId() {
        return id;
    }



    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tovar tovar = (Tovar) o;

        if (id != tovar.id) return false;
        if (mnozstvo != tovar.mnozstvo) return false;
        if (nazov != null ? !nazov.equals(tovar.nazov) : tovar.nazov != null) return false;
        if (category != tovar.category) return false;
        return prevadzka != null ? prevadzka.equals(tovar.prevadzka) : tovar.prevadzka == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazov != null ? nazov.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (prevadzka != null ? prevadzka.hashCode() : 0);
        result = 31 * result + mnozstvo;
        return result;
    }
}
