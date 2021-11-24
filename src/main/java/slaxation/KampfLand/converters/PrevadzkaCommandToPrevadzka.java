package slaxation.KampfLand.converters;

import org.springframework.stereotype.Component;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.domain.Prevadzka;
import slaxation.KampfLand.domain.Tovar;

import java.util.HashSet;
import java.util.Set;

@Component
public class PrevadzkaCommandToPrevadzka {

    private final TovarConverter tovarConverter;


    public PrevadzkaCommandToPrevadzka(TovarConverter tovarConverter) {
        this.tovarConverter = tovarConverter;

    }


    public synchronized Prevadzka prevadzkaCommandToPrevadzka(PrevadzkaCommand prevadzkaCommand) {

        Set<Tovar> tovary = new HashSet<>();

        if (prevadzkaCommand == null) {
            return null;
        }

        Prevadzka prevadzka = new Prevadzka();
        prevadzka.setPrevid(prevadzkaCommand.getPrevid());
        prevadzka.setAdresa(prevadzkaCommand.getAdresa());
        prevadzka.setOtvHodiny(prevadzkaCommand.getOtvHodiny());
        prevadzka.setZatvHodiny(prevadzkaCommand.getZatvHodiny());

        if (prevadzkaCommand.getTovary() != null && prevadzkaCommand.getTovary().size() > 0) {
            prevadzkaCommand.getTovary()
                    .forEach(tovar -> tovary.add(tovarConverter.TovarCommandToTovar(tovar)));
        }

        prevadzka.setTovary(tovary);

        return prevadzka;
    }

}
