package com.example.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.InvoiceHead;

@Repository
public interface InvoiceHeadRepo extends JpaRepository<InvoiceHead, Long> {

	@Query(value = "SELECT * FROM invoice_head", nativeQuery = true)
	List<Map<String, Object>> findAlls();
	
	@Query(value = "SELECT * FROM invoice_head u WHERE u.invoice_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findByInv_Id(String id);
	
	@Query(value = "SELECT * FROM invoice_head u WHERE u.purchase_order_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findInvByPOId(String id);
	
	@Query(value = "SELECT sum(tot_quantity_received) FROM invoice_head u WHERE u.purchase_order_id = ?1 and u.status= ?2", nativeQuery = true)
	BigInteger getReceivedSum(String id,int stat);
	
	
}
