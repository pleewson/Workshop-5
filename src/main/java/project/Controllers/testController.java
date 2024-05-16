package project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.Models.Book;

@RestController
public class testController {

    @RequestMapping("/test/{num}")
    @ResponseBody
    public String test(@PathVariable("num") int num) {
        return "test- dziala" + num;
    }

}
