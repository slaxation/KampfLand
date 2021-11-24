package slaxation.KampfLand.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slaxation.KampfLand.commands.ObchodCommand;

import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.domain.Prevadzka;

import java.util.HashSet;
import java.util.Set;


@Component
public class ObchodCommandToObchod {


    @Autowired
    private PrevadzkaCommandToPrevadzka prevadzkaConverter;

    public ObchodCommandToObchod(PrevadzkaCommandToPrevadzka prevadzkaConverter) {

        this.prevadzkaConverter = prevadzkaConverter;
    }


    public synchronized Obchod obchodCommandToObchod(ObchodCommand obchodCommand) {

        Set<Prevadzka> prevadzky = new HashSet<>();

        if (obchodCommand == null) {
            return null;
        }

        Obchod obchod = new Obchod();
        obchod.setObchod_id(obchodCommand.getObchod_id());
        obchod.setNazov(obchodCommand.getNazov());

        if (obchodCommand.getPrevadzky() != null && obchodCommand.getPrevadzky().size() > 0){
            obchodCommand.getPrevadzky()
                    .forEach( prevadzka -> prevadzky.add(prevadzkaConverter.prevadzkaCommandToPrevadzka(prevadzka)));
        }
        obchod.setPrevadzky(prevadzky);

        return obchod;
    }

}
