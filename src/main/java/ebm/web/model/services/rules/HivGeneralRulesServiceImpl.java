package ebm.web.model.services.rules;

import ebm.web.model.persistence.Hivgeneralrules;
import ebm.web.model.repositories.AssociationRulesRepository;
import ebm.web.model.repositories.HivGeneralRulesRepository;
import ebm.web.model.repositories.HivRulesOnGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 5/19/16.
 */
@Service
public class HivGeneralRulesServiceImpl implements HivGeneralRulesService {
    private HivGeneralRulesRepository repository;

    @Autowired
    public void setAssociationRulesRepository(HivGeneralRulesRepository associationRulesRepository){
        this.repository = associationRulesRepository;
    }
    /**
     * This method will find an Rule instance in the database by its id.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     *
     * @param ruleId
     */
    @Override
    public Hivgeneralrules findByRuleId(Integer ruleId) {
        return repository.findOne(ruleId);
    }

    /**
     * persists rule to the database
     *
     * @param associationRule
     * @return
     */
    @Override
    public String saveRule(Hivgeneralrules associationRule) {
        repository.save(associationRule);
        return String.valueOf(associationRule.getRuleId());
    }

    /**
     * Checks if a rule exists
     *
     * @param ruleId
     * @return
     */
    @Override
    public boolean exists(Integer ruleId) {
        return repository.exists(ruleId);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    @Override
    public Iterable<Hivgeneralrules> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Hivgeneralrules> findAll(Iterable<Integer> integers) {
        return repository.findAll(integers);
    }

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(Integer ruleId) {
        repository.delete(ruleId);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
