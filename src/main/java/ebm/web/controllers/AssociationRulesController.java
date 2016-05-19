package ebm.web.controllers;

import ebm.web.model.persistence.TblAssociationRules;
import ebm.web.model.services.rules.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by the_fegati on 4/28/16.
 */
@Controller
public class AssociationRulesController {

    private AssociationRulesService associationRulesService;
    private HivRulesOnGenderService rulesOnGenderService;
    private HivGeneralRulesService generalRulesService;
    private HivRulesOnRegionService rulesOnRegionService;
    private HivRulesOnMaritalStatusService rulesOnMaritalStatusService;

    @Autowired
    public void setAssociationRulesService(AssociationRulesService associationRulesService){
        this.associationRulesService = associationRulesService;
    }

    @Autowired
    public void setRulesOnGenderService(HivRulesOnGenderService rulesOnGenderService){
        this.rulesOnGenderService = rulesOnGenderService;
    }

    @Autowired
    public void setGeneralRulesService(HivGeneralRulesService generalRulesService){
        this.generalRulesService = generalRulesService;
    }

    @Autowired
    public void setRulesOnRegionService(HivRulesOnRegionService rulesOnRegionService){
        this.rulesOnRegionService = rulesOnRegionService;
    }

    @Autowired
    public void setRulesOnMaritalStatusService(HivRulesOnMaritalStatusService rulesOnMaritalStatusService){
        this.rulesOnMaritalStatusService = rulesOnMaritalStatusService;
    }

    @RequestMapping("/fuzzylabs")
    public String fuzzylabs(){
        return "fuzzylabs-data";
    }

    @RequestMapping("/associationrules")
    public String associationrules(Model model){
        model.addAttribute("rules",associationRulesService.findAll() );
        return "association-rules";
    }

    @RequestMapping("/generalrules")
    public String generalrules(Model model){
        model.addAttribute("rules",generalRulesService.findAll() );
        return "general-rules";
    }
    @RequestMapping("/rulesongender")
    public String genderrules(Model model){
        model.addAttribute("rules",rulesOnGenderService.findAll() );
        return "gender-rules";
    }

    @RequestMapping("/rulesonregion")
    public String regionrrules(Model model){
        model.addAttribute("rules",rulesOnRegionService.findAll() );
        return "region-rules";
    }

    @RequestMapping("/rulesonmaritalstatus")
    public String maritalrules(Model model){
        model.addAttribute("rules",rulesOnMaritalStatusService.findAll() );
        return "maritalstatus-rules";
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
