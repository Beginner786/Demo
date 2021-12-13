package com.example.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.VendorMapProduct;

@Repository
public interface VendorMapProductRepo extends JpaRepository<VendorMapProduct, Long>{
	
	
	
	@Query(value = "SELECT * FROM vendor_map_product u WHERE u.vendor_id = ?1", nativeQuery = true)
	List<VendorMapProduct> findByVendor_Id(String id);

	@Query(value = "SELECT * FROM vendor_map_product u WHERE u.product_id = ?1", nativeQuery = true)
	VendorMapProduct getProductDetails(String id);
	
	@Query(value = "SELECT * FROM vendor_map_product", nativeQuery = true)
	List<Map<String, Object>> findAlls();
	
	
}
