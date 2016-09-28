package ua.nure.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.JDBCdriver.postgreSQL.PostgreConnector;
import ua.nure.questions.ITask;
import ua.nure.questions.Task1;
import ua.nure.questions.Task2;
import ua.nure.springMVC.model.UserQuery;

@Controller
public class MainController {

    private volatile ITask someTask;

    /* First method when we start the server */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/about_us", method = RequestMethod.GET)
    public ModelAndView about(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("about/about_us");
        return mav;
    }

    @RequestMapping(value = "/learning", method = RequestMethod.GET)
    public ModelAndView lessons(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("lessons/learning");
        return mav;
    }

    @RequestMapping(value = "/task1", method = RequestMethod.GET)
    public ModelAndView task1(){
        someTask = new Task1();
        ModelAndView mav = new ModelAndView();
        mav.addObject("queryJSP", new UserQuery());
        mav.setViewName("tasks/task1");
        return mav;
    }

    @RequestMapping(value = "/task2", method = RequestMethod.GET)
    public ModelAndView task2(){
        someTask = new Task2();
        ModelAndView mav = new ModelAndView();
        mav.addObject("queryJSP", new UserQuery());
        mav.setViewName("tasks/task2");
        return mav;
    }

    @RequestMapping(value = "/check_and_answer", method = RequestMethod.POST)
    public ModelAndView checkAndAnswer(@ModelAttribute("queryJSP") UserQuery query){
        PostgreConnector connector = PostgreConnector.connect("localhost", 5432, "business_firm", "postgres", "619916");
        ModelAndView mav = new ModelAndView();
        mav.addObject("responseJSP", connector.checkQuery(query, someTask));
        mav.setViewName("tasks/check_and_answer");
        return mav;
    }
}
