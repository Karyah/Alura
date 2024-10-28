# Curso sobre Reflections

## DTO
    - É uma boa prática utilizar DTOs para devolver apenas os campos necessários para a requisição, sem que o controller e o usuário final consigam acessar o objeto bruto e outros campos não necessários.

Não é uma boa prática retornar a entidade, o objeto puro que contém as infos do banco de dados. Não é bom trafegar entre essas camadas os objetos brutos, e sim usar os DTOs, que retornam e recebem apenas os campos necessários para realizar a requisição, protege o objeto de domínio.

como ficaria o código:

    public class PessoaService {

    public PessoaDTO list() {
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO pessoaDTO =  new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
        return pessoaDTO;
    }

Fazer deste modo acaba sendo custoso e complexo, porque ao inves de estar desenvolvendo a classe de negócio, estamos fazendo funções de transformação. Seria ideial que existisse uma função/biblioteca onde desse pra passar qualquer classe como parametro e retornasse seu DTO. E é isso que a API Reflections faz.

## Java Reflections API

_Reflection enables Java code to discover information about the fields, methods and constructors of loaded classes, and to use reflected fields, methods, and constructors to operate on their underlying counterparts, within security restrictions. The API accommodates applications that need access to either the public members of a target object (based on its runtime class) or the members declared by a given class. It also allows programs to suppress default reflective access control._

Em suma, nos habilita a transformar classes puras em classes DTO de forma muito mais abstrata.

Com o reflection, é possível manipular a estrutura de um objeto, como classes, métodos, atributos, mesmo que você "não saiba" de antemão quais são esses detalhes.

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException{
            /* i - input; o - output*/
            Class<?> source = input.getClass();
            Class<?> target = Class.forName(source + "DTO");

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

O uso de refletions reflete também em impactos negativos para o desempenho. Devido aos loopings necessários para verificar os campos do target e do source, temos uma complexidade de tempo de O(n2) - n quadrático. Ou seja, temos um grande impacto na performance, e o uso de refletions deve ser muito bem pensado e planejado, para que não atrapalhe no fluxo e rapidez do sistema. Deve ser implementado quando necessário.