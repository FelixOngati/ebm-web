package ebm.web.model.services;

import ebm.web.model.persistence.TblUser;
import ebm.web.model.persistence.UserCreateForm;
import ebm.web.model.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by the_fegati on 4/27/16.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Optional<TblUser> getUserById(long id) {
        LOGGER.debug("Getting user {}",id);
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<TblUser> getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}",email.replaceFirst("@.*","@***"));
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<TblUser> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public TblUser create(UserCreateForm form) {
        TblUser user = new TblUser();
        user.setEmail(form.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
}
