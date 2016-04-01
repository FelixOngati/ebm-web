package ebm.web.model.services;

import ebm.web.model.persistence.TblAssociationRules;
import ebm.web.model.repositories.AssociationRulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 3/30/16.
 */
@Service
public class AssociationRulesServiceImpl implements AssociationRulesService {
    private AssociationRulesRepository associationRulesRepository;

    @Autowired
    public void setAssociationRulesRepository(AssociationRulesRepository associationRulesRepository){
        this.associationRulesRepository = associationRulesRepository;
    }


    /**
     * This method will find an Rule instance in the database by its id.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     *
     * @param ruleId
     */
    @Override
    public TblAssociationRules findByRuleId(Integer ruleId) {
        return associationRulesRepository.findOne(ruleId);
    }

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param associationRule
     * @return the saved entity
     */
    @Override
    public String saveRule(TblAssociationRules associationRule) {
        associationRulesRepository.save(associationRule);
        return String.valueOf(associationRule.getRuleId());
    }

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param ruleId must not be {@literal null}.
     * @return true if an entity with the given id exists, {@literal false} otherwise
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public boolean exists(Integer ruleId) {
        return associationRulesRepository.exists(ruleId);
    }

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    @Override
    public Iterable<TblAssociationRules> findAll() {
        return associationRulesRepository.findAll();
    }

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param integers
     * @return
     */
    @Override
    public Iterable<TblAssociationRules> findAll(Iterable<Integer> integers) {
        return associationRulesRepository.findAll(integers);
    }

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities
     */
    @Override
    public long count() {
        return associationRulesRepository.count();
    }

    /**
     * Deletes the entity with the given id.
     *
     * @param ruleId must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is {@literal null}
     */
    @Override
    public void delete(Integer ruleId) {
        associationRulesRepository.delete(ruleId);
    }

    /**
     * Deletes all entities managed by the repositories.
     */
    @Override
    public void deleteAll() {
        associationRulesRepository.deleteAll();
    }

}
