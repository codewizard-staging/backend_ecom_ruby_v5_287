package com.app.ecom_ruby_v5.function;

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
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;
import com.app.ecom_ruby_v5.repository.OrderRepository;
import com.app.ecom_ruby_v5.repository.UserRepository;
import com.app.ecom_ruby_v5.repository.ProductTypeRepository;
import com.app.ecom_ruby_v5.repository.ProductRepository;
import com.app.ecom_ruby_v5.repository.ProductPriceRepository;
import com.app.ecom_ruby_v5.repository.VendorRepository;
import com.app.ecom_ruby_v5.repository.ShipmentItemRepository;
import com.app.ecom_ruby_v5.repository.DocumentRepository;
import com.app.ecom_ruby_v5.repository.OtherDetailsRepository;
import com.app.ecom_ruby_v5.repository.OrderItemRepository;
import com.app.ecom_ruby_v5.repository.PComponentRepository;
import com.app.ecom_ruby_v5.repository.SupplierRepository;
import com.app.ecom_ruby_v5.repository.ProductOnBoardingRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class JavaFunctions implements ODataFunction {


    
    
}
   
