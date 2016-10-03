package ua.nure.springMVC.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.JDBCdriver.postgreSQL.PostgresConnector;
import ua.nure.questions.AbstractTask;
import ua.nure.questions.Task1;
import ua.nure.questions.Task2;
import ua.nure.springMVC.models.UserQuery;

@Controller
public class MainController {

    private static Logger logger = Logger.getLogger(MainController.class);
    private volatile AbstractTask someTask;

    /** First method when we start the server */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        logger.info("Index has started");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/about_us", method = RequestMethod.GET)
    public ModelAndView about(){
        logger.info("About has started");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("about/about_us");
        return mav;
    }

    @RequestMapping(value = "/learning", method = RequestMethod.GET)
    public ModelAndView lessons(){
        logger.info("Learning has started");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("lessons/learning");
        return mav;
    }

    @RequestMapping(value = "/task1", method = RequestMethod.GET)
    public ModelAndView task1(){
        logger.info("Task1 has started");
        someTask = new Task1();
        ModelAndView mav = new ModelAndView();
        mav.addObject("queryJSP", new UserQuery());
        mav.setViewName("tasks/task1");
        return mav;
    }

    @RequestMapping(value = "/task2", method = RequestMethod.GET)
    public ModelAndView task2(){
        logger.info("Task2 has started");
        someTask = new Task2();
        ModelAndView mav = new ModelAndView();
        mav.addObject("queryJSP", new UserQuery());
        mav.setViewName("tasks/task2");
        return mav;
    }

    @RequestMapping(value = "/check_and_answer", method = RequestMethod.GET)
    public ModelAndView checkAndAnswer(@ModelAttribute("queryJSP") UserQuery query){
        logger.info("CheckAndAnswer has started");
        PostgresConnector connector = PostgresConnector.connect("localhost", 5432, "business_firm", "postgres", "619916");
        ModelAndView mav = new ModelAndView();
        mav.addObject("responseJSP", connector.checkQuery(query, someTask));
        mav.setViewName("tasks/check_and_answer");
        return mav;
    }
}
