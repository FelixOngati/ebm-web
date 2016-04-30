package ebm.web.model.services.currentuser;

import ebm.web.model.persistence.CurrentUser;

/**
 * Created by the_fegati on 4/29/16.
 */
public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
