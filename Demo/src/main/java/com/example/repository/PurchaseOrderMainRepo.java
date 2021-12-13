package com.example.repository;

//import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.PurchaseOrderMain;

@Repository
public interface PurchaseOrderMainRepo extends JpaRepository<PurchaseOrderMain, Long>{
	
	@Query(value = "SELECT * FROM purchase_order_main u WHERE u.purchase_order_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findByPO_Id(String id);
	
	@Query(value = "SELECT * FROM purchase_order_main u WHERE u.product_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findPOByPId(String id);
	
	@Query(value = "SELECT * FROM purchase_order_main", nativeQuery = true)
	List<Map<String, Object>> findAlls();
	
	/*
	@Modifying(clearAutomatically = true)
	@Query("update purchase_order_main pom set pom.product_id =:pid, pom.unit_price =:up, pom.updated_by =:updby, pom.updated_on =:updon where pom.purchase_order_id =:poid")
	void updatePO(@Param("pid") String pid, @Param("up") Double up, @Param("updby") String updby, @Param("updon") Timestamp updon, @Param("poid") String poid);
	*/



}
