package ebm.web.controllers;


import ebm.web.model.persistence.TblAssociationRules;
import ebm.web.model.services.AssociationRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
