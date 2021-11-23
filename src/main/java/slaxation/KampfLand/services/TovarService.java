package slaxation.KampfLand.services;

import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.domain.Tovar;
import slaxation.KampfLand.exceptions.NotEnoughException;

import java.util.Set;

public interface TovarService {

    Set<TovarCommand> getTovaryCommandByPrevId(Integer previd);

    TovarCommand znizMnozstvoTovaru(TovarCommand command, int mnozstvo) throws NotEnoughException;

    TovarCommand saveTovarCommand(TovarCommand command);



}
