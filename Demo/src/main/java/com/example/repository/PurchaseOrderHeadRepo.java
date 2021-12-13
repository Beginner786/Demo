package com.example.repository;

//import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.PurchaseOrderHead;

@Repository
public interface PurchaseOrderHeadRepo extends JpaRepository<PurchaseOrderHead, Long>{
	
	@Query(value = "SELECT * FROM purchase_order_head u WHERE u.purchase_order_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findByPO_Id(String id);
	
	@Query(value = "SELECT * FROM purchase_order_head u WHERE u.vendor_id = ?1", nativeQuery = true)
	List<Map<String, Object>> findPOByVId(String id);
	
	@Query(value = "SELECT * FROM purchase_order_head", nativeQuery = true)
	List<Map<String, Object>> findAlls();
	
	
	/*
	@Modifying(clearAutomatically = true)
	@Query("update purchase_order_head poh set poh.total_price =:totprice, poh.total_quantity =:totqnty, poh.vendor_id =:vid , poh.updated_by =:updby, poh.updated_on =:updon where poh.purchase_order_id =:poid")
	void updatePO(@Param("totprice") Double totprice, @Param("totqnty") Long totqnty, @Param("vid") String vid, @Param("updby") String updby, @Param("updon") Timestamp updon, @Param("poid") String poid);
	*/
	

}
