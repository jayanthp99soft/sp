package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
	private Integer id;
	private String name;
	private String password;
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns = {@JoinColumn (name="user_id")},
			inverseJoinColumns = {@JoinColumn(name="role_id")})
	private Set<Role> roles;
	
	
}
