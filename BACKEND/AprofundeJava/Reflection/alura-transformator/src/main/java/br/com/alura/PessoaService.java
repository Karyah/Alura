package br.com.alura;

public class PessoaService {

	public PessoaDTO list() {
		Pessoa pessoa = new PessoaRepository().list();
		PessoaDTO pessoaDTO =  new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
		return pessoaDTO;
	}
	
	/*Não corre o risco de devolver o id pra o usuario final.*/
	/*Fazer deste modo acaba sendo custoso e complexo, porque ao inves de estar desenvolvendo a classe de negócio, estamos fazendo funções
	 * de transformação. Seria ideial que existisse uma função/biblioteca onde desse pra passar qualquer classe como parametro e retornasse seu DTO*/
}
