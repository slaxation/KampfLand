package slaxation.KampfLand.commands;

import slaxation.KampfLand.domain.Category;
import slaxation.KampfLand.domain.Prevadzka;

public class TovarCommand {


    private Long id;
    private String nazov;
    private Category category;
    private Prevadzka prevadzkaId;
    private int mnozstvo;

    public TovarCommand(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Prevadzka getPrevadzkaId() {
        return prevadzkaId;
    }

    public void setPrevadzkaId(Prevadzka prevadzkaId) {
        this.prevadzkaId = prevadzkaId;
    }

    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }
}
