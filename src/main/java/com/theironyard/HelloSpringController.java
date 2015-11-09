package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by jessicahuffstutler on 11/9/15.
 */
@Controller
public class HelloSpringController {
    @RequestMapping("/person") //can take arguments like methods, this is our person route
    public String person(
            Model model,
            @RequestParam(defaultValue = "Bob") String name,
            @RequestParam(defaultValue = "Charleston") String city,
            @RequestParam(defaultValue = "30") Integer age
    ) { //to request query params instead of hard coding data add String name, String city, Integer age above
        //however we did add default values if nothing was/is input from the user.

        //this gives mustache our information (below)
        //since we added String, String, Integer to the argument above, we can feed the variables in here
        //instead of hard coding the information in like: "Bob", "Charleston", 30
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        return "person"; //returns mustache template into this route
    }

    //returns the HTML template without injecting anything
    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "home";
    }

    //for login route: String username: name = username so it needs to say username here, it's how they're mapped together
    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username) { //this is where we used to have request.queryparams
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        return "redirect:/";
    }
}
