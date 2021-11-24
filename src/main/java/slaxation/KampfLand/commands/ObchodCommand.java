package slaxation.KampfLand.commands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

public class ObchodCommand {

    private int obchod_id;
    private String nazov;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<PrevadzkaCommand> prevadzky = new HashSet<>();

    public ObchodCommand() {
    }

    public ObchodCommand(int id, String nazov, Set<PrevadzkaCommand> prevadzky) {
        this.obchod_id = id;
        this.nazov = nazov;
        this.prevadzky = prevadzky;
    }

    public int getObchod_id() {
        return obchod_id;
    }

    public void setObchod_id(int id) {
        this.obchod_id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }


    public Set<PrevadzkaCommand> getPrevadzky() {
        return prevadzky;
    }


    public void setPrevadzky(Set<PrevadzkaCommand> prevadzky) {
        this.prevadzky = prevadzky;
    }


}


