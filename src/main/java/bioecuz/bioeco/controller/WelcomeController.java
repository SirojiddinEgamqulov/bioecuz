package bioecuz.bioeco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Override
    @GetMapping
    public String toString() {
        return "Hello";
    }
}
