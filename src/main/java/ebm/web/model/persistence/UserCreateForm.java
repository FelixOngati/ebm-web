package ebm.web.model.persistence;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by the_fegati on 4/26/16.
 * This will function as a data transfer object (DTO) between the web layer and service layer.
 * It's annotated by Hibernate Validator validation constraints and sets some sane defaults
 */
public class UserCreateForm {

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password ="";

    @NotEmpty
    private String passwordRepeated = "";

    @NotNull
    private Role role = Role.USER;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
