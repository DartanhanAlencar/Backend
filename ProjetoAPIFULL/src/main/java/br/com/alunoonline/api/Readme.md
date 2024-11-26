# Projeto AlunoOnline API

### Arquitetura das Pastas

- **controller**: Camada responsável por receber as requisições HTTP, validar os dados e encaminhá-los para a camada de serviço. Aqui estão implementados os endpoints REST da aplicação.
- **service**: Contém a lógica de negócios. Os serviços fazem o intermédio entre os controladores e o repositório de dados.
- **model**: Define as entidades que representam as tabelas do banco de dados.
- **dtos**: Contém os objetos de transferência de dados (DTOs), usados para trafegar informações entre o cliente e a API de forma controlada.
- **repository**: Interface para a comunicação com o banco de dados, geralmente utilizando Spring Data JPA.
- **enums**: Contém as definições de tipos enumerados, usados para representar valores constantes em regras de negócio ou atributos das entidades, como status, tipos de usuário, ou níveis de acesso.
## Classe Principal: `AlunoOnlineApplication.java`
A classe `AlunoOnlineApplication.java` é o ponto de entrada da aplicação. Ela desempenha funções essenciais para a inicialização e execução correta do sistema:

1. **Configura o Spring Boot**  
   Utiliza a anotação `@SpringBootApplication`, que encapsula funcionalidades como:
   - Escaneamento de componentes.
   - Configuração automática.
   - Integração com o contexto da aplicação.

2. **Inicializa e executa a aplicação**  
   O método `main` invoca `SpringApplication.run()`, que:
   - Carrega o contexto do Spring.
   - Inicia o servidor embutido.
   - Prepara a aplicação para receber requisições.

3. **Gerencia os componentes da aplicação**  
   Garante que todos os componentes, como controladores, serviços e repositórios, sejam:
   - Registrados no contêiner do Spring.
   - Gerenciados adequadamente com injeção de dependências e ciclo de vida configurado.
