package slaxation.KampfLand.services.impl;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import slaxation.KampfLand.exceptions.NotEnoughException;
import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.converters.TovarConverter;
import slaxation.KampfLand.domain.Tovar;
import slaxation.KampfLand.repositories.TovarRepository;
import slaxation.KampfLand.services.TovarService;

import java.util.HashSet;
import java.util.Set;

@Service
public class TovarServiceImpl implements TovarService {

    private final TovarRepository tovarRepository;
    private final TovarConverter tovarConverter;

    public TovarServiceImpl(TovarRepository tovarRepository, TovarConverter tovarConverter) {
        this.tovarRepository = tovarRepository;
        this.tovarConverter = tovarConverter;
    }


    @Transactional
    public void znizMnozstvoTovaru(TovarCommand command, int mnozstvo) {

        Tovar tovar = tovarConverter.TovarCommandToTovar(command);

        try {
            if (tovarRepository.exists(Example.of(tovar))) {
                tovarRepository.findById(command.getId())
                        .get()
                        .znizMnozstvo(mnozstvo);
            } else {
                throw new NotEnoughException("Tovar neexistuje");
            }
        } catch (NotEnoughException e) {
            throw new NotEnoughException("Nedostatok mnozstva na sklade");
        }

    }

    @Transactional
    public void zvysMnozstvoTovaru(TovarCommand command, int mnozstvo) {

        Tovar tovar = tovarConverter.TovarCommandToTovar(command);

        if (tovarRepository.exists(Example.of(tovar))) {
            tovarRepository.findById(command.getId())
                    .get()
                    .zvysMnozstvo(mnozstvo);
        } else {

            tovar.setMnozstvo(mnozstvo);
            tovarRepository.save(tovar);
        }
    }



}
