package slaxation.KampfLand.converters;

import org.springframework.stereotype.Component;
import slaxation.KampfLand.commands.ObchodCommand;

import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.domain.Prevadzka;

import java.util.HashSet;
import java.util.Set;

@Component
public class ObchodConverter {

    private final PrevadzkaConverter prevadzkaConverter;

    public ObchodConverter(PrevadzkaConverter prevadzkaConverter) {
        this.prevadzkaConverter = prevadzkaConverter;
    }

    public synchronized ObchodCommand obchodToObchodCommand(Obchod obchod) {
        if (obchod == null) {
            return null;
        }

        ObchodCommand obchodCommand = new ObchodCommand();
                obchodCommand.setObchod_id(obchod.getObchod_id());
                obchodCommand.setNazov(obchod.getNazov());
        if (obchod.getPrevadzky() != null && obchod.getPrevadzky().size() > 0){
            obchod.getPrevadzky()
                    .forEach( prevadzka -> obchodCommand.getPrevadzky().add(prevadzkaConverter.prevadzkaToPrevadzkaCommand(prevadzka)));
        }

        return obchodCommand;
    }



    public synchronized Obchod obchodCommandToObchod(ObchodCommand obchodCommand) {
        if (obchodCommand == null) {
            return null;
        }

        Obchod obchod = new Obchod();
        obchod.setObchod_id(obchodCommand.getObchod_id());
        obchod.setNazov(obchodCommand.getNazov());

        if (obchodCommand.getPrevadzky() != null && obchodCommand.getPrevadzky().size() > 0){
            obchodCommand.getPrevadzky()
                    .forEach( prevadzka -> obchod.getPrevadzky().add(prevadzkaConverter.prevadzkaCommandToPrevadzka(prevadzka)));
        }


        return obchod;
    }

}
