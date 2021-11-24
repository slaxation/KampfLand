package slaxation.KampfLand.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import slaxation.KampfLand.commands.TovarCommand;
import slaxation.KampfLand.exceptions.NotEnoughException;
import slaxation.KampfLand.exceptions.NotFoundException;
import slaxation.KampfLand.services.TovarService;

import java.util.Set;


@RestController
public class TovarController {

    private final TovarService tovarService;

    public TovarController(TovarService tovarService) {
        this.tovarService = tovarService;
    }

    @GetMapping("/prevadzka/{prevId}/tovary")
    public Set<TovarCommand> listTovaryByPrevId(@PathVariable String prevId, Model model){

       return tovarService.getTovaryCommandByPrevId(Integer.valueOf(prevId));

    }

    @PostMapping("/prevadzka/tovar/update")
    public String saveOrIncreaseAmount(@ModelAttribute TovarCommand command) {
        TovarCommand savedCommand = tovarService.saveTovarCommand(command);

        return "redirect:/prevadzka/" + savedCommand.getPrevId() + "/tovary";
    }

    @PostMapping("/prevadzka/tovar/znizenie")
    public String decreaseAmount(@ModelAttribute TovarCommand command) {
        TovarCommand savedCommand = tovarService.znizMnozstvoTovaru(command, command.getMnozstvo());

        return "redirect:/prevadzka/" + savedCommand.getPrevId() + "/tovary";

    }


}
