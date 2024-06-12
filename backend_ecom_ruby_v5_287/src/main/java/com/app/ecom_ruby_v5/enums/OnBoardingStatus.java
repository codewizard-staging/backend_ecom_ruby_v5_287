package com.app.ecom_ruby_v5.enums;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmEnumeration;

@EdmEnumeration	  
public enum OnBoardingStatus{
	    NotStarted,
	    Started,
	    Pending,
	    Completed; 
    public int value(OnBoardingStatus onBoardingStatus) {
        return onBoardingStatus.ordinal();
    }
    public static OnBoardingStatus getOnBoardingStatus(int ordinal) {
        for(OnBoardingStatus onBoardingStatus : OnBoardingStatus.values())
                if(onBoardingStatus.ordinal() == ordinal)
                        return onBoardingStatus;
        return null;
    }
}


