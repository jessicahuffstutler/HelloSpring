package com.theironyard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jessicahuffstutler on 11/9/15.
 */
@RestController //knows its JSON because restcontroller
public class HelloSpringJsonController {
    //returns JSON rather than HTML
    @RequestMapping("/person.json") //different route so one doesn't override the other
    public Person person(
            @RequestParam(defaultValue = "Elyse") String name,
            @RequestParam(defaultValue = "Atlanta") String city,
            @RequestParam(defaultValue = "30") Integer age) { //Person is object person is method
        return new Person(name, city, age);
    }
}
