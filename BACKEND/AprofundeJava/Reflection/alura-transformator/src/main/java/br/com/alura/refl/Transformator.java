package br.com.alura.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {
	
	public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{
		/* i - input; o - output*/
		Class<?> source = input.getClass();
		Class<?> target = Class.forName(source.getName() + "DTO");
		
		O targetClass = (O) target.getDeclaredConstructor().newInstance();
		
		Field[] sourceFields =source.getDeclaredFields();
		Field[] targetFields = target.getDeclaredFields();
		
		Arrays.stream(sourceFields).forEach(sourceField -> 
				Arrays.stream(targetFields).forEach(targetField -> {
					validate(sourceField, targetField);	
					
					try {
						targetField.set(targetClass, sourceField.get(input));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}));
		
		return targetClass;
	}
	
	public void validate(Field sourceField, Field targetField) {
		if(sourceField.getName().equals(targetField.getName()) && sourceField.getType().equals(targetField.getType())) {
			sourceField.setAccessible(true);
			targetField.setAccessible(true); //permite que campos privados possam ser acessados. quebra o encapsulamento.
			
		}
	}
}
