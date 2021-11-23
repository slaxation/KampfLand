package slaxation.KampfLand.services;

import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.domain.Prevadzka;

import java.util.Set;

public interface PrevadzkaService {

    Set<PrevadzkaCommand> getPrevadzkyCommand();



    Prevadzka findById(Integer id);

    PrevadzkaCommand findCommandById(Integer i);

    void vymazPrevadzku(Integer i);

    PrevadzkaCommand vytvorPrevadzku(PrevadzkaCommand prevadzkaCommand);



}
