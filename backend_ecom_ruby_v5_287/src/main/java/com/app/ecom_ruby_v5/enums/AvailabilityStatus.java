package com.app.ecom_ruby_v5.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum AvailabilityStatus{
	    InStore,
	    InDepot,
	    InRepository,
	    OutOfStock; 
    public int value(AvailabilityStatus availabilityStatus) {
        return availabilityStatus.ordinal();
    }
    public static AvailabilityStatus getAvailabilityStatus(int ordinal) {
        for(AvailabilityStatus availabilityStatus : AvailabilityStatus.values())
                if(availabilityStatus.ordinal() == ordinal)
                        return availabilityStatus;
        return null;
    }
}


