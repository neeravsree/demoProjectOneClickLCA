package com.oneclick.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oneclick.entity.NewUser;




public interface UserRepository extends CrudRepository<NewUser, String>{
	@Query(value = "SELECT * FROM NEW_USER WHERE EMAIL = ?1", nativeQuery = true)
	  
	NewUser findByEmail(String email);

}
