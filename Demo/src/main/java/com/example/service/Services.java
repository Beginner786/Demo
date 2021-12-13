package com.example.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adding.InvoiceAdding;
import com.example.adding.ProductAdding;
import com.example.adding.PurchaseOrderAdding;
import com.example.model.InvoiceHead;
import com.example.model.InvoiceMain;
import com.example.model.Product;
import com.example.model.PurchaseOrderHead;
import com.example.model.PurchaseOrderMain;
import com.example.model.Status;
import com.example.model.UserRoles;
import com.example.model.Users;
import com.example.model.Vendor;
import com.example.model.VendorMapProduct;
import com.example.repository.InvoiceHeadRepo;
import com.example.repository.InvoiceMainRepo;
import com.example.repository.ProductRepo;
import com.example.repository.PurchaseOrderHeadRepo;
import com.example.repository.PurchaseOrderMainRepo;
import com.example.repository.StatusRepo;
import com.example.repository.UserRolesRepo;
import com.example.repository.UsersRepo;
import com.example.repository.VendorMapProductRepo;
import com.example.repository.VendorRepo;

@Service
public class Services {
	
	static long purchaseIdG=0,invoiceIdG=0;

	@Autowired
	UserRolesRepo userRolesRepo;
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	VendorRepo vendorRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	VendorMapProductRepo vendorMapProductRepo;
	
	@Autowired
	StatusRepo statusRepo;
	
	@Autowired
	PurchaseOrderHeadRepo purchaseOrderHeadRepo;
	
	@Autowired
	PurchaseOrderMainRepo purchaseOrderMainRepo;
	
	@Autowired
	InvoiceHeadRepo invoiceHeadRepo;
	
	@Autowired
	InvoiceMainRepo invoiceMainRepo;
	
