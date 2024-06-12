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
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmAction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataAction;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Component
public class JavaActions implements ODataAction {
    private final EntityManager entityManager;

    public JavaActions(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	
	
}
  