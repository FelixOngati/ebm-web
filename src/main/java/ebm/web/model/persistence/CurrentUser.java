package ebm.web.model.persistence;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by the_fegati on 4/28/16.
 */
public class CurrentUser extends User {
    private TblUser user;

    public CurrentUser(TblUser user){
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user=user;
    }

    public TblUser getUser(){
        return user;
    }

    public Long getId(){
        return user.getId();
    }

    public Role getRole(){
        return user.getRole();
    }
    @Override
    public String toString(){
        return "CurrentUser{" +
                "user=" + user +
                "}" + super.toString();
    }
}
