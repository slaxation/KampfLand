package slaxation.KampfLand.commands;

import slaxation.KampfLand.domain.Category;
import slaxation.KampfLand.domain.Prevadzka;

public class TovarCommand {


    private int id;
    private String nazov;
    private Category category;
    private Prevadzka prevadzka;
    private int mnozstvo;

    public TovarCommand(){
    }

    public TovarCommand(int id, String nazov, Category category, Prevadzka prevadzka, int mnozstvo) {
        this.id = id;
        this.nazov = nazov;
        this.category = category;
        this.prevadzka = prevadzka;
        this.mnozstvo = mnozstvo;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Prevadzka getPrevadzka() {
        return prevadzka;
    }

    public void setPrevadzka(Prevadzka prevadzka) {
        this.prevadzka = prevadzka;
    }

    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }
}
