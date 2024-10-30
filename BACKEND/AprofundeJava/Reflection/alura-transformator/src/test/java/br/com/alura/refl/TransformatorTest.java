package br.com.alura.refl;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import br.com.alura.Endereco;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;

public class TransformatorTest {

	Pessoa pessoa = new Pessoa(1,"João", "1234");
	Pessoa pessoaSemCpf =  new Pessoa("João");
	Endereco endereco = new Endereco("10", 10);
	
	@Test
	public void shouldTransform() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		
		Transformator transformator = new Transformator();
		PessoaDTO pessoaDTO = transformator.transform(pessoa);
		
		Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
		Assertions.assertEquals(pessoa.getNome(),pessoaDTO.getNome());
		Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
	}
	
	@Test
	public void shouldNotTransform() {
		Assertions.assertThrows(ClassNotFoundException.class, ()->{
			Transformator transformator = new Transformator();
			transformator.transform(endereco);
		});
	}
	
	@Test
	public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		Transformator transformator = new Transformator();
		PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);
		
		Assertions.assertEquals(pessoaSemCpf.getNome(),pessoaDTOSemCpf.getNome());
		Assertions.assertNull(pessoaDTOSemCpf.getCpf());
	}
}
