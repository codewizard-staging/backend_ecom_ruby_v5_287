package com.app.ecom_ruby_v5.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.app.ecom_ruby_v5.model.User;
import com.app.ecom_ruby_v5.model.ShipmentItem;
import com.app.ecom_ruby_v5.model.PComponent;
import com.app.ecom_ruby_v5.model.OrderItem;
import com.app.ecom_ruby_v5.model.Document;
import com.app.ecom_ruby_v5.model.ProductOnBoarding;
import com.app.ecom_ruby_v5.model.ProductPrice;
import com.app.ecom_ruby_v5.model.Order;
import com.app.ecom_ruby_v5.model.Vendor;
import com.app.ecom_ruby_v5.model.Product;
import com.app.ecom_ruby_v5.model.ProductType;
import com.app.ecom_ruby_v5.model.OtherDetails;
import com.app.ecom_ruby_v5.model.Supplier;
import com.app.ecom_ruby_v5.model.complex.Address;
import com.app.ecom_ruby_v5.enums.Size;
import com.app.ecom_ruby_v5.enums.OnBoardingStatus;
import com.app.ecom_ruby_v5.enums.AvailabilityStatus;
import com.app.ecom_ruby_v5.enums.Weight;
import com.app.ecom_ruby_v5.converter.OnBoardingStatusConverter;
import com.app.ecom_ruby_v5.converter.SizeConverter;
import com.app.ecom_ruby_v5.converter.WeightConverter;
import com.app.ecom_ruby_v5.converter.AvailabilityStatusConverter;
import com.app.ecom_ruby_v5.converter.DurationConverter;
import com.app.ecom_ruby_v5.converter.UUIDToByteConverter;
import com.app.ecom_ruby_v5.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Order")
@Table(name = "\"Order\"", schema =  "\"ecom_ruby_v5\"")
@Data
                        
public class Order {
	public Order () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"OrderId\"", nullable = true )
  private Integer orderId;
	  
  @Column(name = "\"Date\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date date;  
  
	  
  @Column(name = "\"CompanyCode\"", nullable = true )
  private String companyCode;
  
	  
  @Column(name = "\"PoCategory\"", nullable = true )
  private String poCategory;
  
	  
  @Column(name = "\"VendorAccountNumber\"", nullable = true )
  private String vendorAccountNumber;
  
	  
  @Column(name = "\"StartDateOfValidity\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date startDateOfValidity;  
  
	  
  @Column(name = "\"EndDateOfValidity\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date endDateOfValidity;  
  
	  
  @Column(name = "\"VendorTelephoneNumber\"", nullable = true )
  private Long vendorTelephoneNumber;
  
	  
  @Column(name = "\"ShippingType\"", nullable = true )
  private String shippingType;
  
	  
  @Column(name = "\"DestinationCityCode\"", nullable = true )
  private Integer destinationCityCode;
  
	  
  @Column(name = "\"IsApproved\"", nullable = true )
  private Boolean isApproved;
  
	  
  @Embedded
  @Column(name = "\"ShippingAddress\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "houseNumber", column = @Column(name = "\"ShippingAddress_HouseNumber\"")) ,
            	@AttributeOverride(name = "street", column = @Column(name = "\"ShippingAddress_Street\"")) ,
            	@AttributeOverride(name = "area", column = @Column(name = "\"ShippingAddress_Area\"")) ,
            	@AttributeOverride(name = "addressLine2", column = @Column(name = "\"ShippingAddress_AddressLine2\"")) ,
            	@AttributeOverride(name = "pincode", column = @Column(name = "\"ShippingAddress_Pincode\"")) ,
            	@AttributeOverride(name = "state", column = @Column(name = "\"ShippingAddress_State\"")) ,
            	@AttributeOverride(name = "country", column = @Column(name = "\"ShippingAddress_Country\""))  }) 
  private Address shippingAddress;
  
	  
  @Column(name = "\"OrderPrice\"", nullable = true )
  private Double orderPrice;
  
	  
  @Column(name = "\"TotalAmount\"", nullable = true )
  private Double totalAmount;
  
	  
  @Column(name = "\"DeliveryCharges\"", nullable = true )
  private Double deliveryCharges;
  
	  
  @Column(name = "\"SameAsServiceAddress\"", nullable = true )
  private Boolean sameAsServiceAddress;
  
	  
  @Column(name = "\"Attribute3\"", nullable = true )
  private String attribute3;
  
	  
  @Column(name = "\"Attribute4\"", nullable = true )
  private Boolean attribute4;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"OrderOUser\"", referencedColumnName = "\"UserName\"", insertable = false, updatable = false)
	private User oUser;
	
	@Column(name = "\"OrderOUser\"")
	private String orderOUser;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"OrderItems\"",
            joinColumns = @JoinColumn( name="\"OrderId\""),
            inverseJoinColumns = @JoinColumn( name="\"Order_item_id\""), schema = "\"ecom_ruby_v5\"")
private List<OrderItem> items = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Order [" 
  + "OrderId= " + orderId  + ", " 
  + "Date= " + date  + ", " 
  + "CompanyCode= " + companyCode  + ", " 
  + "PoCategory= " + poCategory  + ", " 
  + "VendorAccountNumber= " + vendorAccountNumber  + ", " 
  + "StartDateOfValidity= " + startDateOfValidity  + ", " 
  + "EndDateOfValidity= " + endDateOfValidity  + ", " 
  + "VendorTelephoneNumber= " + vendorTelephoneNumber  + ", " 
  + "ShippingType= " + shippingType  + ", " 
  + "DestinationCityCode= " + destinationCityCode  + ", " 
  + "IsApproved= " + isApproved  + ", " 
  + "ShippingAddress= " + shippingAddress  + ", " 
  + "OrderPrice= " + orderPrice  + ", " 
  + "TotalAmount= " + totalAmount  + ", " 
  + "DeliveryCharges= " + deliveryCharges  + ", " 
  + "SameAsServiceAddress= " + sameAsServiceAddress  + ", " 
  + "Attribute3= " + attribute3  + ", " 
  + "Attribute4= " + attribute4 
 + "]";
	}
	
}