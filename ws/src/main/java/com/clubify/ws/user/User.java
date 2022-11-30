package com.clubify.ws.user;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.clubify.ws.shared.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4526380396435671010L;

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message = "{clubify.constraint.username.NotNull.message}")
	@Size(min = 4, max = 255, message = "{clubify.constraint.username.Size.message}")
	@UniqueUsername
	@JsonView(Views.Base.class)
	private String username;
	
	@NotNull(message = "{constraint.displayName.NotNull.message}")
	@Size(min = 4, max = 255, message = "{clubify.constraint.displayName.Size.message}")
	@JsonView(Views.Base.class)
	private String displayName;
	
	@NotNull(message = "{constraint.password.NotNull.message}")
	@Size(min = 8, max = 255, message = "{clubify.constraint.password.Size.message}")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{clubify.constraint.password.Pattern.message}")
	private String password;
	
	@JsonView(Views.Base.class)
	private String image;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("Role_user");
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
