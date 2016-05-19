package ebm.web.model.services.rules;

import ebm.web.model.persistence.Hivrulesongender;
import ebm.web.model.repositories.HivRulesOnGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 5/19/16.
 */
@Service
public class HivRulesOnGenderServiceImpl implements HivRulesOnGenderService {

    private HivRulesOnGenderRepository repository;

    @Autowired
    public void setAssociationRulesRepository(HivRulesOnGenderRepository associationRulesRepository){
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
    public Hivrulesongender findByRuleId(Integer ruleId) {
        return repository.findOne(ruleId);
    }

    /**
     * persists rule to the database
     *
     * @param associationRule
     * @return
     */
    @Override
    public String saveRule(Hivrulesongender associationRule) {
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
    public Iterable<Hivrulesongender> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Hivrulesongender> findAll(Iterable<Integer> integers) {
        return null;
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

    }
}
