package com.app.ecom_ruby_v5.converter;

import com.app.ecom_ruby_v5.enums.Weight;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class WeightConverter implements AttributeConverter<Weight, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Weight weight) {
        return weight != null ? weight.ordinal() : null;
    }

    @Override
    public Weight convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return Weight.getWeight(dbData);
    }
}
