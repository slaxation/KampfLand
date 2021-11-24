package slaxation.KampfLand.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;

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

    @Min(0)
    @Column(name = "mnozstvo")
    private int mnozstvo;


    public Tovar(){

    }

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

    public void znizMnozstvo(int mnozstvo) {
        this.mnozstvo = this.mnozstvo - mnozstvo;
    }

    public void zvysMnozstvo(int mnozstvo) {
        this.mnozstvo = this.mnozstvo + mnozstvo;
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

    public Prevadzka getPrevadzka() {
        return prevadzka;
    }

    public void setPrevadzka(Prevadzka prevadzka) {
        this.prevadzka = prevadzka;
    }


}
