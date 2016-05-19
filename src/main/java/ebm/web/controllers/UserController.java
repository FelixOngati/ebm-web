package ebm.web.controllers;

import ebm.web.model.persistence.UserCreateForm;
import ebm.web.model.services.user.UserService;
import ebm.web.model.validator.UserCreateFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * Created by the_fegati on 4/28/16.
 */
@Controller
public class UserController {
    private UserService userService;
    private UserCreateFormValidator userCreateFormValidator;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator){
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @RequestMapping("/users")
    public String getUsersPage(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(userCreateFormValidator);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("user/{id}")
    public String getUserPage(Model model, @PathVariable final Long id){
        LOGGER.debug("Getting user page for user={}",id);
        model.addAttribute("user", userService.getUserById(id).orElseThrow(() -> new NoSuchElementException(String.format("User = %s not found", id))));
        return "user";
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage(){
        LOGGER.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult){
        LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()){
            return "user_create";
        }
        try {
            userService.create(form);
        }catch (DataIntegrityViolationException e){
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists","Email already exists");
            return "user_create";
        }
        return "redirect:/users";
    }

}
