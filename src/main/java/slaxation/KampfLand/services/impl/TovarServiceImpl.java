package slaxation.KampfLand.services.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import slaxation.KampfLand.exceptions.NotEnoughException;
import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.converters.TovarConverter;
import slaxation.KampfLand.domain.Tovar;
import slaxation.KampfLand.exceptions.NotFoundException;
import slaxation.KampfLand.repositories.TovarRepository;
import slaxation.KampfLand.services.TovarService;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class TovarServiceImpl implements TovarService {

    private final TovarRepository tovarRepository;
    private final TovarConverter tovarConverter;

    public TovarServiceImpl(TovarRepository tovarRepository, TovarConverter tovarConverter) {
        this.tovarRepository = tovarRepository;
        this.tovarConverter = tovarConverter;
    }

    @Override
    public Set<TovarCommand> getTovaryCommandByPrevId(Integer prevId) {
        Set<Tovar> tovary = new HashSet<>();
        tovarRepository.findAll().iterator().forEachRemaining(tovary::add);

        Set<TovarCommand> tovaryPrevadzky = new HashSet<>();
        for (Tovar tovar : tovary) {
            if(prevId.equals(tovar.getPrevadzka().getPrevid())){
                tovaryPrevadzky.add(tovarConverter.TovarToTovarCommand(tovar));
            }
        }

        return tovaryPrevadzky;
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public TovarCommand znizMnozstvoTovaru(TovarCommand command, int mnozstvo) {

        Optional<Tovar> tovarOptional = tovarRepository.findById(command.getId());



        if (!tovarOptional.isPresent()) {
            throw new NotFoundException("Tovar nie je na sklade");
        }

        Tovar tovar = tovarOptional.get();

            try {
                tovarRepository.getById(tovar.getId())
                        .znizMnozstvo(mnozstvo);

            } catch (NotEnoughException e) {
                throw new NotEnoughException("Nedostatok mnozstva na sklade");
            }
        return tovarConverter.TovarToTovarCommand(tovar);
        }




    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public TovarCommand saveTovarCommand(TovarCommand command) {

        Optional<Tovar> tovarOptional = tovarRepository.findById(command.getId());


        if (!tovarOptional.isPresent()) {

            TovarCommand novyTovar = new TovarCommand();
            novyTovar.setId(command.getId());
            novyTovar.setNazov(command.getNazov());
            novyTovar.setCategory(command.getCategory());
            novyTovar.setPrevadzka(command.getPrevadzka());
            novyTovar.setMnozstvo(command.getMnozstvo());
            return novyTovar;

        } else {
            Tovar tovar = tovarOptional.get();
            tovarRepository.getById(tovar.getId())
                    .zvysMnozstvo(tovar.getMnozstvo());

            return tovarConverter.TovarToTovarCommand(tovar);
        }
    }


}
