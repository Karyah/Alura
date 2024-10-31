# Computação em nuvem
 Permite acesso remoto a serviços (recursos de computação) por meio da internet. Tira a necessidade de servidores e infraestrutra locais.

## Vantagens
- Escalabilidade
- Flexibilidade
- Redução de Custos
- Acessibilidade e mobilidade
- Disponibilidade 
- Segurança 
- Confiabilidade 
- Velocidade de implementação

A computação em nuvem permite o uso de recursos por demanda, ou seja, apenas o recurso que for necessário será disponibilizado. O uso de recursos por demanda permite que o recurso esteja funcionando mesmo mediante a uma demanda muito maior que o comum, e que o recurso possa ser menos utilizado em caso de menor demanda. Isso reduz o custo das aplicações, a torna tolerável a falhas caso haja muito demanda e a torna muito mais flexível e escalável. 

Além disso, também reduz custos que a infraestrutura local pode gerar. Permite acesso remoto e colaboração em tempo real, viabilizando assim equipes distribuídas.

A provedora de Cloud possui um papel importante também na segurança, permitindo e disponibilizando criptografia, controle de acesso e monitoramento contínuo.

Serviços e recursos podem ser ativados rapidamente, e permite que frequentemente aplicações possam ser lançadas.

## Desvantagens
- Necessidade de conexão com a internet
- Dependência com provedores de nuvem
- Falta de controle completo (Vantagem e desvantagem)
- Custo de longo prazo

Além das desvantagens mais esperas de um serviço em nuvem, como a necessidade de conexão com a internet e falta de controle, existe uma grande dependencia do fornecedor de nuvem com o cliente. Isso pode se tornar um problema, por exemplo, para migrar de um provedor para outro.

# AWS 

Categorias importantes de serviços oferecidos pela AWS que nos ajudam a subir uma aplicação para a nuvem:

- _Computação_
    - EC2 (Elastik Computer Cloud) -  oferece a criação de servidores virtuais como instâncias de acordo com necessidades específicas. Selecionar armazenamento, memória, processador e sistema operacional que melhor atendem o projeto. Fácil capacidade de escalar processamento adicionando ou removendo instâncias de servidores virtuais. Permite executar diversas instâncias de servidores simultaneamente.
    - Lambda (Oferece serviços serverless)

- _Armazenamento_
    - Armazenar dados, disponibilizar vídeos etc
    - S3 - Simple Storage Service: capacidade de fornecer segurança, escalabilidade e desempenho eficiente; armazenar e recuperar qualquer quantidade de dados a qualquer momento. Objetos e Buckets.

- _Banco de dados_
    - Serviço de banco de dados, útil para autenticação por exemplo.
    - Amazon RDS - Serviço que disponibiliza o gerenciamento de base de dados relacionais na AWS. Escalabilidade e autogerenciamento. Dá suporte a toda infraestrutura de vanco de dados com um conjunto bem resumido de opções no console do RDS. É possível automatizar rotinas de administração de banco de dados, provisionamento de hardware e configurações de backup e restore.

- _Monitoramento_
    - Amazon CloudWatch -  serviço de monitoramento e observabilidade dos recursos da AWS. Possível configurar opções de monitoramento e gastos gerados no consumo de cada recurso.

- _Redes e entrega de conteúdo_
    - Configurações de rede para melhorar experiência do usuário e garantir disponibilidade, utilizar mais de um datacenter em diferentes regiões.

- _Segurança, identidade e conformidade (IAM)_
    - Gerenciamento de identidade e acesso

### Segurança como responsabilidade compartilhada

Tanto o provedor de Cloud quanto os clientes são responsáveis por manter a segurança do sistema

Provedor - segurança da infraestrutura: 
- Rede, servidor físico em si, garantir que haja backup da aplicação
- "_Responsible for security of the cloud_" 

Clientes 
- Cuidar de quem pode acessar a conta, gerenciamento de identidade de acesso IAM.
- "_Responsible for security in the cloud_" 

#### Políticas

- Configurar permissões que um usuário tem na AWS. Podemos atribuir essa política a um usuário, ou a um grupo de usuário.
- A própria AWS já fornece um conjunto de 
- Utilizar sgrupos de usuários IAM para organizar o acesso com base nas funções da equipe, aplicando políticas específicas para cada grupo.

### Como hospedar de fato os servidores:
Latência - tempo que um pacote de dados leva para se deslocar de um ponto a outro

Existem diferentes regiões no mundo onde a AWS possui datacenters.

Escolher onde os servidores estarão hospedados:
- Considerar _latência_: Servidor não pode estar muito distante de onde estarão os nossos clientes, o público alvo do servidor. Armazenar o mais próximo possível de onde estarão usuários
- Considerar _custo_: Pagamento de acordo com a demanda, e para região temos preços relativamente diferentes. A amazon disponibiliza uma tabela que mostra o custo dos recursos por demanda de acordo com a região.

#### Regiões
As regiões são locais físicos ao redor do mundo onde os dara centers da AWS estão alocados. Cada região é composta por várias zonas de disponibilidades isoladas.

A Netflix, por exemplo, usa a AWS como provedora de nuvem. Desse modo ela não precisa ter um datacenter físico em todo canto do mundo, ela delega essa função de infra para a AWS. Datacenters na AWS são distribuídos pelo mundo para atender todas as regiões

#### Zona de disponibilidade: 
Cada zona de disponibilidade funciona como um datacenter independente dentro da mesma região. Temos várias zonas de disponibilidade na mesma região, para garantir que, se um datacenter em uma zona específica ficar inacessível devido a problemas de rede ou internet, a aplicação ainda permanecerá disponível. Assegura a redundância para a aplicação, mesmo que ela esteja hospedada apenas em uma região

É possível distribuir os datacenter que você irá utilizar pelo mundo, de acordo com necessidade. 

Essa é vantagem que a nuvem leva em relação a datacenters _on-premisses_ (sistema de infraestrutura local).
