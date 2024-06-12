package com.app.ecom_ruby_v5.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum Size{
	    VerySmall,
	    Small,
	    Medium,
	    Large,
	    VeryLarge; 
    public int value(Size size) {
        return size.ordinal();
    }
    public static Size getSize(int ordinal) {
        for(Size size : Size.values())
                if(size.ordinal() == ordinal)
                        return size;
        return null;
    }
}


