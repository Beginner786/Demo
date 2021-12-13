package com.example.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	@Query(value = "SELECT * FROM product u WHERE u.product_id = ?1", nativeQuery = true)
	Product findByProduct_Id(String id);
	
	
	@Query(value = "SELECT * FROM product u WHERE u.id = ?1", nativeQuery = true)
	List<Map<String, Object>> findsById(Long id);
	
	@Query(value = "SELECT * FROM product", nativeQuery = true)
	List<Map<String, Object>> findAlls();
	
	@Query(value = "SELECT * FROM product u WHERE u.product_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findByProducts_Id(String id);
	
	
}
