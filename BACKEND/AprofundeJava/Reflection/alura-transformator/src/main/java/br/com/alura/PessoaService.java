package br.com.alura;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.refl.Transformator;

public class PessoaService {

	public PessoaDTO list() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		Pessoa pessoa = new PessoaRepository().list();
		PessoaDTO pessoaDTO = new Transformator().transform(pessoa);
		
		return pessoaDTO;
	}
	
	/*Não corre o risco de devolver o id pra o usuario final.*/
	/*Fazer deste modo acaba sendo custoso e complexo, porque ao inves de estar desenvolvendo a classe de negócio, estamos fazendo funções
	 * de transformação. Seria ideial que existisse uma função/biblioteca onde desse pra passar qualquer classe como parametro e retornasse seu DTO*/
}
