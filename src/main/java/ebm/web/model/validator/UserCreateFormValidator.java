package ebm.web.model.validator;

import ebm.web.model.persistence.UserCreateForm;
import ebm.web.model.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by the_fegati on 4/28/16.
 */
@Component
public class UserCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateFormValidator.class);
    private UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService){
        this.userService = userService;
    }

    /**
     * Can this {@link Validator} {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code clazz}?
     * <p>This method is <i>typically</i> implemented like so:
     * <pre class="code">return Foo.class.isAssignableFrom(clazz);</pre>
     * (Where {@code Foo} is the class (or superclass) of the actual
     * object instance that is to be {@link #validate(Object, Errors) validated}.)
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed
     * {@link #validate(Object, Errors) validate} instances of the
     * supplied {@code clazz}
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    /**
     * Validate the supplied {@code target} object, which must be
     * of a {@link Class} for which the {@link #supports(Class)} method
     * typically has (or would) return {@code true}.
     * <p>The supplied {@link Errors errors} instance can be used to report
     * any resulting validation errors.
     *
     * @param target the object that is to be validated (can be {@code null})
     * @param errors contextual state about the validation process (never {@code null})
     * @see ValidationUtils
     */
    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}",target);
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors,form);
        validateEmail(errors, form);
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent())
            errors.reject("email.exists", "User with this email already exists");
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated()))
            errors.reject("password.no_match", "Passwords do not match");
    }
}
