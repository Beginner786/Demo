package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adding.InvoiceAdding;
import com.example.adding.ProductAdding;
import com.example.adding.PurchaseOrderAdding;
import com.example.model.Status;
import com.example.model.UserRoles;
import com.example.model.Users;
import com.example.model.Vendor;
import com.example.model.VendorMapProduct;
import com.example.service.Services;


@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	Services services;
	
	// UserRoles  ----------------------------------------------------------------------------
	
	@PostMapping("/{userId}/createUserRole")
	public String createUserRole(@PathVariable String userId , @RequestBody UserRoles userRoles)
	{
		return services.addUserRole(userRoles, userId);
	}
	
	@GetMapping("/getUserRoles")
	public List<UserRoles> getUserRoles()
	{
		return services.getUserRoles();
	}
	
	@GetMapping("/getUserRoleById/{id}")
	public Optional<UserRoles> getUserRoleById(@PathVariable int id)
	{
		return services.getUserRoleById(id);
	}
	
	@PutMapping("/{userId}/editUserRole/{id}/{newname}")
	public String updateUserRole(@PathVariable String userId , @PathVariable int id, @PathVariable String newname)
	{
		return services.updateUserRole(userId, id, newname);
	}
	
	@DeleteMapping("/deleteAllUserRoles")
	public String deleteAllUserRoles()
	{
		return services.deleteAllUserRoles();
	}
	
	@DeleteMapping("/deleteUserRolesById/{id}")
	public String deleteUserRoleById(@PathVariable int id)
	{
		return services.deleteUserRoleById(id);
	}
	
	
	// Users ----------------------------------------------------------------
	
	@PostMapping("/{userId}/createUser")
	public String createUser(@PathVariable String userId , @RequestBody Users users)
	{
		return services.addUser(users, userId);
	}
	
	@GetMapping("/getUsers")
	public List<Map<String, Object>> getUsers()
	{
		return services.getUsers();
	}
	
	@DeleteMapping("/deleteAllUsers")
	public String deleteAllUsers()
	{
		return services.deleteAllUsers();
	}
	
	@GetMapping("/getUserByUserId/{id}")
	public List<Map<String, Object>> getUserByUserId(@PathVariable String id)
	{
		return services.getUsersByUserId(id);
	}
	
	@GetMapping("/getUserByRoleId/{id}")
	public List<Map<String, Object>> getUserByRoleId(@PathVariable int id)
	{
		return services.getUserByRoleId(id);
	}

	@GetMapping("/getUserById/{id}")
	public List<Map<String, Object>> getUserById(@PathVariable Long id)
	{
		return services.getUserById(id);
	}
	
	@PutMapping("/{userId}/editUser/{id}/{newname}/{role}")
	public String updateUser(@PathVariable String userId , @PathVariable int role, @PathVariable String newname,  @PathVariable String id)
	{
		return services.updateUser(userId, id, role, newname);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable long id)
	{
		return services.deleteUserById(id);
	}
	
	@DeleteMapping("/deleteUserByUserId/{id}")
	public String deleteUserByUserId(@PathVariable String id)
	{
		return services.deleteUserByUserId(id);
	}
	
	
	// Vendor ------------------------------------------------------------------------------


	
	@PostMapping("/{userId}/createVendor")
	public String createVendor(@PathVariable String userId , @RequestBody Vendor vendor)
	{
		return services.addVendor(vendor, userId);
	}
	
	@GetMapping("/getVendor")
	public List<Vendor> getVendors()
	{
		return services.getVendors();
	}
	
	@DeleteMapping("/deleteAllVendors")
	public String deleteAllVendors()
	{
		return services.deleteAllVendors();
	}
	
	@GetMapping("/getVendorByVendorId/{id}")
	public Vendor getVendorByVendorId(@PathVariable String id)
	{
		return services.getVendorByVendorId(id);
	}
	
	@GetMapping("/getVendorByVendorName/{name}")
	public List<Vendor> getVendorByVendorName(@PathVariable String name)
	{
		return services.getVendorByVendorName(name);
	}

	@GetMapping("/getVendorById/{id}")
	public Optional<Vendor> getVendorById(@PathVariable Long id)
	{
		return services.getVendorById(id);
	}
	
	@PutMapping("/{userId}/editVendor/{id}/{newname}/{newaddr}")
	public String updateVendor(@PathVariable String userId , @PathVariable String newaddr, @PathVariable String newname,  @PathVariable String id)
	{
		return services.updateVendor(userId, id, newaddr, newname);
	}
	
	@DeleteMapping("/deleteVendorById/{id}")
	public String deleteVendorById(@PathVariable long id)
	{
		return services.deleteVendorById(id);
	}
	
	@DeleteMapping("/deleteVendorByVendorId/{id}")
	public String deleteVendorByVendorId(@PathVariable String id)
	{
		return services.deleteVendorByVendorId(id);
	}
	
	
	// Product ------------------------------------------------------------------------------


	
	@PostMapping("/{userId}/createProduct")
	public String createVendor(@PathVariable String userId , @RequestBody ProductAdding productAdding)
	{
		return services.addProduct(productAdding, userId);
	}
	
	@GetMapping("/getProducts")
	public List<Object> getProducts()
	{
		return services.getProducts();
	}
	
	@DeleteMapping("/deleteAllProducts")
	public String deleteAllProducts()
	{
		return services.deleteAllProducts();
	}
	
	@GetMapping("/getProductByProductId/{id}")
	public List<Object> getProductByProductId(@PathVariable String id)
	{
		return services.getProductByProductId(id);
	}
	
	@GetMapping("/getProductById/{id}")
	public List<Map<String, Object>> getProductById(@PathVariable Long id)
	{
		return services.getProductById(id);
	}

	@GetMapping("/getProductByVendorId/{id}")
	public List<VendorMapProduct> getProductByVendorId(@PathVariable String id)
	{
		return services.getProductByVendorId(id);
	}
	
	@PutMapping("/{userId}/editProduct/{id}/{vid}/{newname}/{newunitprice}/{newdescription}")
	public String updateProduct(@PathVariable String userId, @PathVariable String vid , @PathVariable String newdescription, @PathVariable String newname,  @PathVariable String id, @PathVariable Double newunitprice)
	{
		return services.updateProduct(userId, id, vid, newname, newunitprice, newdescription);
	}
	
	@DeleteMapping("/deleteProductById/{id}")
	public String deleteProductById(@PathVariable long id)
	{
		return services.deleteProductById(id);
	}
	
	
	@DeleteMapping("/deleteProductByProductId/{id}")
	public String deleteProductByProductId(@PathVariable String id)
	{
		return services.deleteProductByProductId(id);
	}
	
	
	// Status  ----------------------------------------------------------------------------
	
		@PostMapping("/{userId}/createStatus")
		public String createStatus(@PathVariable String userId , @RequestBody Status status)
		{
			return services.addStatus(status, userId);
		}
		
		@GetMapping("/getStatus")
		public List<Status> getStatus()
		{
			return services.getStatus();
		}
		
		@GetMapping("/getStatusById/{id}")
		public Optional<Status> getStatusById(@PathVariable int id)
		{
			return services.getStatusById(id);
		}
		
		@PutMapping("/{userId}/editStatus/{id}/{newname}")
		public String updateStatus(@PathVariable String userId , @PathVariable int id, @PathVariable String newname)
		{
			return services.updateStatus(userId, id, newname);
		}
		
		@DeleteMapping("/deleteAllStatus")
		public String deleteAllStatus()
		{
			return services.deleteAllStatus();
		}
		
		@DeleteMapping("/deleteStatusById/{id}")
		public String deleteStatusById(@PathVariable int id)
		{
			return services.deleteStatusById(id);
		}
	
	
	
	// Purchase Order ----------------------------------------------------------------------------------------------
	
	@PostMapping("/{userId}/createPurchaseOrder")
	public String createPurchaseOrder(@PathVariable String userId , @RequestBody PurchaseOrderAdding purchaseOrderAdding)
	{
		return services.addPurchaseOrder(purchaseOrderAdding, userId);
	}
	
	@GetMapping("/getPOs")
	public List<Object> getPOs()
	{
		return services.getPOs();
	}
	
	
	@GetMapping("/getPOsByPOId/{id}")
	public List<Object> getPOsByPOId(@PathVariable String id)
	{
		return services.getPOByPOId(id);
	}
	
	@GetMapping("/getPOsByVId/{id}")
	public List<Map<String, Object>> getPOsByVId(@PathVariable String id)
	{
		return services.getPOByVId(id);
	}
	
	@GetMapping("/getPOsByPId/{id}")
	public List<Map<String, Object>> getPOsByPId(@PathVariable String id)
	{
		return services.getPOByPId(id);
	}
	
	
	@PutMapping("/{userId}/editPO/{id}/{vid}/{totQnty}/{pid}")
	public String updatePO(@PathVariable String userId , @PathVariable String id, @PathVariable String vid, @PathVariable String pid,  @PathVariable Long totQnty)
	{
		return services.updatePO(userId, id, vid, totQnty, pid,0);
	}
	
	@PutMapping("/{userId}/approvePO/{id}/{vid}/{totQnty}/{pid}/{val}")
	public String approvePO(@PathVariable String userId , @PathVariable String id, @PathVariable String vid, @PathVariable String pid,  @PathVariable Long totQnty, @PathVariable int val)
	{
		return services.updatePO(userId, id, vid, totQnty, pid,val);
	}
	
	@PutMapping("/closePO/{id}")
	public String approvePO(@PathVariable String id)
	{
		return services.closePO(id);
	}

	@DeleteMapping("/deletePO/{id}")
	public String deletePOByPOId(@PathVariable String id)
	{
		return services.deletePO(id);
	}
	
	@DeleteMapping("/deleteAllPOs")
	public String deleteAllPOs()
	{
		return services.deleteAllPOs();
	}
	
	// Invoices -----------------------------------------------------------------------------------------------
	
	
	@PostMapping("/{userId}/createInvoice")
	public String createInvoice(@PathVariable String userId , @RequestBody InvoiceAdding invoiceAdding)
	{
		return services.addInvoice(invoiceAdding, userId);
	}
	
	@GetMapping("/getInvoices")
	public List<Object> getInvoices()
	{
		return services.getInvoices();
	}
	
	@DeleteMapping("/deleteAllInvoices")
	public String deleteAllInvoices()
	{
		return services.deleteAllInvoices();
	}
	
	@GetMapping("/getInvoiceByInvoiceId/{id}")
	public List<Object> getInvsByInvId(@PathVariable String id)
	{
		return services.getInvByInvId(id);
	}
	
	@GetMapping("/getInvoiceByPOId/{id}")
	public List<Map<String, Object>> getInvsByPOId(@PathVariable String id)
	{
		return services.getInvByPOId(id);
	}
	
	@GetMapping("/getInvoiceByProductId/{id}")
	public List<Map<String, Object>> getInvsByPId(@PathVariable String id)
	{
		return services.getInvByPId(id);
	}
	
	@PutMapping("/{userId}/editInvoice/{id}/{poid}/{totQntyR}/{receivedOn}/{pid}/{up}")
	public String updateInvoice(@PathVariable String userId , @PathVariable String id, @PathVariable String poid, @PathVariable String pid,  @PathVariable Long totQntyR , @PathVariable String receivedOn,  @PathVariable Double up)
	{
		return services.updateInv(userId, id, poid, totQntyR, receivedOn, pid, up, 0);
	}
	
	@PutMapping("/{userId}/editInvoice/{id}/{poid}/{totQntyR}/{receivedOn}/{pid}/{up}/{val}")
	public String closeInvoice(@PathVariable String userId , @PathVariable String id, @PathVariable String poid, @PathVariable String pid,  @PathVariable Long totQntyR , @PathVariable String receivedOn,  @PathVariable Double up, @PathVariable int val)
	{
		return services.updateInv(userId, id, poid, totQntyR, receivedOn, pid, up, val);
	}
	
	@DeleteMapping("/deleteInvoice/{id}")
	public String deleteInvByInvId(@PathVariable String id)
	{
		return services.deleteInv(id);
	}
	
}
