package com.app.ecom_ruby_v5.converter;

import com.app.ecom_ruby_v5.enums.AvailabilityStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class AvailabilityStatusConverter implements AttributeConverter<AvailabilityStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AvailabilityStatus availabilityStatus) {
        return availabilityStatus != null ? availabilityStatus.ordinal() : null;
    }

    @Override
    public AvailabilityStatus convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return AvailabilityStatus.getAvailabilityStatus(dbData);
    }
}
