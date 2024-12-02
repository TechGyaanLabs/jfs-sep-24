package com.careerit.iplstats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ObjectConvertor {

    private final ObjectMapper objectMapper;

    public <T> T toDomain(Object obj, Class<T> clazz) {
        return convert(obj, clazz);
    }

    public <T> T toDomain(Object obj, TypeReference<T> typeReference) {
        return convert(obj, typeReference);
    }

    public <T> T toDto(Object obj, Class<T> clazz) {
        return convert(obj, clazz);
    }

    public <T> T toDto(Object obj, TypeReference<T> typeReference) {
        return convert(obj, typeReference);
    }

    private <T> T convert(Object obj, Object type) {
        try {
            if (type instanceof Class) {
                return objectMapper.convertValue(obj, (Class<T>) type);
            } else {
                return objectMapper.convertValue(obj, (TypeReference<T>) type);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while converting object", e);
        }
    }
}