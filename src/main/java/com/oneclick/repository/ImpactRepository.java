package com.oneclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oneclick.entity.ImpactEntity;
import com.oneclick.entity.NewUser;


public interface ImpactRepository extends CrudRepository<ImpactEntity, String>{

	@Query(value = "SELECT * FROM IMPACT_ENTITY  WHERE EMAIL = ?1", nativeQuery = true)
	  
	List<ImpactEntity> findByEmail(String email);
	
	@Query(value = "SELECT * FROM IMPACT_ENTITY  WHERE RESOURCE = ?1", nativeQuery = true)
	  
	ImpactEntity findByResourceName(String email);
}
