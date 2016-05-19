package ebm.web.model.services.rules;

import ebm.web.model.persistence.Hivrulesonmaritalstatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 5/19/16.
 */
@Component
@Service
public interface HivRulesOnMaritalStatusService {
    public Hivrulesonmaritalstatus findByRuleId(Integer ruleId);

    /**
     * persists rule to the database
     * @param associationRule
     * @return
     */
    public String saveRule(Hivrulesonmaritalstatus associationRule);

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
    public Iterable<Hivrulesonmaritalstatus> findAll();

    public Iterable<Hivrulesonmaritalstatus> findAll(Iterable<Integer> integers);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    public long count();

    public void delete(Integer ruleId);

    public void deleteAll();
}
