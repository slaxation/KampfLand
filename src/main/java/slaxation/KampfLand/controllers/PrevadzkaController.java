package slaxation.KampfLand.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.services.PrevadzkaService;

import java.util.Set;


@RestController
public class PrevadzkaController {

    private final PrevadzkaService prevadzkaService;


    public PrevadzkaController(PrevadzkaService prevadzkaService) {

        this.prevadzkaService = prevadzkaService;

    }

    @GetMapping("/prevadzky")
    public Set<PrevadzkaCommand> listPrevadzky() {
        return prevadzkaService.getPrevadzkyCommand();

    }


    @GetMapping("/prevadzky/{prevId}")
    public PrevadzkaCommand zobrazPrevadzku(@PathVariable String prevId) {

        return prevadzkaService.findCommandById(Integer.valueOf(prevId));
    }

    @DeleteMapping("/prevadzky/{prevId}/delete")
    public String vymazPrevadzku(@PathVariable String prevId) {
        prevadzkaService.vymazPrevadzku(Integer.valueOf(prevId));

        return "redirect:/prevadzky";
    }

    @PutMapping("/prevadzky/new")
    public String vytvorPrevadzku(PrevadzkaCommand prevadzkaCommand) {
        prevadzkaService.vytvorPrevadzku(prevadzkaCommand);

        return "redirect:/prevadzky";
    }


}
