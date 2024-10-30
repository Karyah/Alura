package br.com.alura.refl;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.alura.Pessoa;

public class ObjectToJsonTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa pessoa = new Pessoa(1,"João", "12345");
		ObjectToJson objectToJson = new ObjectToJson();
		
		try {
			System.out.println( objectToJson.transform(pessoa));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
