package com.example.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.InvoiceMain;

@Repository
public interface InvoiceMainRepo extends JpaRepository<InvoiceMain, Long> {

	@Query(value = "SELECT * FROM invoice_main", nativeQuery = true)
	List<Map<String, Object>> findAlls();
	
	@Query(value = "SELECT * FROM invoice_main u WHERE u.invoice_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findByInv_Id(String id);
	
	@Query(value = "SELECT * FROM invoice_main u WHERE u.product_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findInvByPId(String id);
	
}
