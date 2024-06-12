package com.app.ecom_ruby_v5.nameBuilder;


import com.sap.olingo.jpa.metadata.core.edm.mapper.api.JPAEdmNameBuilder;
import com.sap.olingo.jpa.metadata.core.edm.mapper.impl.JPADefaultEdmNameBuilder;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EmbeddableType;
import javax.persistence.metamodel.EntityType;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Date;

public class APINameBuilder implements JPAEdmNameBuilder {
    private final JPAEdmNameBuilder defaultNameBuilder;

    public APINameBuilder(final String punit) {
        defaultNameBuilder = new JPADefaultEdmNameBuilder(punit);
    }

    @Override
    public String buildComplexTypeName(final EmbeddableType<?> jpaEmbeddedType) {
        return defaultNameBuilder.buildComplexTypeName(jpaEmbeddedType);
    }

    @Override
    public String buildContainerName() {
        return defaultNameBuilder.buildContainerName();
    }

    @Override
	public String buildEntitySetName(final String entityTypeName) {
    	String eSetName = null;
    	
    	eSetName = "Order".equals(entityTypeName) ? "Orders" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "User".equals(entityTypeName) ? "Users" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ProductType".equals(entityTypeName) ? "ProductTypes" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Product".equals(entityTypeName) ? "Products" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ProductPrice".equals(entityTypeName) ? "ProductPrices" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Vendor".equals(entityTypeName) ? "Vendors" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ShipmentItem".equals(entityTypeName) ? "ShipmentItems" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Document".equals(entityTypeName) ? "Documents" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "OtherDetails".equals(entityTypeName) ? "OtherDetails" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "OrderItem".equals(entityTypeName) ? "OrderItems" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "PComponent".equals(entityTypeName) ? "PComponents" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "Supplier".equals(entityTypeName) ? "Suppliers" : defaultNameBuilder.buildEntitySetName(entityTypeName);
    	eSetName = "ProductOnBoarding".equals(entityTypeName) ? "ProductOnBoardings" : defaultNameBuilder.buildEntitySetName(entityTypeName);
        return eSetName;
    }

    @Override
    public String buildEntityTypeName(final EntityType<?> jpaEntityType) {
        return defaultNameBuilder.buildEntityTypeName(jpaEntityType);
    }

    @Override
    public String buildEnumerationTypeName(final Class<? extends Enum<?>> javaEnum) {
        return defaultNameBuilder.buildEnumerationTypeName(javaEnum);
    }

    @Override
    public String buildNaviPropertyName(final Attribute<?, ?> jpaAttribute) {
        return defaultNameBuilder.buildNaviPropertyName(jpaAttribute);
    }

    @Override
    public String buildOperationName(final String internalOperationName) {
        return defaultNameBuilder.buildOperationName(internalOperationName);
    }

    @Override
    public String buildPropertyName(final String jpaAttributeName) {
        return defaultNameBuilder.buildPropertyName(jpaAttributeName);
    }

    @Override
    public String getNamespace() {
        return defaultNameBuilder.getNamespace();
    }
}
