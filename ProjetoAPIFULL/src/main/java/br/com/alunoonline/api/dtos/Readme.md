# Pasta DTOs - Projeto AlunoOnline API

Este diretório faz parte da API AlunoOnline, que utiliza o Spring Boot para gerenciar operações relacionadas à administração de alunos, professores, disciplinas e matrículas. A pasta **dtos** contém os Objetos de Transferência de Dados (DTOs), que são utilizados para transportar dados entre o cliente e a API de forma controlada, garantindo uma estrutura consistente e segura para a troca de informações.

## Estrutura do Projeto

### Arquitetura das Pastas

- **controller**: Camada responsável por receber as requisições HTTP, validar os dados e encaminhá-los para a camada de serviço. Aqui estão implementados os endpoints REST da aplicação.
- **service**: Contém a lógica de negócios. Os serviços fazem o intermédio entre os controladores e o repositório de dados.
- **model**: Define as entidades que representam as tabelas do banco de dados.
- **dtos**: Contém os objetos de transferência de dados (DTOs), usados para trafegar informações entre o cliente e a API de forma controlada.
- **repository**: Interface para a comunicação com o banco de dados, geralmente utilizando Spring Data JPA.
- **enums**: Contém as definições de tipos enumerados, usados para representar valores constantes em regras de negócio ou atributos das entidades, como status, tipos de usuário, ou níveis de acesso.

## Arquivos na Pasta DTOs

### 1. **AtualizarNotasRequest**

**Responsabilidade**:  
Este DTO é utilizado para transportar as notas de um aluno que precisam ser atualizadas. Ele contém dois campos para armazenar as notas das duas primeiras avaliações de um aluno.

**Campos**:
- `grade1` (Double): Nota da primeira avaliação.
- `grade2` (Double): Nota da segunda avaliação.

**Bibliotecas Utilizadas**:
- `@Data` (Lombok): Gera automaticamente os métodos `getter`, `setter`, `equals`, `hashCode` e `toString`.

### 2. **CriarAlunoRequest**

**Responsabilidade**:  
Este DTO é utilizado para transportar os dados necessários para criar um novo aluno. Ele contém informações pessoais do aluno e dados relacionados ao curso.

**Campos**:
- `name` (String): Nome do aluno.
- `email` (String): E-mail do aluno.
- `courseId` (Long): ID do curso ao qual o aluno está matriculado.
- `discount` (Double): Desconto aplicado ao aluno.
- `dueDate` (Integer): Data de vencimento para pagamento (formato numérico).

**Bibliotecas Utilizadas**:
- `@Data` (Lombok): Gera automaticamente os métodos `getter`, `setter`, `equals`, `hashCode` e `toString`.

### 3. **DisciplinasAlunoResponse**

**Responsabilidade**:  
Este DTO é utilizado para transportar informações sobre as disciplinas de um aluno, incluindo o nome da disciplina, nome do professor, as notas e o status da matrícula.

**Campos**:
- `subjectName` (String): Nome da disciplina.
- `professorName` (String): Nome do professor responsável pela disciplina.
- `grade1` (Double): Nota da primeira avaliação.
- `grade2` (Double): Nota da segunda avaliação.
- `average` (Double): Média das duas avaliações.
- `status` (MatriculaAlunoStatusEnum): Status da matrícula do aluno na disciplina (Aprovado, Reprovado, etc.).

**Bibliotecas Utilizadas**:
- `@Data` (Lombok): Gera automaticamente os métodos `getter`, `setter`, `equals`, `hashCode` e `toString`.
- `MatriculaAlunoStatusEnum` (Enum): Representa o status da matrícula do aluno.

### 4. **HistoricoAlunoResponse**

**Responsabilidade**:  
Este DTO é utilizado para transportar o histórico acadêmico de um aluno, incluindo seu nome, e-mail e as disciplinas cursadas.

**Campos**:
- `studentName` (String): Nome do aluno.
- `studentEmail` (String): E-mail do aluno.
- `studentSubjectsResponseList` (List<DisciplinasAlunoResponse>): Lista de disciplinas que o aluno cursou, com informações sobre notas e status.

**Bibliotecas Utilizadas**:
- `@Data` (Lombok): Gera automaticamente os métodos `getter`, `setter`, `equals`, `hashCode` e `toString`.
- `List<DisciplinasAlunoResponse>`: Lista de objetos que contêm os dados das disciplinas do aluno.






