# 📘 Escola do Professor Carlos -- API de Gestão de Alunos

Este projeto consiste em uma API REST para gerenciar **alunos**,
**notas**, **frequências** e **relatórios estatísticos**, desenvolvida
como parte de um desafio técnico.

------------------------------------------------------------------------

# 📑 Sumário

-   Sobre o Projeto
-   Tecnologias Utilizadas
-   Requisitos do Ambiente
-   Como Executar o Projeto
-   Acesso ao Banco H2
-   Premissas Assumidas
-   Decisões de Projeto
-   Endpoints da API
-   Modelos de Dados (DTOs)
-   Melhorias Futuras
-   Contato

------------------------------------------------------------------------

# 🏫 Sobre o Projeto

A API permite: - Cadastro de alunos\
- Registro de notas e frequência por disciplina\
- Atualização e remoção de alunos\
- Relatórios consolidados:
- Média por disciplina\
- Média por aluno\
- Frequência geral\
- Alunos abaixo de 75% de frequência\
- Alunos acima da média da turma

------------------------------------------------------------------------

# 🛠 Tecnologias Utilizadas

-   Java 17+
-   Spring Boot 3
-   Spring Web
-   Spring Data JPA
-   H2 Database
-   Maven
-   Swagger/OpenAPI

------------------------------------------------------------------------

# 💻 Requisitos do Ambiente

Certifique-se de ter instalado:

Componente      Versão Recomendada
  --------------- ---------------------------
JDK             17 ou 21
Maven           3.8+
IntelliJ IDEA   Community/Ultimate
Java Compiler   Não usar JDK 0 ou Java 23

## ⚠ Importante no IntelliJ

-   File \> Project Structure \> Project SDK → JDK 17
-   Settings \> Build Tools \> Maven \> JVM for Importer → JDK 17

------------------------------------------------------------------------

# ▶️ Como Executar o Projeto

## ✔️ Pelo IntelliJ

1.  Abra o projeto\
2.  Aguarde o Maven importar\
3.  Abra a classe principal (`@SpringBootApplication`)\
4.  Clique em Run ▶️

------------------------------------------------------------------------

## ✔️ Pelo terminal

    mvn clean install
    mvn spring-boot:run

API disponível em: http://localhost:8080

------------------------------------------------------------------------

# 🗃️ Acesso ao Banco H2

URL: http://localhost:8080/h2-console

Campo      Valor
  ---------- --------------------
JDBC URL   jdbc:h2:mem:testdb
User       sa
Password   *(vazio)*

------------------------------------------------------------------------

# 📌 Premissas Assumidas

-   Notas sempre devem conter disciplina válida, valor 0--10 e
    frequência 0--100.\
-   Disciplinas válidas: PORTUGUES, MATEMATICA, CIENCIAS, ARTES,
    HISTORIA.\
-   Aluno pode ter várias notas.\
-   Banco em memória.\
-   Relatórios usam média simples.\

------------------------------------------------------------------------

# 🧠 Decisões de Projeto

-   DTOs para não expor entidades.\
-   Enum para disciplina.\
-   Relatórios separados para melhor organização.\
-   H2 para ambiente de testes.

------------------------------------------------------------------------

# 📚 Endpoints da API

## ALUNOS

### POST /alunos

Cria aluno.

Exemplo:

``` json
{
  "nome": "Ana",
  "notas": [
    {"disciplina": "MATEMATICA", "valor": 9, "frequencia": 100}
  ]
}
```

------------------------------------------------------------------------

## RELATÓRIOS

### GET /relatorios/media-turma-por-disciplina

Média geral por disciplina.

### GET /relatorios/media-notas-por-aluno

Média de notas por aluno.

### GET /relatorios/frequencia-por-aluno

Frequência média.

### GET /relatorios/alunos-baixa-frequencia

Frequência \< 75%.

### GET /relatorios/alunos-a-cima-da-media

Notas acima da média da turma.

------------------------------------------------------------------------

# 🧩 Modelos de Dados (DTOs)

### AlunoRequestDTO

``` json
{
  "nome": "string",
  "notas": [{"disciplina": "MATEMATICA", "valor": 0, "frequencia": 0}]
}
```

### NotaRequestDTO

``` json
{"disciplina": "MATEMATICA", "valor": 0, "frequencia": 0}
```

### AlunoResponseDTO

``` json
{"id": 1, "nome": "string", "notas": []}
```

### NotaResponseDTO

``` json
{"id": 1, "disciplina": "MATEMATICA", "valor": 8, "frequencia": 95}
```

### MediaNotaDisciplinaDTO

``` json
{"disciplina": "MATEMATICA", "media": 7.5}
```

### MediaNotaAlunoDTO

``` json
{"nomeAluno": "Ana", "mediaNota": 8}
```

### FrequenciaGeralAlunoDTO

``` json
{"nomeAluno": "Ana", "mediaFrequencia": 90}
```

------------------------------------------------------------------------

# 🚀 Melhorias Futuras

-   Segurança JWT\
-   Migração para PostgreSQL\
-   Ranking de alunos\
-   Paginação\
-   Importação via planilha\
-   Testes unitários

------------------------------------------------------------------------

# 📞 Contato

Desenvolvedora: Ana Cecília\
Tecnologias: Java • Spring • AWS • Node • TypeScript
