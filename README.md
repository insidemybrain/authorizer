# Authorizer

## Sobre
Esse projeto é um autorizador de operações que trabalha diretamente via `stdin`
com um arquivo `operations` de operações descritas linha por linha.

O projeto foi estruturado obedecendo os prinícipios `S.O.L.I.D.` a fim de melhorar a divisão
de responsabilidades  e redução de boilerplate code.

Para a arquitetura, utilizei a `Clean Architecture` com propósito de distribuir as 
responsabilidades por camadas assim como previsto na arquitetura modelo.
Dessa forma, foi possível realizar testes unitários e de integração com maior facilidade.

As operações são salvas em memória, conforme solicitado, porém utilizando a estrutura de dados `Hash table (HashMap/HashSet)`
de forma que facilite a inserção e leitura das operações tendo em vista que ambas são executadas
em média de `O(1)`.

---

## Compilação
### Manual
Como o projeto está em `Kotlin` geraremos um binário `.jar` para a execução multiplataforma.

Para gerar o binário, caminhe via linha de comando até a pasta do projeto.

Dado que o terminal está na raíz do projeto, execute o comando `./gradlew jar`
e o binário compilado ficará disponível em: `build/libs/authorizer.jar`.


### Docker
Também existe a possibilidade de rodar o projeto de forma containerizada
através do `Docker`.

Para a execução via Docker, caminhe via caminhe via linha de comando até a pasta do projeto.

Dado que o terminal está na raíz do projeto, execute o comando `docker build . -t authorizer`
e uma imagem docker será criada com a tag `authorizer`.

---

## Testes
Para a exeução dos testes do projeto, caminhe via linha de comando até a pasta do projeto.

Dado que o terminal está na raíz do projeto, execute o comando `./gradlew test`.
Em sequência todos os testes serão executados e um report em html, feito com a biblioteca `Jacoco`,
estará disponível em `build/jacocoHtml/index.html`

Após a execução dos testes também estará disponível um arquivo `.csv` com o report
da cobertura de testes em `build/reports/jacoco/test/jacocoTestReport.csv` para
facilitar a importação em outras plataformas.

---

## Execução
### Manual
Para a execução manual, caminhe via caminhe via linha de comando até a pasta do projeto.

Dado que o terminal está na raíz do projeto, execute o comando `java -jar build/libs/authorizer.jar < operations`
onde `operations` é o arquivo de operações.

### Docker
Para a execução via Docker, caminhe via caminhe via linha de comando até a pasta do projeto.

Dado que o terminal está na raíz do projeto, execute o comando `docker run authorizer`
e a imagem ficará responsável pela execução dos comandos necessários.

---

## Bibliotecas externas

Para facilitar o desenvolvimento algumas bibliotecas open-source foram utilizadas,
segue abaixo a lista de bibliotecas e suas devidas justificativas.

- **JUnit4** - Biblioteca utilizada para realização dos testes do projeto.
- **Jacoco** - Biblioteca utilizada para facilitar a geração e visualização de reports de cobertura do projeto.
- **Mockito** (3.2.0) - Biblioteca utilizada para fazer mocks e facilitar a criação de caso de testes.
- **Koin** (3.1.2) - Biblioteca utilizada para gerenciar a injeção de dependências do projeto.
- **GSON** (2.8.7) - Biblioteca utilizada para tratar `request` e `response` JSON utilizados na aplicação.