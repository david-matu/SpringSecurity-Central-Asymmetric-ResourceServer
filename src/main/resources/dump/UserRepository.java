package com.dave.spring.alpha.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
}
