package slaxation.KampfLand.converters;

import org.springframework.stereotype.Component;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.domain.Prevadzka;
import slaxation.KampfLand.domain.Tovar;

import java.util.HashSet;
import java.util.Set;

@Component
public class PrevadzkaConverter {

    private final TovarConverter tovarConverter;

    public PrevadzkaConverter(TovarConverter tovarConverter) {
        this.tovarConverter = tovarConverter;
    }

    public synchronized PrevadzkaCommand prevadzkaToPrevadzkaCommand(Prevadzka prevadzka) {
        if (prevadzka == null) {
            return null;
        }

        PrevadzkaCommand prevadzkaCommand = new PrevadzkaCommand();
                prevadzkaCommand.setPrevid(prevadzka.getPrevid());
                prevadzkaCommand.setAdresa(prevadzka.getAdresa());
                prevadzkaCommand.setOtvHodiny(prevadzka.getOtvHodiny());
                prevadzkaCommand.setZatvHodiny(prevadzka.getZatvHodiny());
                prevadzkaCommand.setObchod(prevadzka.getObchod());
        if (prevadzka.getTovary() != null && prevadzka.getTovary().size() > 0){
            prevadzka.getTovary()
                    .forEach( tovar -> prevadzkaCommand.getTovary().add(tovarConverter.TovarToTovarCommand(tovar)));
        }

        return prevadzkaCommand;
    }

    public synchronized Prevadzka prevadzkaCommandToPrevadzka(PrevadzkaCommand prevadzkaCommand) {

        if (prevadzkaCommand == null) {
            return null;
        }

        Prevadzka prevadzka = new Prevadzka();
                prevadzka.setPrevid(prevadzkaCommand.getPrevid());
                prevadzka.setAdresa(prevadzkaCommand.getAdresa());
                prevadzka.setOtvHodiny(prevadzkaCommand.getOtvHodiny());
                prevadzka.setZatvHodiny(prevadzkaCommand.getZatvHodiny());
                prevadzka.setObchod(prevadzkaCommand.getObchod());
        if (prevadzkaCommand.getTovary() != null && prevadzkaCommand.getTovary().size() > 0){
            prevadzkaCommand.getTovary()
                    .forEach( tovar -> prevadzka.getTovary().add(tovarConverter.TovarCommandToTovar(tovar)));
        }
        return prevadzka;
    }

}
