package slaxation.KampfLand.services;

import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.domain.Tovar;
import slaxation.KampfLand.exceptions.NotEnoughException;

import java.util.Set;

public interface TovarService {


    void znizMnozstvoTovaru(TovarCommand command, int mnozstvo) throws NotEnoughException;

    void zvysMnozstvoTovaru(TovarCommand command, int mnozstvo);




}
