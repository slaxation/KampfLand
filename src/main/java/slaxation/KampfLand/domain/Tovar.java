package slaxation.KampfLand.domain;

import javax.persistence.*;

@Entity
@Table(name = "tovar")
public class Tovar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tovar_id", nullable = false)
    private Long id;

    @Column(name = "nazov")
    private String nazov;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "prevadzka_id")
    private Prevadzka prevadzka;

    public Tovar(String nazov, Category category, Prevadzka prevadzka) {
        this.nazov = nazov;
        this.category = category;
        this.prevadzka = prevadzka;
    }

    public Long getId() {
        return id;
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
