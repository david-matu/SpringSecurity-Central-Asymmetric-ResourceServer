package com.dave.spring.alpha.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dave.spring.alpha.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	
}