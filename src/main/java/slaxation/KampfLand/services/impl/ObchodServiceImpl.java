package slaxation.KampfLand.services.impl;

import org.springframework.stereotype.Service;
import slaxation.KampfLand.commands.ObchodCommand;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.converters.ObchodToObchodCommand;
import slaxation.KampfLand.converters.PrevadzkaToPrevadzkaCommand;
import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.domain.Prevadzka;
import slaxation.KampfLand.repositories.ObchodRepository;
import slaxation.KampfLand.repositories.PrevadzkaRepository;
import slaxation.KampfLand.services.ObchodService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ObchodServiceImpl implements ObchodService {

    private final ObchodRepository obchodRepository;
    private final PrevadzkaRepository prevadzkaRepository;
    private final PrevadzkaToPrevadzkaCommand prevadzkaConverter;
    private final ObchodToObchodCommand obchodConverter;

    public ObchodServiceImpl(ObchodRepository obchodRepository, PrevadzkaRepository prevadzkaRepository, PrevadzkaToPrevadzkaCommand prevadzkaConverter, ObchodToObchodCommand obchodConverter) {
        this.obchodRepository = obchodRepository;
        this.prevadzkaRepository = prevadzkaRepository;
        this.prevadzkaConverter = prevadzkaConverter;
        this.obchodConverter = obchodConverter;
    }


    @Override
    public Set<ObchodCommand> getObchody() {
        Set<Obchod> obchody = new HashSet<>();
        obchodRepository.findAll().iterator().forEachRemaining(obchody::add);

        Set<ObchodCommand> prevadzkyObchodu = new HashSet<>();
        for (Obchod obchod : obchody) {
            prevadzkyObchodu.add(obchodConverter.obchodToObchodCommand(obchod));
            }

        return prevadzkyObchodu;
    }

    @Override
    public Set<PrevadzkaCommand> getPrevadzkyCommandByObchodId(Integer obchodId) {

        Set<Prevadzka> prevadzky = new HashSet<>();
        prevadzkaRepository.findAll().iterator().forEachRemaining(prevadzky::add);

        Set<PrevadzkaCommand> prevadzkyObchodu = new HashSet<>();
        for (Prevadzka prevadzka : prevadzky) {
            if (obchodId.equals(prevadzka.getObchod().getObchod_id())) {
                prevadzkyObchodu.add(prevadzkaConverter.prevadzkaToPrevadzkaCommand(prevadzka));
            }
        }
        return prevadzkyObchodu;

    }


}
