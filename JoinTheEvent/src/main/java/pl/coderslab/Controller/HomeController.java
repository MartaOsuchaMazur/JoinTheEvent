package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    @ResponseBody
    public String getLandingPage() {
        return "Join our event today.\n" +
                "Fill out the form and register!";
    }
}
