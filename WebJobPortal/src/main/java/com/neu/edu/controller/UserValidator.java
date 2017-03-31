package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Person;



public class UserValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Person.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Person person = (Person) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.username", "error.invalid.person", "Username Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.password", "error.invalid.person", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.person", "PhoneNumber Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.person", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.person", "Email Required");
    }

}
