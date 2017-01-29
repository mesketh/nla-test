package au.gov.nla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by mark on 29/1/17.
 */
@Controller
public class MainViewController extends WebMvcConfigurerAdapter implements ErrorController, HandlerExceptionResolver, Ordered {

    @Autowired
    LenderRepository lenderRepository;


    @RequestMapping(value = "/allLenders", method = RequestMethod.GET)
    public String getLenders(Model model) {

        model.addAttribute("lenders", lenderRepository.findAll());

        return "lender-view";
    }

    @RequestMapping(value = "/error")
    public String handleError(Model model, HttpServletRequest request) {

        Integer errorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        model.addAttribute("errorCode", errorCode);

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        // general error handler that will display error page - TODO: remove error message before going live
        e.printStackTrace();

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName("error");
        return mav;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}


