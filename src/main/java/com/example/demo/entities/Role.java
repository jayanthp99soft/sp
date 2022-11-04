package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Data
public class Role implements GrantedAuthority{
   @Id
	private Integer id;
	private String name;
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
}
