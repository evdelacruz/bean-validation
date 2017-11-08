package com.evdelacruz.samples.beanvalidation.service.contract.validation.validators;

import com.evdelacruz.samples.beanvalidation.service.contract.validation.constraints.UniqueUsername;
import com.evdelacruz.samples.beanvalidation.service.datasource.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private @Autowired UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername annotation) {
        //Do nothing
    }

    @Override
    public boolean isValid(String param, ConstraintValidatorContext context) {
        return !userRepository.existUsername(param);
    }
}
