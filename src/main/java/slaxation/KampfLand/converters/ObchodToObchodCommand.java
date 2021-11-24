package slaxation.KampfLand.converters;

import org.springframework.stereotype.Component;
import slaxation.KampfLand.commands.ObchodCommand;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.domain.Obchod;

import java.util.HashSet;
import java.util.Set;

@Component
public class ObchodToObchodCommand {

    private final PrevadzkaToPrevadzkaCommand prevadzkaConverter;

    public ObchodToObchodCommand(PrevadzkaToPrevadzkaCommand prevadzkaConverter) {
        this.prevadzkaConverter = prevadzkaConverter;
    }

    public synchronized ObchodCommand obchodToObchodCommand(Obchod obchod) {

        Set<PrevadzkaCommand> prevadzky = new HashSet<>();


        if (obchod == null) {
            return null;
        }

        ObchodCommand obchodCommand = new ObchodCommand();
        obchodCommand.setObchod_id(obchod.getObchod_id());
        obchodCommand.setNazov(obchod.getNazov());
        if (obchod.getPrevadzky() != null && obchod.getPrevadzky().size() > 0) {

            obchod.getPrevadzky()
                    .forEach(prevadzka -> prevadzky.add(prevadzkaConverter.prevadzkaToPrevadzkaCommand(prevadzka)));

        }
        obchodCommand.setPrevadzky(prevadzky);

        return obchodCommand;
    }

}
