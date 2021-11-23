package slaxation.KampfLand.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import slaxation.KampfLand.commands.PrevadzkaCommand;
import slaxation.KampfLand.exceptions.AlreadyExistsException;
import slaxation.KampfLand.exceptions.NotFoundException;
import slaxation.KampfLand.services.ObchodService;
import slaxation.KampfLand.services.PrevadzkaService;
import slaxation.KampfLand.services.TovarService;

@Controller
public class PrevadzkaController {

    private final PrevadzkaService prevadzkaService;


    public PrevadzkaController(PrevadzkaService prevadzkaService) {

        this.prevadzkaService = prevadzkaService;

    }

    @GetMapping("/prevadzky")
    public String listPrevadzky() {
        prevadzkaService.getPrevadzkyCommand();

        return "prevadzky";
    }


    @GetMapping("/prevadzky/{prevId}")
    public String zobrazPrevadzku(@PathVariable String obchodId, @PathVariable String prevId, Model model) {
        model.addAttribute("prevadzka", prevadzkaService.findCommandById(Integer.valueOf(prevId)));

        return "obchod/" + obchodId + "/prevadzka/" + prevId;
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
