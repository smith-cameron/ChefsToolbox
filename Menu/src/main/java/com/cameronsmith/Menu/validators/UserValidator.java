package com.cameronsmith.Menu.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.cameronsmith.Menu.models.User;
import com.cameronsmith.Menu.repositories.UserRepo;
@Component
public class UserValidator {
	@Autowired
	private UserRepo uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Hey! Passwords Do Not Match.");
		}
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "unique", "Hey! Email Is Already Registered.");
		}
	}
}
