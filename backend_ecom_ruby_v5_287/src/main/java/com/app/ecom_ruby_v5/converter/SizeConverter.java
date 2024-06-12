package com.app.ecom_ruby_v5.converter;

import com.app.ecom_ruby_v5.enums.Size;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class SizeConverter implements AttributeConverter<Size, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Size size) {
        return size != null ? size.ordinal() : null;
    }

    @Override
    public Size convertToEntityAttribute(Integer dbData) {
      if (dbData == null) {
        return null;
      }
		  return Size.getSize(dbData);
    }
}
