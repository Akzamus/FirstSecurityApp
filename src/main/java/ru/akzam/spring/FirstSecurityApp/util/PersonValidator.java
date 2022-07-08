package ru.akzam.spring.FirstSecurityApp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.akzam.spring.FirstSecurityApp.models.Person;
import ru.akzam.spring.FirstSecurityApp.services.PeopleService;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Person.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(peopleService.findByUsername(person.getUsername()).isPresent())
            errors.rejectValue("username", "","Person with that name already exists");
    }
}
