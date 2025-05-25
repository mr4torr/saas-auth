package io.github.mr4torr.system.infrastructure.auth.persistence.converters;

import io.github.mr4torr.system.core.auth.valueobjects.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class EmailAttributeConverter implements AttributeConverter<Email, String> {

    @Override
    public String convertToDatabaseColumn(Email email) {
        return (email != null) ? email.toString() : null;
    }

    @Override
    public Email convertToEntityAttribute(String emailValue) {
        if (emailValue == null || emailValue.isEmpty()) {
            return null;
        }
        return new Email(emailValue);
    }
}
