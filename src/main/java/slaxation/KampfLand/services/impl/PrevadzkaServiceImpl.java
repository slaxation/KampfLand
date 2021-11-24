package slaxation.KampfLand.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.converters.PrevadzkaCommandToPrevadzka;
import slaxation.KampfLand.converters.PrevadzkaToPrevadzkaCommand;
import slaxation.KampfLand.converters.TovarConverter;
import slaxation.KampfLand.domain.Prevadzka;
import slaxation.KampfLand.exceptions.AlreadyExistsException;
import slaxation.KampfLand.exceptions.NotFoundException;
import slaxation.KampfLand.repositories.PrevadzkaRepository;
import slaxation.KampfLand.repositories.TovarRepository;
import slaxation.KampfLand.services.PrevadzkaService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PrevadzkaServiceImpl implements PrevadzkaService {

    private final TovarRepository tovarRepository;
    private final PrevadzkaRepository prevadzkaRepository;
    private final PrevadzkaToPrevadzkaCommand prevadzkaConverter;
    private final TovarConverter tovarConverter;

    public PrevadzkaServiceImpl(TovarRepository tovarRepository, PrevadzkaRepository prevadzkaRepository, PrevadzkaToPrevadzkaCommand prevadzkaConverter, TovarConverter tovarConverter) {
        this.tovarRepository = tovarRepository;
        this.prevadzkaRepository = prevadzkaRepository;
        this.prevadzkaConverter = prevadzkaConverter;
        this.tovarConverter = tovarConverter;
    }

    @Override
    public Set<PrevadzkaCommand> getPrevadzkyCommand() {
        Set<PrevadzkaCommand> vysledok = new HashSet<>();
        prevadzkaRepository.findAll().forEach(prevadzka -> vysledok.add(prevadzkaConverter.prevadzkaToPrevadzkaCommand(prevadzka)));

        return vysledok;
    }


    @Override
    public Prevadzka findById(Integer id) {
        Optional<Prevadzka> prevadzkaOptional = prevadzkaRepository.findById(id);

        if (!prevadzkaOptional.isPresent()) {
            throw new NotFoundException("Prevadzka s ID: " + id + "nebola najdena");
        }

        return prevadzkaOptional.get();

    }

    @Override
    public PrevadzkaCommand findCommandById(Integer i) {
        return prevadzkaConverter.prevadzkaToPrevadzkaCommand(findById(i));
    }

    @Override
    public void vymazPrevadzku(Integer i) {
        prevadzkaRepository.deleteById(i);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public PrevadzkaCommand vytvorPrevadzku(PrevadzkaCommand prevadzkaCommand) {

        Optional<Prevadzka> prevadzkaOptional = prevadzkaRepository.findById(prevadzkaCommand.getPrevid());


        if (!prevadzkaOptional.isPresent()) {
            PrevadzkaCommand novaPrevadzka = new PrevadzkaCommand();
            novaPrevadzka.setPrevid(prevadzkaCommand.getPrevid());
            novaPrevadzka.setAdresa(prevadzkaCommand.getAdresa());
            novaPrevadzka.setOtvHodiny(prevadzkaCommand.getOtvHodiny());
            novaPrevadzka.setZatvHodiny(prevadzkaCommand.getZatvHodiny());
            novaPrevadzka.setObchodId(prevadzkaCommand.getObchod());
            novaPrevadzka.setTovary(prevadzkaCommand.getTovary());

            return novaPrevadzka;
        } else {
            throw new AlreadyExistsException("Prevadzka uz existuje.");

        }

    }
}
