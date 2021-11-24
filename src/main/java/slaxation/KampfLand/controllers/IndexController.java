package slaxation.KampfLand.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slaxation.KampfLand.commands.ObchodCommand;
import slaxation.KampfLand.domain.Obchod;
import slaxation.KampfLand.services.ObchodService;

import java.util.Set;

@RestController
public class IndexController {

    private final ObchodService obchodService;

    public IndexController(ObchodService obchodService) {
        this.obchodService = obchodService;
    }

    @RequestMapping({"", "/", "/index"})
    public Set<ObchodCommand> getIndexPage() {

        return obchodService.getObchody();


    }
}
