package ebm.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by the_fegati on 1/21/16.
 */
@Controller
public class EbmWebController {

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model){

        return "index";
    }

}
