package com.app.ecom_ruby_v5.model.complex;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class Address {
  
	
  @Column(name = "\"HouseNumber\"", nullable = true)
  private String houseNumber;
	
  @Column(name = "\"Street\"", nullable = true)
  private String street;
	
  @Column(name = "\"Area\"", nullable = true)
  private String area;
	
  @Column(name = "\"AddressLine2\"", nullable = true)
  private String addressLine2;
	
  @Column(name = "\"Pincode\"", nullable = true)
  private Integer pincode;
	
  @Column(name = "\"State\"", nullable = true)
  private String state;
	
  @Column(name = "\"Country\"", nullable = true)
  private String country;
}
