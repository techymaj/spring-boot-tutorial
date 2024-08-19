package tech.majaliwa.content_calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String error() {
        return "<h1>Holla!</h1>";
    }
}
