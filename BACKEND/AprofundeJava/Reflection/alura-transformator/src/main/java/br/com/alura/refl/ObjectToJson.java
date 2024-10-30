package br.com.alura.refl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectToJson {
	
	public String transform(Object object) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		Map<String, Object> mapper = new HashMap<>();
		
		Class<?> classToBeTransformed =  object.getClass();
		Arrays.stream(classToBeTransformed.getDeclaredFields()).toList().forEach( 
			
			field -> {			
				field.setAccessible(true);
				String key = field.getName();
				Object value = null;
				
				try {
					value = field.get(object);
				}catch(IllegalAccessException e) {
					e.printStackTrace();
				}
				
				mapper.put(key,value);
			});
		
		return objectMapper.writeValueAsString(mapper);
		
	}
	
}
