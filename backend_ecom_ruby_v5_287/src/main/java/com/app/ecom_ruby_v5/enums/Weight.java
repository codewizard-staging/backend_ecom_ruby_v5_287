package com.app.ecom_ruby_v5.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Weight{
	    Milligram,
	    Gram,
	    Kilogram,
	    Ton,
	    Pound,
	    Ounce; 
    public int value(Weight weight) {
        return weight.ordinal();
    }
    public static Weight getWeight(int ordinal) {
        for(Weight weight : Weight.values())
                if(weight.ordinal() == ordinal)
                        return weight;
        return null;
    }
}


