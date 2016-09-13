package ua.nure.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.springMVC.model.UserQuery;

@Controller
public class MainController {

    /* First method when we start the server */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("queryJSP", new UserQuery());
        mav.setViewName("index");
        return mav;
    }

    /* Dummy */
    /* This method catch users query, and print it */
    @RequestMapping(value = "/check-query")
    public ModelAndView getQuery(@ModelAttribute("queryJSP") UserQuery query){
        System.out.println(query.getQuery());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("waitingPage");
        return mav;
    }
}
