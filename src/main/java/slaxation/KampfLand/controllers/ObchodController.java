package slaxation.KampfLand.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import slaxation.KampfLand.services.ObchodService;
import slaxation.KampfLand.services.PrevadzkaService;

public class ObchodController {

    private final ObchodService obchodService;
    private final PrevadzkaService prevadzkaService;

    public ObchodController(ObchodService obchodService, PrevadzkaService prevadzkaService) {
        this.obchodService = obchodService;
        this.prevadzkaService = prevadzkaService;
    }


    @GetMapping("/obchody")
    public String listObchody(@PathVariable String obchodId, Model model) {

        model.addAttribute("Prevadzky", obchodService.getObchodyCommand());

        return "/obchody/list";
    }

    @GetMapping("/obchody/{obchodId}/prevadzky")
    public String listPrevadzkyCommandByObchodId(@PathVariable String obchodId, Model model) {

        model.addAttribute("prevadzky", obchodService.getPrevadzkyCommandByObchodId(Integer.valueOf(obchodId)));

        return "obchod/" + obchodId + "prevadzky/list";
    }
}
