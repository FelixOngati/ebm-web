package ebm.web.model.services.rules;

import ebm.web.model.persistence.TblAssociationRules;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 3/30/16.
 */
@Component
@Service
public interface AssociationRulesService {


    /**
     * This method will find an Rule instance in the database by its id.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */

    public TblAssociationRules findByRuleId(Integer ruleId);

    /**
     * persists rule to the database
     * @param associationRule
     * @return
     */
    public String saveRule(TblAssociationRules associationRule);

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
    public Iterable<TblAssociationRules> findAll();

    public Iterable<TblAssociationRules> findAll(Iterable<Integer> integers);

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    public long count();

    public void delete(Integer ruleId);

    public void deleteAll();

}
