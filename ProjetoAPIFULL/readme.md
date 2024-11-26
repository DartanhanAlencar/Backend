
# Estrutura Inicial de um Projeto Spring Boot

## Estrutura inicial 

### 1. **Pasta `src`**
- **Descrição**: Contém o código-fonte da aplicação e os arquivos de configuração.
- **Subdivisões principais**:
  - `src/main/java`: Local onde ficam as classes Java da aplicação.
  - `src/main/resources`: Contém os recursos estáticos, como o arquivo `application.properties` ou `application.yml`, além de templates e outros arquivos de configuração.
  - `src/test/java`: Contém os testes unitários e de integração.

---

### 2. **Arquivo `mvnw`**
- **Descrição**: Script para executar o Maven em ambientes Linux ou macOS sem precisar instalá-lo diretamente no sistema.
- **Função**: Permite rodar comandos Maven, como `./mvnw clean install`, garantindo que a versão correta do Maven seja usada.

---

### 3. **Arquivo `mvnw.cmd`**
- **Descrição**: Versão para Windows do script `mvnw`.
- **Função**: Permite executar o Maven em sistemas Windows com comandos como `mvnw.cmd clean install`.

---

### 4. **Arquivo `pom.xml`**
- **Descrição**: Arquivo de configuração do Maven (Project Object Model).
- **Função**: Define as dependências, plugins, e configurações do projeto Spring Boot. 
- **Elementos principais**:
  - **`<dependencies>`**: Lista de bibliotecas necessárias para o projeto, como Spring Boot Starter, PostgreSQL Driver, etc.
  - **`<plugins>`**: Ferramentas adicionais para compilar, empacotar ou testar o projeto.
  - **`<properties>`**: Configurações como a versão do Java usada no projeto.

---

## Resumo
- **`src`**: Contém o código-fonte e os recursos da aplicação.
- **`mvnw` e `mvnw.cmd`**: Scripts para executar o Maven sem instalação local.
- **`pom.xml`**: Arquivo central de configuração do Maven, gerenciando dependências e build do projeto.

