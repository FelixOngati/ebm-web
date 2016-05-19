package ebm.web.model.services.rules;

import ebm.web.model.persistence.Hivrulesonregion;
import ebm.web.model.repositories.HivRulesOnRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 5/19/16.
 */
@Service
public class HivRulesOnRegionServiceImpl implements HivRulesOnRegionService {

    private HivRulesOnRegionRepository repository;

    @Autowired
    public void setRepository(HivRulesOnRegionRepository repository){
        this.repository = repository;
    }

    @Override
    public Hivrulesonregion findByRuleId(Integer ruleId) {
        return repository.findOne(ruleId);
    }

    /**
     * persists rule to the database
     *
     * @param associationRule
     * @return
     */
    @Override
    public String saveRule(Hivrulesonregion associationRule) {
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
    public Iterable<Hivrulesonregion> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<Hivrulesonregion> findAll(Iterable<Integer> integers) {
        return repository.findAll(integers);
    }

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer ruleId) {

    }

    @Override
    public void deleteAll() {

    }
}
