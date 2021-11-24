package slaxation.KampfLand.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.services.ObchodService;
import slaxation.KampfLand.services.PrevadzkaService;

import java.util.Set;


@RestController
public class ObchodController {

    private final ObchodService obchodService;


    public ObchodController(ObchodService obchodService) {
        this.obchodService = obchodService;

    }


    @GetMapping("/obchody/{obchodId}/prevadzky")
    public Set<PrevadzkaCommand> listPrevadzkyCommandByObchodId(@PathVariable String obchodId, Model model) {

        return obchodService.getPrevadzkyCommandByObchodId(Integer.valueOf(obchodId));

    }
}
