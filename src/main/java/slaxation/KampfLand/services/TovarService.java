package slaxation.KampfLand.services;

import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.domain.Tovar;

import java.util.Set;

public interface TovarService {

    TovarCommand findByPrevadzkaIdAndTovarName(int prevadzkaId, String tovarName);

    TovarCommand saveTovarCommand(TovarCommand command);




}
