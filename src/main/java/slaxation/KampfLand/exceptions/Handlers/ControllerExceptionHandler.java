package slaxation.KampfLand.exceptions.Handlers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import slaxation.KampfLand.exceptions.AlreadyExistsException;
import slaxation.KampfLand.exceptions.NotEnoughException;
import slaxation.KampfLand.exceptions.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistsException.class)
    public ModelAndView handleAlreadyExists(Exception exception) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("Prevadzka uz existuje.");
        modelAndView.addObject("Exception", exception);

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("Tovar nie je na sklade.");
        modelAndView.addObject("Exception", exception);

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotEnoughException.class)
    public ModelAndView handleNotEnough(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("Nedostatocne mnozstvo na sklade.");
        modelAndView.addObject("Exception", exception);

        return modelAndView;
    }
}
