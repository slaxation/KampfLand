package slaxation.KampfLand.commands;

import slaxation.KampfLand.domain.Prevadzka;

import java.util.HashSet;
import java.util.Set;

public class ObchodCommand {

    private int id;
    private String nazov;
    private Set<Prevadzka> prevadzky = new HashSet<>();

    public ObchodCommand() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


