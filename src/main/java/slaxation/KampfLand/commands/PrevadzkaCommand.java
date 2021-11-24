package slaxation.KampfLand.commands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import slaxation.KampfLand.domain.Obchod;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class PrevadzkaCommand {

    private int previd;
    private String adresa;
    private Time otvHodiny;
    private Time zatvHodiny;
    private Integer obchodId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<TovarCommand> tovary = new HashSet<>();


    public PrevadzkaCommand() {

    }

    public PrevadzkaCommand(int previd, String adresa, Time otvHodiny, Time zatvHodiny, Integer obchodId, Set<TovarCommand> tovary) {
        this.previd = previd;
        this.adresa = adresa;
        this.otvHodiny = otvHodiny;
        this.zatvHodiny = zatvHodiny;
        this.obchodId = obchodId;
        this.tovary = tovary;
    }

    public int getPrevid() {
        return previd;
    }

    public void setPrevid(int previd) {
        this.previd = previd;
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


    public Integer getObchod() {
        return obchodId;
    }

    public void setObchodId(Integer obchod) {
        this.obchodId = obchod;
    }

    public Set<TovarCommand> getTovary() {
        return tovary;
    }

    public void setTovary(Set<TovarCommand> tovary) {
        this.tovary = tovary;
    }



}
