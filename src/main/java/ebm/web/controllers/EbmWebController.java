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
    private AssociationRulesService associationRulesService;

    @Autowired
    public void setAssociationRulesService(AssociationRulesService associationRulesService){
        this.associationRulesService = associationRulesService;
    }

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/fuzzylabs")
    public String fuzzylabs(){
        return "fuzzylabs-data";
    }

    @RequestMapping("/associationrules")
    public String associationrules(){
        return "association-rules";
    }

    @RequestMapping("/icd10")
    public String icd10(){
        return "icd10";
    }

    @RequestMapping("/labs")
    public String labs(){
        return "labs";
    }

    @RequestMapping(value="/insertrule")
    public String insertrule(Model model){
        String ruleId = "";
        try{
            TblAssociationRules tblAssociationRules = new TblAssociationRules(1,"rule => one",0.8f, 0.5f);
            associationRulesService.saveRule(tblAssociationRules);
//            ruleId = String.valueOf(tblAssociationRules.getRuleId());
        }catch (Exception ex){
            return "Error inserting rule : " + ex.toString();
        }
        return "Rule successfully inserted na id: " + ruleId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id){
        return "Successfully deleted";
    }
}
