package com.example.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Users;

public interface UsersRepo extends JpaRepository<Users, Long>{

	@Query(value = "SELECT * FROM users u WHERE u.user_id = ?1", nativeQuery = true)
	Users findByUser_Id(String id);
	
	@Query(value = "SELECT * FROM users u WHERE u.role = ?1", nativeQuery = true)
	List<Map<String, Object>> findByRole(int id);
	
	@Query(value = "SELECT * FROM users", nativeQuery = true)
	List<java.util.Map<String, Object>> findAllUsers();
	
	@Query(value = "SELECT * FROM users u WHERE u.user_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findByUsers_Id(String id);
	
	@Query(value = "SELECT * FROM users u WHERE u.id = ?1", nativeQuery = true)
	List<Map<String, Object>> findByIds(Long id);
	
	
}
