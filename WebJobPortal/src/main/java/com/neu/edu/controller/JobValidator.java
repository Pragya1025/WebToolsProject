package com.neu.edu.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.edu.pojo.Jobs;



public class JobValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Jobs.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Jobs jobs = (Jobs) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobtitle", "error.invalid.jobs", "Job Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobdescription", "error.invalid.jobs", "Job Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "error.invalid.jobs", "Salary Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skills", "error.invalid.jobs", "Skills Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "error.invalid.jobs", "Location Required");
    }


}
