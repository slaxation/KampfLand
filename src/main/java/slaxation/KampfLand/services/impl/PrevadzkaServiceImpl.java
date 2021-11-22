package slaxation.KampfLand.services.impl;

import org.springframework.stereotype.Service;
import slaxation.KampfLand.converters.PrevadzkaConverter;
import slaxation.KampfLand.converters.TovarConverter;
import slaxation.KampfLand.domain.Prevadzka;
import slaxation.KampfLand.domain.Tovar;
import slaxation.KampfLand.repositories.PrevadzkaRepository;
import slaxation.KampfLand.repositories.TovarRepository;
import slaxation.KampfLand.services.PrevadzkaService;

import java.util.HashSet;
import java.util.Set;

@Service
public class PrevadzkaServiceImpl implements PrevadzkaService {

    private final TovarRepository tovarRepository;
    private final PrevadzkaRepository prevadzkaRepository;
    private final PrevadzkaConverter prevadzkaConverter;
    private final TovarConverter tovarConverter;

    public PrevadzkaServiceImpl(TovarRepository tovarRepository, PrevadzkaRepository prevadzkaRepository, PrevadzkaConverter prevadzkaConverter, TovarConverter tovarConverter) {
        this.tovarRepository = tovarRepository;
        this.prevadzkaRepository = prevadzkaRepository;
        this.prevadzkaConverter = prevadzkaConverter;
        this.tovarConverter = tovarConverter;
    }

    @Override
    public Set<Tovar> getTovaryByPrevId(Integer prevId) {
        Set<Tovar> tovary = new HashSet<>();
        tovarRepository.findAll().iterator().forEachRemaining(tovary::add);

        Set<Tovar> tovaryPrevadzky = new HashSet<>();
        for (Tovar tovar : tovary) {
            if(prevId.equals(tovar.getPrevadzka().getPrevid())){
                tovaryPrevadzky.add(tovar);
            }
        }
        return tovaryPrevadzky;
    }


}
