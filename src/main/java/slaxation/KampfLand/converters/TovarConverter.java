package slaxation.KampfLand.converters;

import org.springframework.stereotype.Component;
import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.domain.Tovar;


@Component
public class TovarConverter {


    public TovarCommand TovarToTovarCommand(Tovar tovar) {

        if (tovar == null) {
            return null;
        }

        TovarCommand tovarCommand = new TovarCommand();
        tovarCommand.setId(tovar.getId());
        tovarCommand.setNazov(tovar.getNazov());
        tovarCommand.setCategory(tovar.getCategory());
        tovarCommand.setPrevId(tovar.getPrevadzka().getPrevid());
        tovarCommand.setMnozstvo(tovar.getMnozstvo());

        return tovarCommand;

    }


    public Tovar TovarCommandToTovar(TovarCommand tovarCommand) {


        if (tovarCommand == null) {
            return null;
        }

        Tovar tovar = new Tovar();
        tovar.setNazov(tovarCommand.getNazov());
        tovar.setCategory(tovarCommand.getCategory());
        tovar.setMnozstvo(tovarCommand.getMnozstvo());

        return tovar;

    }

}