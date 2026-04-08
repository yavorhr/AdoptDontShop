package softuni.adoptdontshop.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import softuni.adoptdontshop.Web.exception.GlobalNotFoundException;
import java.security.Principal;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GlobalNotFoundException.class})
    public ModelAndView handleDbExceptions(GlobalNotFoundException e, Principal principal) {

        ModelAndView modelAndView = new ModelAndView("404-global-exception");
        modelAndView.addObject("user", principal.getName());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}

