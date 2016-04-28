package ebm.web.model.repositories;

import ebm.web.model.persistence.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by the_fegati on 4/27/16.
 */
public interface UserRepository extends JpaRepository<TblUser, Long> {
    Optional<TblUser> findOneByEmail(String email);
}
