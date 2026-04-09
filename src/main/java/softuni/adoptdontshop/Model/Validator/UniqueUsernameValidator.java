package softuni.adoptdontshop.Model.Validator;

import softuni.adoptdontshop.Service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    private final UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null) {
            return true;
        }
        return userService.isUsernameFree(username);
    }
}

