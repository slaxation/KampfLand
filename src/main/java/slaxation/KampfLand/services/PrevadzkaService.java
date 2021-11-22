package slaxation.KampfLand.services;

import slaxation.KampfLand.domain.Prevadzka;
import slaxation.KampfLand.domain.Tovar;

import java.util.Set;

public interface PrevadzkaService {

    Set<Tovar> getTovaryByPrevId(Integer previd);

    Set<Prevadzka> getPrevadzkyByObchodId(Integer id);
}
