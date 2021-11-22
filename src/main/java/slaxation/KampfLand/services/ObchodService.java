package slaxation.KampfLand.services;

import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.domain.Prevadzka;

import java.util.Set;

public interface ObchodService {

    Set<Prevadzka> getPrevadzkyByObchodId(Integer obchodId);
}
