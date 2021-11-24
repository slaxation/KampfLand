package slaxation.KampfLand.converters;

import org.springframework.stereotype.Component;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.domain.Prevadzka;

@Component
public class PrevadzkaToPrevadzkaCommand {


    private final TovarConverter tovarConverter;

    public PrevadzkaToPrevadzkaCommand(TovarConverter tovarConverter) {

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
        prevadzkaCommand.setObchodId(prevadzka.getObchod().getObchod_id());
        if (prevadzka.getTovary() != null && prevadzka.getTovary().size() > 0) {
            prevadzka.getTovary()
                    .forEach(tovar -> prevadzkaCommand.getTovary().add(tovarConverter.TovarToTovarCommand(tovar)));
        }

        return prevadzkaCommand;
    }
}
