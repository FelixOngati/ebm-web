package ebm.web.model.services.rules;

import ebm.web.model.persistence.Hivrulesonregion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 5/19/16.
 */
@Component
@Service
public interface HivRulesOnRegionService {
    public Hivrulesonregion findByRuleId(Integer ruleId);

    /**
     * persists rule to the database
     * @param associationRule
     * @return
     */
    public String saveRule(Hivrulesonregion associationRule);

    /**
     * Checks if a rule exists
     * @param ruleId
     * @return
     */
    public boolean exists(Integer ruleId);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    public Iterable<Hivrulesonregion> findAll();

    public Iterable<Hivrulesonregion> findAll(Iterable<Integer> integers);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    public long count();

    public void delete(Integer ruleId);

    public void deleteAll();
}
