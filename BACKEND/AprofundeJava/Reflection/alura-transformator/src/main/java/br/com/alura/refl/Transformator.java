package br.com.alura.refl;

import java.lang.reflect.InvocationTargetException;

public class Transformator {
	
	public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{
		/* i - input; o - output*/
		Class<?> source = input.getClass();
		Class<?> target = source.forName(source.getClass() + "DTO");
		
		O targetClass = (O) target.getDeclaredConstructor().newInstance();
		
		return targetClass;
	}
}

/*Outra API: Generics, podemos receber qualquer coisa, sem necessidade de especificar tipo*/