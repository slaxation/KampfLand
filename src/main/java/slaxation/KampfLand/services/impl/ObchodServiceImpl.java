package slaxation.KampfLand.services.impl;

import org.springframework.stereotype.Service;
import slaxation.KampfLand.domain.Prevadzka;
import slaxation.KampfLand.repositories.PrevadzkaRepository;
import slaxation.KampfLand.services.ObchodService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ObchodServiceImpl implements ObchodService {

    private final PrevadzkaRepository prevadzkaRepository;

    public ObchodServiceImpl(PrevadzkaRepository prevadzkaRepository) {
        this.prevadzkaRepository = prevadzkaRepository;
    }

    @Override
    public Set<Prevadzka> getPrevadzkyByObchodId(Integer obchodId) {

        Set<Prevadzka> prevadzky = new HashSet<>();
        prevadzkaRepository.findAll().iterator().forEachRemaining(prevadzky::add);

        Set<Prevadzka> prevadzkyObchodu = new HashSet<>();
        for (Prevadzka prevadzka : prevadzky) {
            if (obchodId.equals(prevadzka.getObchod().getObchod_id())) {
                prevadzkyObchodu.add(prevadzka);
            }
        }
        return prevadzkyObchodu;

    }
}
