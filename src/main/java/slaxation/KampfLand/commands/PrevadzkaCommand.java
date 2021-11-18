package slaxation.KampfLand.commands;

import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.domain.Tovar;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrevadzkaCommand {

    private int previd;
    private String adresa;
    private Time otvHodiny;
    private Time zatvHodiny;
    private int obchodId;
    private Set<TovarCommand> tovary = new HashSet<>();


    public PrevadzkaCommand() {

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


    public int getObchodId() {
        return obchodId;
    }

    public void setObchodId(int obchodId) {
        this.obchodId = obchodId;
    }

    public Set<TovarCommand> getTovary() {
        return tovary;
    }

    public void setTovary(Set<TovarCommand> tovary) {
        this.tovary = tovary;
    }

}
