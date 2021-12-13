package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Status;

@Repository
public interface StatusRepo extends JpaRepository<Status, Integer>{
	
	@Query(value = "SELECT * FROM status u WHERE u.status = ?1", nativeQuery = true)
	Status getStatusId(String id);

}
