package com.clubify.ws.user;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clubify.ws.error.ApiError;
import com.clubify.ws.shared.GenericResponse;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/api/1.0/users")
	public GenericResponse createUser(@Valid @RequestBody User user) {
		
		userService.save(user);
		return new GenericResponse("user created");
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleValidationExpection(MethodArgumentNotValidException exception) {
		ApiError error = new ApiError(400, "Validation Error", "/api/1.0/users");
		Map<String, String> validatationErrors = new HashMap<>();
		for (FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
			validatationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validatationErrors);
		return error;
	}
	
}
