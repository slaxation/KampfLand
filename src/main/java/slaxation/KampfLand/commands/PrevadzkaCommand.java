package slaxation.KampfLand.commands;

import slaxation.KampfLand.domain.Obchod;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class PrevadzkaCommand {

    private int previd;
    private String adresa;
    private Time otvHodiny;
    private Time zatvHodiny;
    private Obchod obchod;
    private Set<TovarCommand> tovary = new HashSet<>();


    public PrevadzkaCommand() {

    }

    public PrevadzkaCommand(int previd, String adresa, Time otvHodiny, Time zatvHodiny, Obchod obchod, Set<TovarCommand> tovary) {
        this.previd = previd;
        this.adresa = adresa;
        this.otvHodiny = otvHodiny;
        this.zatvHodiny = zatvHodiny;
        this.obchod = obchod;
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


    public Obchod getObchod() {
        return obchod;
    }

    public void setObchod(Obchod obchod) {
        this.obchod = obchod;
    }

    public Set<TovarCommand> getTovary() {
        return tovary;
    }

    public void setTovary(Set<TovarCommand> tovary) {
        this.tovary = tovary;
    }

}
