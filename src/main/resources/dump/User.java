package com.dave.spring.alpha.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dave.spring.alpha.model.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
//@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long userId;
	
	private String username;
	private String password;
	private String fullname;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="USER_ROLE")
	private String authorities = "ROLE_USER";
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", 
						joinColumns = @JoinColumn(name = "USER_ID"),
						inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles; 
	
	public User(String username, String password, String authority) {
		this.username = username;
		this.password = password;
		this.authorities = authority;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(authorities));
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
