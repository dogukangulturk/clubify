package com.clubify.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message = "{clubify.constraint.username.NotNull.message}")
	@Size(min = 4, max = 255, message = "{clubify.constraint.username.Size.message}")
	@UniqueUsername
	private String username;
	
	@NotNull(message = "{constraint.displayName.NotNull.message}")
	@Size(min = 4, max = 255, message = "{clubify.constraint.displayName.Size.message}")
	private String displayName;
	
	@NotNull(message = "{constraint.password.NotNull.message}")
	@Size(min = 8, max = 255, message = "{clubify.constraint.password.Size.message}")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{clubify.constraint.password.Pattern.message}")
	private String password;
	
}
