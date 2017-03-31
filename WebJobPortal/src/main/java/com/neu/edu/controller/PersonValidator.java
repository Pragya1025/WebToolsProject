package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.User;



public class PersonValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.username", "error.invalid.person", "Username Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "error.invalid.person", "Password Required");
//       
    }
 }
