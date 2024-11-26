# Enum Definitions

Este repositório contém as definições de enums para o gerenciamento de status de alunos e financeiros dentro da aplicação. Todos os enums estão localizados na pasta `br.com.alunoonline.api.enums`.

## Bibliotecas Utilizadas

Este código utiliza as bibliotecas padrão do Java, sem dependências externas adicionais. Os `enums` são usados para representar constantes imutáveis com valor fixo.

## Arquivos e Funções

### 1. `CursoTypeEnum.java`
Este enum define os tipos de cursos que um aluno pode estar matriculado. As opções são:
- `GRADUACAO`: Representa um curso de graduação.
- `ESPECIALIZACAO`: Representa um curso de especialização.
- `MESTRADO`: Representa um curso de mestrado.
- `DOUTORADO`: Representa um curso de doutorado.

### 2. `FinanceiroStatusEnum.java`
Este enum define os possíveis status financeiros de um aluno. As opções são:
- `EM_DIA`: Indica que o pagamento está em dia.
- `EM_ATRASO`: Indica que o pagamento está atrasado.
- `TRANCADO`: Refere-se a uma situação onde o acesso do aluno ao curso foi bloqueado devido a pendências financeiras.
- `CANCELADO`: Indica que o curso ou matrícula foi cancelado devido a questões financeiras.

### 3. `MatriculaAlunoStatusEnum.java`
Este enum define os possíveis status de matrícula de um aluno. As opções são:
- `APROVADO`: Indica que o aluno foi aprovado no curso ou disciplina.
- `REPROVADO`: Indica que o aluno foi reprovado.
- `TRANCADO`: Representa uma matrícula suspensa ou bloqueada.
- `MATRICULADO`: Indica que o aluno está matriculado ativamente no curso ou disciplina.
