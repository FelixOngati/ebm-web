package ebm.web.model.services.user;

import ebm.web.model.persistence.TblUser;
import ebm.web.model.persistence.UserCreateForm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by the_fegati on 4/27/16.
 */
@Component
@Service
public interface UserService {
    Optional<TblUser> getUserById(long id);

    Optional<TblUser> getUserByEmail(String email);

    Collection<TblUser> getAllUsers();

    TblUser create(UserCreateForm form);
}
