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

@Entity(name = "PComponent")
@Table(name = "\"PComponent\"", schema =  "\"ecom_ruby_v5\"")
@Data
                        
public class PComponent {
	public PComponent () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"CompId\"", nullable = true )
  private Integer compId;
	  
  @Column(name = "\"Name\"", nullable = true )
  private String name;
  
	  
  @Column(name = "\"Description\"", nullable = true )
  private String description;
  
	  
  @Column(name = "\"Color\"", nullable = true )
  private String color;
  
	  
  @Column(name = "\"Size\"", nullable = true )
  private String size;
  
	  
  @Column(name = "\"Manufacturer\"", nullable = true )
  private String manufacturer;
  
	  
  @Embedded
  @Column(name = "\"Address\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "houseNumber", column = @Column(name = "\"Address_HouseNumber\"")) ,
            	@AttributeOverride(name = "street", column = @Column(name = "\"Address_Street\"")) ,
            	@AttributeOverride(name = "area", column = @Column(name = "\"Address_Area\"")) ,
            	@AttributeOverride(name = "addressLine2", column = @Column(name = "\"Address_AddressLine2\"")) ,
            	@AttributeOverride(name = "pincode", column = @Column(name = "\"Address_Pincode\"")) ,
            	@AttributeOverride(name = "state", column = @Column(name = "\"Address_State\"")) ,
            	@AttributeOverride(name = "country", column = @Column(name = "\"Address_Country\""))  }) 
  private Address address;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "PComponent [" 
  + "CompId= " + compId  + ", " 
  + "Name= " + name  + ", " 
  + "Description= " + description  + ", " 
  + "Color= " + color  + ", " 
  + "Size= " + size  + ", " 
  + "Manufacturer= " + manufacturer  + ", " 
  + "Address= " + address 
 + "]";
	}
	
}