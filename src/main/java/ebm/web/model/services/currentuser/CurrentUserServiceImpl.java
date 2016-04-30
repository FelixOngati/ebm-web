package ebm.web.model.services.currentuser;

import ebm.web.model.persistence.CurrentUser;
import ebm.web.model.persistence.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by the_fegati on 4/29/16.
 */

@Service
public class CurrentUserServiceImpl implements CurrentUserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser,userId);
        return currentUser != null && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }
}