	// UserRoles ---------------------------------------------------------------------------
	
	
	public String addUserRole(UserRoles userRoles, String createdBy)
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		userRoles.setCreated_on(timestamp);
		userRoles.setCreated_by(createdBy);
		userRolesRepo.save(userRoles);
		return "New user role added successfully! Role ID: '"+userRoles.getId()+"' , Role name: '"+userRoles.getRole()+"'";
	}
	
	public List<UserRoles> getUserRoles()
	{
		return userRolesRepo.findAll();
	}
	
	public Optional<UserRoles> getUserRoleById(int id)
	{
		return userRolesRepo.findById(id);
	}
	
	public String updateUserRole(String updatedBy, int id, String role)
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Optional<UserRoles> fetched=getUserRoleById(id);
		String prev=fetched.get().getRole();
		fetched.get().setRole(role);
		fetched.get().setUpdated_on(timestamp);
		fetched.get().setUpdated_by(updatedBy);
		userRolesRepo.save(fetched.get());
		return "User role updated successfully! Role ID: '"+id+"' , Previous Role name: '"+prev+"' , now Role name: '"+role+"'";
	}
	
	public String deleteAllUserRoles()
	{
		userRolesRepo.deleteAll();
		return "All User roles deleted";
	}
	
	public String deleteUserRoleById(int id)
	{
		Optional<UserRoles> fetched=getUserRoleById(id);
		userRolesRepo.deleteById(id);
		return "User role deleted with Id: '"+id+"' , role: '"+fetched.get().getRole()+"'";
	}
	
	//  Users  ----------------------------------------------------------------------------------------------------------
	
	public String addUser(Users users, String createdBy)
	{
		Users fetched=getUserByUserId(users.getUser_id());
		if(fetched!=null)
			return "User with given user_Id: "+users.getUser_id()+" already exists!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		users.setCreated_on(timestamp);
		users.setCreated_by(createdBy);
		users.setUser_roles(getUserRoleById(users.getRole()).get());
		usersRepo.save(users);
		return "New user added successfully! ID: '"+users.getId()+"' , User ID: '"+users.getUser_id()+"' , Role Id: '"+users.getRole()+"'";
	}
	
	public List<Map<String, Object>> getUsers()
	{
		//return usersRepo.findAll();
		return usersRepo.findAllUsers();
	}
	
	public String deleteAllUsers()
	{
		usersRepo.deleteAll();
		return "All Users deleted";
	}
	
	public List<Map<String, Object>> getUsersByUserId(String id)
	{
		return usersRepo.findByUsers_Id(id);
	}
	
	public Users getUserByUserId(String id)
	{
		return usersRepo.findByUser_Id(id);
	}
	
	public List<Map<String, Object>> getUserByRoleId(int id)
	{
		return usersRepo.findByRole(id);
	}
	
	public List<Map<String, Object>> getUserById(Long id)
	{
		return usersRepo.findByIds(id);
	}
	
	public String updateUser(String updatedBy, String id, int role, String name)
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Users fetched=getUserByUserId(id);
		fetched.setRole(role);
		fetched.setName(name);
		fetched.setUser_roles(getUserRoleById(role).get());
		fetched.setUpdated_on(timestamp);
		fetched.setUpdated_by(updatedBy);
		usersRepo.save(fetched);
		return "User role updated successfully for User ID: '"+id+"'";
	}
	
	public String deleteUserById(long id)
	{
		usersRepo.deleteById(id);
		return "User deleted with Id: '"+id+"'";
	}
	
	public String deleteUserByUserId(String id)
	{
		Users users=usersRepo.findByUser_Id(id);
		deleteUserById(users.getId());
		return "User deleted with User Id: '"+id+"'";
	}
	
	
	// Vendor -------------------------------------------------------------------
	
	
	public String addVendor(Vendor vendor, String createdBy)
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		vendor.setAdded_on(timestamp);
		vendor.setAdded_by(createdBy);
		vendorRepo.save(vendor);
		return "New vendor added successfully! ID: '"+vendor.getId()+"' , Vendor ID: '"+vendor.getVendor_id()+"' , Vendor Name: '"+vendor.getName()+"'";
	}
	
	public List<Vendor> getVendors()
	{
		return vendorRepo.findAll();
	}
	
	public String deleteAllVendors()
	{
		vendorRepo.deleteAll();
		return "All Vendors deleted";
	}
	
	public Vendor getVendorByVendorId(String id)
	{
		return vendorRepo.findByVendor_Id(id);
	}
	
	public List<Vendor> getVendorByVendorName(String id)
	{
		return vendorRepo.findByName(id);
	}
	
	public Optional<Vendor> getVendorById(Long id)
	{
		return vendorRepo.findById(id);
	}
	
	public String updateVendor(String updatedBy, String id, String address, String name)
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Vendor fetched=getVendorByVendorId(id);
		fetched.setName(name);
		fetched.setAddress(address);
		fetched.setUpdated_on(timestamp);
		fetched.setUpdated_by(updatedBy);
		vendorRepo.save(fetched);
		return "Vendor updated successfully for Vendor ID: '"+id+"'";
	}
	
	public String deleteVendorById(long id)
	{
		vendorRepo.deleteById(id);
		return "Vendor deleted with Id: '"+id+"'";
	}
	
	public String deleteVendorByVendorId(String id)
	{
		Vendor vendor=vendorRepo.findByVendor_Id(id);
		deleteVendorById(vendor.getId());
		return "Vendor deleted with Vendor Id: '"+id+"'";
	}
	
	// Product -------------------------------------------------------------------------------------------
	
	
	public String addProduct(ProductAdding productAdding, String createdBy)
	{
		Vendor fetched=getVendorByVendorId(productAdding.getVendor_id());
		if(fetched==null)
			return "Given vendor id: "+productAdding.getVendor_id()+" does not exist!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Product product=new Product(productAdding.getProduct_id() , productAdding.getName(), productAdding.getUnit_price(), productAdding.getDescription());
		product.setAdded_by(createdBy);
		product.setAdded_on(timestamp);
		VendorMapProduct vendorMapProduct=new VendorMapProduct(productAdding.getProduct_id(), productAdding.getVendor_id());
		vendorMapProductRepo.save(vendorMapProduct);
		product.setVendorMapProduct(vendorMapProductRepo.getProductDetails(product.getProduct_id()));
		productRepo.save(product);
		return "New product added successfully! ID: '"+product.getId()+"' , Product ID: '"+product.getProduct_id()+"' , Vendor Id: '"+productAdding.getVendor_id()+"'";
	}
	
	public List<Object> getProducts()
	{
		List<Object> obj=new ArrayList<Object>();
		obj.addAll(productRepo.findAlls());
		obj.addAll(vendorMapProductRepo.findAlls());
		return obj;
	}
	
	public String deleteAllProducts()
	{
		productRepo.deleteAll();
		vendorMapProductRepo.deleteAll();
		return "All Products deleted";
	}
	
	public List<Object> getProductByProductId(String id)
	{
		VendorMapProduct vendorMapProduct=vendorMapProductRepo.getProductDetails(id);
		List<Object> obj=new ArrayList<Object>();
		obj.add(vendorMapProduct);
		obj.addAll(productRepo.findByProducts_Id(id));
		return obj;
	}
	
	public Product gPByPId(String id)
	{
		return productRepo.findByProduct_Id(id);
	}
	
	public List<Map<String, Object>> getProductById(Long id)
	{
		return productRepo.findsById(id);
	}
	
	public Optional<Product> gPById(Long id)
	{
		return productRepo.findById(id);
	}
	
	public List<VendorMapProduct> getProductByVendorId(String id)
	{
		return vendorMapProductRepo.findByVendor_Id(id);
	}
	
	public String updateProduct(String updatedBy, String id, String vid, String name, Double up, String description)
	{
		Vendor fetched2=getVendorByVendorId(vid);
		if(fetched2==null)
			return "Given vendor id: "+vid+" does not exist!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Product fetched=gPByPId(id);
		fetched.setName(name);
		fetched.setUnit_price(up);
		fetched.setDescription(description);
		fetched.setUpdated_on(timestamp);
		fetched.setUpdated_by(updatedBy);
		fetched.setVendorMapProduct(vendorMapProductRepo.getProductDetails(id));
		productRepo.save(fetched);
		VendorMapProduct vendorMapProduct=vendorMapProductRepo.getProductDetails(id);
		vendorMapProduct.setVendor_id(vid);
		vendorMapProductRepo.save(vendorMapProduct);
		return "Product updated successfully for Product ID: '"+id+"'";
	}
	
	public String deleteProductById(long id)
	{
		VendorMapProduct vendorMapProduct=vendorMapProductRepo.getProductDetails(gPById(id).get().getProduct_id());
		productRepo.deleteById(id);
		vendorMapProductRepo.deleteById(vendorMapProduct.getId());
		return "Product deleted with Id: '"+id+"'";
	}
	
	public String deleteProductByProductId(String id)
	{
		Product product=productRepo.findByProduct_Id(id);
		deleteProductById(product.getId());
		return "Product deleted with Product Id: '"+id+"'";
	}		
	
	
	// Status ---------------------------------------------------------------------------
	
	
		public String addStatus(Status status, String createdBy)
		{
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			status.setCreated_on(timestamp);
			status.setCreated_by(createdBy);
			statusRepo.save(status);
			return "New status added successfully! Status ID: '"+status.getId()+"' , Status name: '"+status.getStatus()+"'";
		}
		
		public List<Status> getStatus()
		{
			return statusRepo.findAll();
		}
		
		public Optional<Status> getStatusById(int id)
		{
			return statusRepo.findById(id);
		}
		
		public String updateStatus(String updatedBy, int id, String name)
		{
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Optional<Status> fetched=getStatusById(id);
			String prev=fetched.get().getStatus();
			fetched.get().setStatus(name);
			fetched.get().setUpdated_on(timestamp);
			fetched.get().setUpdated_by(updatedBy);
			statusRepo.save(fetched.get());
			return "Status updated successfully! Status ID: '"+id+"' , Previous Status name: '"+prev+"' , now Status name: '"+name+"'";
		}
		
		public String deleteAllStatus()
		{
			statusRepo.deleteAll();
			return "All Status deleted";
		}
		
		public String deleteStatusById(int id)
		{
			Optional<Status> fetched=getStatusById(id);
			statusRepo.deleteById(id);
			return "Status deleted with Id: '"+id+"' , status name: '"+fetched.get().getStatus()+"'";
		}
	
	
	
	
	// Purchase Order ----------------------------------------------------------------------------------------------
	
	public String addPurchaseOrder(PurchaseOrderAdding purchaseOrderAdding, String createdBy)
	{
		Vendor fetched=getVendorByVendorId(purchaseOrderAdding.getVendorId());
		if(fetched==null)
			return "Given vendor id: "+purchaseOrderAdding.getVendorId()+" does not exist!";
		Product fetched2=gPByPId(purchaseOrderAdding.getProductId());
		if(fetched2==null)
			return "Given product id: "+purchaseOrderAdding.getProductId()+" does not exist!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		PurchaseOrderHead purchaseOrderHead=new PurchaseOrderHead(purchaseOrderAdding.getVendorId() , purchaseOrderAdding.getTotQuantity());
		purchaseOrderHead.setCreated_by(createdBy);
		purchaseOrderHead.setCreated_on(timestamp);
		purchaseOrderHead.setTotal_price(purchaseOrderAdding.getTotQuantity() * fetched2.getUnit_price());
		purchaseIdG++;
        String purId="PO"+purchaseOrderAdding.getProductId()+(""+timestamp+"").substring(11,19)+"LKT"+purchaseIdG+"";
        purchaseOrderHead.setPurchase_order_id(purId);
        purchaseOrderHead.setStatus(39);
        purchaseOrderHead.setStatus_obj(getStatusById(purchaseOrderHead.getStatus()).get());
		purchaseOrderHeadRepo.save(purchaseOrderHead);
		PurchaseOrderMain purchaseOrderMain=new PurchaseOrderMain(purId, purchaseOrderAdding.getProductId(), fetched2.getUnit_price());
		purchaseOrderMain.setCreated_by(createdBy);
		purchaseOrderMain.setCreated_on(timestamp);
		purchaseOrderMain.setPurchaseOrderHead(purchaseOrderHead);
		purchaseOrderMainRepo.save(purchaseOrderMain);
		return "New purchase order placed successfully! Id: '"+purchaseOrderHead.getId()+"' , Please note down the Purchase Order ID: '"+purId+"' , Product ID ordered: '"+fetched2.getProduct_id()+"' , from Vendor Id: '"+purchaseOrderAdding.getVendorId()+"'";
	}
	
	public List<Object> getPOs()
	{
		List<Object> obj=new ArrayList<Object>();
		obj.addAll(purchaseOrderHeadRepo.findAlls());
		obj.addAll(purchaseOrderMainRepo.findAlls());
		return obj;
	}
	
	public String deleteAllPOs()
	{
		purchaseOrderHeadRepo.deleteAll();
		purchaseOrderMainRepo.deleteAll();
		return "All Purchase Orders deleted";
	}
	
	public List<Object> getPOByPOId(String id)
	{
		List<Object> obj=new ArrayList<Object>();
		obj.add(purchaseOrderHeadRepo.findByPO_Id(id));
		obj.add(purchaseOrderMainRepo.findByPO_Id(id));
		return obj;
	}
	
	public List<Map<String, Object>> getPOByVId(String id)
	{
		return purchaseOrderHeadRepo.findPOByVId(id);
	}
	
	public List<Map<String, Object>> getPOByPId(String id)
	{
		return purchaseOrderMainRepo.findPOByPId(id);
	}
	
	
	public String updatePO(String updatedBy, String id, String vid, Long totQnty, String pid,int val)
	{
		Vendor fetched2=getVendorByVendorId(vid);
		if(fetched2==null)
			return "Given vendor id: "+vid+" does not exist!";
		Product fetched3=gPByPId(pid);
		if(fetched3==null)
			return "Given product id: "+pid+" does not exist!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Map<String, Object> map= purchaseOrderHeadRepo.findByPO_Id(id).get(0);
		if("closed".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This purchase order with Id: "+id+" is already closed and hence cannot be modified!";
		if("approved".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This purchase order with Id: "+id+" is already approved and hence cannot be modified or approved again!";
		Map<String, Object> map2= purchaseOrderMainRepo.findByPO_Id(id).get(0);
		//return map.get("id")+" "+map.get("created_by")+" "+map2.get("id")+" "+map2.get("purchase_order_id");
		PurchaseOrderHead purchaseOrderHead=new PurchaseOrderHead(vid , totQnty);
		purchaseOrderHead.setCreated_by((String)map.get("created_by"));
		purchaseOrderHead.setCreated_on((Timestamp)map.get("created_on"));
		purchaseOrderHead.setTotal_price(totQnty * fetched3.getUnit_price());
		purchaseOrderHead.setPurchase_order_id((String)map.get("purchase_order_id"));
		if(val==0)
		{
			purchaseOrderHead.setStatus((int)map.get("status"));
			purchaseOrderHead.setStatus_obj(getStatusById(purchaseOrderHead.getStatus()).get());
		}
		else
		{
			purchaseOrderHead.setStatus(val);
			purchaseOrderHead.setStatus_obj(getStatusById(val).get());
		}
        purchaseOrderHead.setUpdated_by(updatedBy);
        purchaseOrderHead.setUpdated_on(timestamp);
        purchaseOrderHead.setStatus_obj(getStatusById((int)map.get("status")).get());
        PurchaseOrderMain purchaseOrderMain=new PurchaseOrderMain((String)map.get("purchase_order_id"), pid, fetched3.getUnit_price());
		purchaseOrderMain.setCreated_by((String)map2.get("created_by"));
		purchaseOrderMain.setCreated_on((Timestamp)map2.get("created_on"));
		purchaseOrderMain.setPurchaseOrderHead(purchaseOrderHead);
		purchaseOrderMain.setUpdated_by(updatedBy);
		purchaseOrderMain.setUpdated_on(timestamp);
		purchaseOrderMainRepo.deleteById(((BigInteger) map2.get("purchase_item_id")).longValue());
        purchaseOrderHeadRepo.deleteById(((BigInteger) map.get("id")).longValue());
        purchaseOrderHeadRepo.save(purchaseOrderHead);
        purchaseOrderMainRepo.save(purchaseOrderMain);
		return "Updated Purchase Order with Purchase Order ID: "+id;
		
	}
	
	public String deletePO(String id)
	{
		Map<String, Object> map= purchaseOrderHeadRepo.findByPO_Id(id).get(0);
		if("closed".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This purchase order with Id: "+id+" is already closed and hence cannot be deleted!";
		if("approved".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This purchase order with Id: "+id+" is already approved and hence cannot be modified or deleted or approved again!";
		Map<String, Object> map2= purchaseOrderMainRepo.findByPO_Id(id).get(0);
		purchaseOrderMainRepo.deleteById(((BigInteger) map2.get("purchase_item_id")).longValue());
        purchaseOrderHeadRepo.deleteById(((BigInteger) map.get("id")).longValue());
        return "Deleted Purchase Order with Purchase Order ID: "+id;
	}
	
	public String closePO(String id)
	{
		Map<String, Object> map= purchaseOrderHeadRepo.findByPO_Id(id).get(0);
		if("closed".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This purchase order with Id: "+id+" is already closed!";
		if(!"approved".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This purchase order with Id: "+id+" is not approved yet and hence cannot be closed!";
		Map<String, Object> map2= purchaseOrderMainRepo.findByPO_Id(id).get(0);
		Status status=statusRepo.getStatusId("closed");
		BigInteger val=invoiceHeadRepo.getReceivedSum(id,status.getId());
		if((map.get("total_quantity")+"").equals(val+""))
			return "According to purchase order of Id: "+id+" the order is placed for qunatity: "+(Long)map.get("total_quantity")+" But the Invoices show that we did not receive all items (only "+val+" ) (or) all the invoices are not yet closed, hence this Purchase order cannot be closed";
		PurchaseOrderHead purchaseOrderHead=new PurchaseOrderHead();
		purchaseOrderHead.setCreated_by((String)map.get("created_by"));
		purchaseOrderHead.setCreated_on((Timestamp)map.get("created_on"));
		purchaseOrderHead.setTotal_price((Double)map.get("total_price"));
		purchaseOrderHead.setPurchase_order_id(id);
		purchaseOrderHead.setStatus(status.getId());
		purchaseOrderHead.setStatus_obj(getStatusById(purchaseOrderHead.getStatus()).get());
        purchaseOrderHead.setUpdated_by((String)map.get("updated_by"));
        purchaseOrderHead.setUpdated_on((Timestamp)map.get("updated_on"));
        purchaseOrderHead.setTotal_quantity(Long.parseLong(map.get("total_quantity")+""));
        purchaseOrderHead.setVendor_id((String)map.get("vendor_id"));
        PurchaseOrderMain purchaseOrderMain=new PurchaseOrderMain();
        purchaseOrderMain.setPurchase_order_id((String)map2.get("purchase_order_id"));
        purchaseOrderMain.setProduct_id((String)map2.get("product_id"));
        purchaseOrderMain.setUnit_price((Double)map2.get("unit_price"));
		purchaseOrderMain.setCreated_by((String)map2.get("created_by"));
		purchaseOrderMain.setCreated_on((Timestamp)map2.get("created_on"));
		purchaseOrderMain.setPurchaseOrderHead(purchaseOrderHead);
		purchaseOrderMain.setUpdated_by((String)map2.get("updated_by"));
		purchaseOrderMain.setUpdated_on((Timestamp)map2.get("updated_on"));	
		purchaseOrderMainRepo.deleteById(((BigInteger) map2.get("purchase_item_id")).longValue());
        purchaseOrderHeadRepo.deleteById(((BigInteger) map.get("id")).longValue());
        purchaseOrderHeadRepo.save(purchaseOrderHead);
        purchaseOrderMainRepo.save(purchaseOrderMain);
		return "Closed Purchase Order with Purchase Order ID: "+id;	
	}
	
	
	// Invoice --------------------------------------------------------------------------------------------
	
	public String addInvoice(InvoiceAdding invoiceAdding, String createdBy)
	{
		Map<String, Object> map= purchaseOrderHeadRepo.findByPO_Id(invoiceAdding.getPurchaseOId()).get(0);
		if(map==null)
			return "Given Purchase Order id: "+invoiceAdding.getPurchaseOId()+" does not exist!";
		if(!"approved".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This purchase order with Id: "+invoiceAdding.getPurchaseOId()+" is not approved yet and hence Invoice cannot be created for it!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		InvoiceHead invoiceHead=new InvoiceHead(invoiceAdding.getPurchaseOId(), invoiceAdding.getTotalQuantityReceived(), invoiceAdding.getReceivedOn());
		invoiceHead.setCreated_by(createdBy);
		invoiceHead.setCreated_on(timestamp);
		invoiceHead.setTotal_price(invoiceAdding.getTotalQuantityReceived() * invoiceAdding.getUnitPrice());
		invoiceIdG++;
        String invId="INV"+invoiceAdding.getPurchaseOId()+(""+timestamp+"").substring(11,19)+"LKT"+invoiceIdG+"";
        invoiceHead.setInvoice_id(invId);
        invoiceHead.setStatus(39);
        invoiceHead.setStatus_obj(getStatusById(invoiceHead.getStatus()).get());
		invoiceHeadRepo.save(invoiceHead);
		InvoiceMain invoiceMain=new InvoiceMain(invId, invoiceAdding.getUnitPrice(), invoiceAdding.getProductId());
		invoiceMain.setCreated_by(createdBy);
		invoiceMain.setCreated_on(timestamp);
		invoiceMain.setInvoiceHead(invoiceHead);
		invoiceMainRepo.save(invoiceMain);
		return "New Invoice Generated successfully! Id: '"+invoiceHead.getId()+"' , Please note down the Invoice ID: '"+invId+"' , for Purchase Order ID: '"+invoiceAdding.getPurchaseOId()+"'";
	}
	
	public List<Object> getInvoices()
	{
		List<Object> obj=new ArrayList<Object>();
		obj.addAll(invoiceHeadRepo.findAlls());
		obj.addAll(invoiceMainRepo.findAlls());
		return obj;
	}
	
	public String deleteAllInvoices()
	{
		invoiceHeadRepo.deleteAll();
		invoiceMainRepo.deleteAll();
		return "All Invoices deleted";
	}
		
	public List<Object> getInvByInvId(String id)
	{
		List<Object> obj=new ArrayList<Object>();
		obj.add(invoiceHeadRepo.findByInv_Id(id));
		obj.add(invoiceMainRepo.findByInv_Id(id));
		return obj;
	}
	
	public List<Map<String, Object>> getInvByPOId(String id)
	{
		return invoiceHeadRepo.findInvByPOId(id);
	}
	
	public List<Map<String, Object>> getInvByPId(String id)
	{
		return invoiceMainRepo.findInvByPId(id);
	}
	
	public String updateInv(String updatedBy, String id, String poid, Long totQntyR, String receivedOn, String pid, Double up , int val)
	{
		Product fetched3=gPByPId(pid);
		if(fetched3==null)
			return "Given product id: "+pid+" does not exist!";
		Map<String, Object> map= purchaseOrderHeadRepo.findByPO_Id(poid).get(0);
		if(map==null)
			return "Given Purchase Order id: "+poid+" does not exist!";
		Map<String, Object> map2= invoiceHeadRepo.findByInv_Id(id).get(0);
		if("closed".equals(getStatusById((int)map2.get("status")).get().getStatus()))
			return "This Invoice with Id: "+id+" is already closed and hence cannot be modified!";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Map<String, Object> map3= invoiceMainRepo.findByInv_Id(id).get(0);
		InvoiceHead invoiceHead=new InvoiceHead(poid , totQntyR, receivedOn);
		invoiceHead.setInvoice_id((String)map2.get("invoice_id"));
		invoiceHead.setCreated_by((String)map2.get("created_by"));
		invoiceHead.setCreated_on((Timestamp)map2.get("created_on"));
		invoiceHead.setTotal_price(totQntyR * up);
		if(val==0)
		{
			invoiceHead.setStatus((int)map2.get("status"));
			invoiceHead.setStatus_obj(getStatusById(invoiceHead.getStatus()).get());
		}
		else
		{
			invoiceHead.setStatus(val);
			invoiceHead.setStatus_obj(getStatusById(val).get());
		}
        invoiceHead.setUpdated_by(updatedBy);
        invoiceHead.setUpdated_on(timestamp);
        invoiceHead.setStatus_obj(getStatusById((int)map2.get("status")).get());
        InvoiceMain invoiceMain=new InvoiceMain(id, up, pid);
		invoiceMain.setCreated_by((String)map3.get("created_by"));
		invoiceMain.setCreated_on((Timestamp)map3.get("created_on"));
		invoiceMain.setInvoiceHead(invoiceHead);
		invoiceMain.setUpdated_by(updatedBy);
		invoiceMain.setUpdated_on(timestamp);
		invoiceMainRepo.deleteById(((BigInteger) map3.get("invoice_item_id")).longValue());
        invoiceHeadRepo.deleteById(((BigInteger) map2.get("id")).longValue());
        invoiceHeadRepo.save(invoiceHead);
        invoiceMainRepo.save(invoiceMain);
		return "Updated Invoice with Invoice ID: "+id;
		
	}
	
	public String deleteInv(String id)
	{
		Map<String, Object> map= invoiceHeadRepo.findByInv_Id(id).get(0);
		if("closed".equals(getStatusById((int)map.get("status")).get().getStatus()))
			return "This invoice with Id: "+id+" is already closed and hence cannot be deleted!";
		Map<String, Object> map2= invoiceMainRepo.findByInv_Id(id).get(0);
		invoiceMainRepo.deleteById(((BigInteger) map2.get("invoice_item_id")).longValue());
        invoiceHeadRepo.deleteById(((BigInteger) map.get("id")).longValue());
        return "Deleted Invoice with Invoice ID: "+id;
	}
	
	
	
}
