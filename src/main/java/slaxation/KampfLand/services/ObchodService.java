package slaxation.KampfLand.services;

import slaxation.KampfLand.commands.ObchodCommand;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.domain.Prevadzka;

import java.util.Set;

public interface ObchodService {

    Set<ObchodCommand> getObchody();

    Set<PrevadzkaCommand> getPrevadzkyCommandByObchodId(Integer obchodId);
}
