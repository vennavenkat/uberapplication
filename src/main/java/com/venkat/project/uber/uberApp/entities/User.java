package com.venkat.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.venkat.project.uber.uberApp.entities.enums.Role;

@Entity
@Table(name = "app_user", indexes = {
		@Index(name = "idx_user_email", columnList = "email")
})
@Getter
@Setter
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
				.collect(Collectors.toSet());
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
}
