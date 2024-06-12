package com.app.ecom_ruby_v5.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

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

@Entity(name = "ProductVendors")
@Table(schema = "\"ecom_ruby_v5\"", name = "\"ProductVendors\"")
@Data
public class ProductVendors{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"Product_id\"")
	private Integer product_id;

    
    @Column(name = "\"VId\"")
    private Integer vId;
 
}