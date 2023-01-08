package Util;

import java.io.IOException;
import java.util.List;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IntegerListConverter implements AttributeConverter<List<Integer>, String> {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(List<Integer> attribute) {
		try {
			return objectMapper.writeValueAsString(attribute);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	@Override
	public List<Integer> convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, new TypeReference<List<Integer>>() {
			});
		} catch (IOException ex) {
			return null;
		}
	}
}