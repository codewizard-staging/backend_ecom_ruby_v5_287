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

@Entity(name = "Product")
@Table(name = "\"Product\"", schema =  "\"ecom_ruby_v5\"")
@Data
                        
public class Product {
	public Product () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"Product_id\"", nullable = true )
  private Integer product_id;
	  
  @Column(name = "\"Return_merchandise_authorization_nr\"", nullable = true )
  private String return_merchandise_authorization_nr;
  
	  
  @Column(name = "\"Name\"", nullable = true )
  private String name;
  
	  
  @Column(name = "\"Color\"", nullable = true )
  private String color;
  
	  
  @Column(name = "\"Size\"", nullable = true )
  private Integer size;
  
	  
  @Column(name = "\"Product_description\"", nullable = true )
  private String product_description;
  
	  
  @Column(name = "\"Manufacturer\"", nullable = true )
  private String manufacturer;
  
	  
  @Column(name = "\"Weight\"", nullable = true )
  private Float weight;
  
	  
  @Column(name = "\"UnitOfMeasurement\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = WeightConverter.class)
  private Weight unitOfMeasurement;
  
	  
  @Embedded
  @Column(name = "\"VendorAddress\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "houseNumber", column = @Column(name = "\"VendorAddress_HouseNumber\"")) ,
            	@AttributeOverride(name = "street", column = @Column(name = "\"VendorAddress_Street\"")) ,
            	@AttributeOverride(name = "area", column = @Column(name = "\"VendorAddress_Area\"")) ,
            	@AttributeOverride(name = "addressLine2", column = @Column(name = "\"VendorAddress_AddressLine2\"")) ,
            	@AttributeOverride(name = "pincode", column = @Column(name = "\"VendorAddress_Pincode\"")) ,
            	@AttributeOverride(name = "state", column = @Column(name = "\"VendorAddress_State\"")) ,
            	@AttributeOverride(name = "country", column = @Column(name = "\"VendorAddress_Country\""))  }) 
  private Address vendorAddress;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"ProductPType\"", referencedColumnName = "\"PtId\"", insertable = false, updatable = false)
	private ProductType pType;
	
	@Column(name = "\"ProductPType\"")
	private Integer productPType;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"ProductODetails\"", referencedColumnName = "\"OtherDetailsId\"", insertable = false, updatable = false)
	private OtherDetails oDetails;
	
	@Column(name = "\"ProductODetails\"")
	private Integer productODetails;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"ProductBuyingPrice\"", referencedColumnName = "\"PpId\"", insertable = false, updatable = false)
	private ProductPrice buyingPrice;
	
	@Column(name = "\"ProductBuyingPrice\"")
	private Integer productBuyingPrice;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"ProductMainImage\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document mainImage;
	
	@Column(name = "\"ProductMainImage\"")
	private Integer productMainImage;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"ProductProductVendor\"", referencedColumnName = "\"SId\"", insertable = false, updatable = false)
	private Supplier productVendor;
	
	@Column(name = "\"ProductProductVendor\"")
	private Integer productProductVendor;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"ProductSellingPrice\"", referencedColumnName = "\"PpId\"", insertable = false, updatable = false)
	private ProductPrice sellingPrice;
	
	@Column(name = "\"ProductSellingPrice\"")
	private Integer productSellingPrice;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"ProductOtherImages\"",
            joinColumns = @JoinColumn( name="\"Product_id\""),
            inverseJoinColumns = @JoinColumn( name="\"DocId\""), schema = "\"ecom_ruby_v5\"")
private List<Document> otherImages = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"ProductPComponents\"",
            joinColumns = @JoinColumn( name="\"Product_id\""),
            inverseJoinColumns = @JoinColumn( name="\"CompId\""), schema = "\"ecom_ruby_v5\"")
private List<PComponent> pComponents = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"ProductVendors\"",
            joinColumns = @JoinColumn( name="\"Product_id\""),
            inverseJoinColumns = @JoinColumn( name="\"VId\""), schema = "\"ecom_ruby_v5\"")
private List<Vendor> vendors = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Product [" 
  + "Product_id= " + product_id  + ", " 
  + "Return_merchandise_authorization_nr= " + return_merchandise_authorization_nr  + ", " 
  + "Name= " + name  + ", " 
  + "Color= " + color  + ", " 
  + "Size= " + size  + ", " 
  + "Product_description= " + product_description  + ", " 
  + "Manufacturer= " + manufacturer  + ", " 
  + "Weight= " + weight  + ", " 
  + "UnitOfMeasurement= " + unitOfMeasurement  + ", " 
  + "VendorAddress= " + vendorAddress 
 + "]";
	}
	
}