package slaxation.KampfLand.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import slaxation.KampfLand.services.ObchodService;

@Controller
public class IndexController {

    private final ObchodService obchodService;

    public IndexController(ObchodService obchodService) {
        this.obchodService = obchodService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("obchody", obchodService.getObchodyCommand());

        return "index";
    }
}
