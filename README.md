# 🎮 AluGames — Kotlin

Projeto desenvolvido durante meus estudos de **Kotlin na plataforma Alura**, com o objetivo de praticar programação orientada a objetos, coleções, encapsulamento, funções de extensão, consumo de APIs e modelagem de regras de negócio.

O **AluGames** simula um sistema de gerenciamento de gamers e jogos. A aplicação consulta informações de jogos pela API CheapShark e permite trabalhar com cadastro de usuários, recomendações, reputação, planos e aluguéis de jogos.

> 📚 Projeto de estudo pessoal, desenvolvido para praticar Kotlin e evoluir minhas habilidades em desenvolvimento de software.

---

## 🎯 Funcionalidades

### 👤 Cadastro e gerenciamento de gamers
- Cadastrar gamers com nome e e-mail.
- Validar o nome e o formato do e-mail.
- Informar data de nascimento e usuário.
- Calcular a idade a partir da data de nascimento.
- Gerar um identificador interno para o gamer.
- Armazenar os jogos pesquisados e os jogos alugados.

### 🎮 Busca e gerenciamento de jogos
- Buscar jogos pelo ID utilizando a API CheapShark.
- Consumir dados externos por meio de requisições HTTP.
- Converter respostas JSON em objetos Kotlin utilizando Gson.
- Adicionar descrições personalizadas aos jogos.
- Armazenar e ordenar os jogos pelo título.
- Filtrar jogos pelo nome.
- Excluir jogos da lista de pesquisados.

### ⭐ Recomendações e reputação
- Registrar notas para jogos e gamers.
- Calcular a média das avaliações.
- Associar jogos recomendados aos gamers.
- Utilizar a reputação do gamer como parte das regras de desconto.

### 📅 Aluguel de jogos
- Registrar o gamer, o jogo e o período do aluguel.
- Calcular a duração do aluguel em dias.
- Calcular o valor com base no plano do gamer.
- Armazenar os aluguéis realizados.
- Consultar os jogos alugados em determinado mês.

### 💳 Planos e regras de cobrança
- Utilizar uma classe base `Plano` para representar os planos.
- Implementar o plano avulso (`PlanoAvulso`).
- Implementar o plano de assinatura (`PlanoAssinatura`).
- Aplicar regras de cobrança e descontos de acordo com o plano.
- Considerar os jogos incluídos na assinatura e a reputação do gamer no cálculo do aluguel.

---

## 🛠️ Tecnologias utilizadas

- **Kotlin** — linguagem principal do projeto.
- **Maven** — gerenciamento de dependências e configuração da aplicação.
- **Gson** — conversão entre JSON e objetos Kotlin.
- **Java HttpClient** — comunicação HTTP com serviços externos.
- **CheapShark API** — consulta de informações de jogos.
- **JUnit 5 / Kotlin Test** — dependências de testes.
- **Git e GitHub** — versionamento e hospedagem do código.

---

## 📚 Conceitos de Kotlin praticados

### Classes e `data class`

O projeto utiliza classes para representar os elementos do sistema, incluindo:

- `Gamer`
- `Jogo`
- `Aluguel`
- `Periodo`
- `InfoApiShark`
- `meuInfoJogo`

As `data class` ajudam a representar dados e organizar as informações utilizadas pela aplicação.

### Programação Orientada a Objetos

Durante o desenvolvimento, foram praticados conceitos como:

- Classes e objetos.
- Construtores primários e secundários.
- Propriedades e métodos.
- Encapsulamento.
- Inicialização com `init`.
- Herança.
- Interfaces.
- Polimorfismo.
- Classes seladas (`sealed class`).

### Encapsulamento e `private set`

O projeto utiliza modificadores de acesso para controlar a alteração de propriedades.

Por exemplo, o `idInterno` do gamer possui um `private set`, permitindo consultar o identificador sem possibilitar sua alteração direta de fora da classe.

### Custom Setter

A propriedade `usuario` possui um `setter` personalizado. Quando o usuário é alterado, o sistema atualiza o identificador interno do gamer.

### Null Safety

São utilizados recursos de segurança para trabalhar com valores que podem ser nulos, como:

- Tipos anuláveis com `?`.
- Operador Elvis (`?:`).
- Chamadas seguras.
- Verificações de valores nulos.

### Funções de extensão

Foi criada uma função de extensão para calcular a idade a partir de uma data de nascimento:

```kotlin
fun String.tranformarEmIdade()
```

Ela permite utilizar a funcionalidade diretamente em uma `String` que representa uma data.

### Collections

O projeto utiliza coleções para armazenar e manipular jogos, aluguéis, recomendações e avaliações.

Entre as operações praticadas estão:

- `add()`
- `sortBy()`
- `filter()`
- `map()`
- `forEach()`
- `removeAt()`
- `average()`

### Scope Functions e expressões lambda

O projeto também trabalha com recursos idiomáticos de Kotlin, incluindo funções como `let` e `also`, além de expressões lambda utilizadas na manipulação de dados.

### Interfaces, herança e polimorfismo

A interface `Recomendavel` define comportamentos relacionados às avaliações. As classes que implementam essa interface fornecem suas próprias implementações para registrar notas e calcular médias.

A classe selada `Plano` serve como base para os planos de cobrança, permitindo que cada tipo de plano implemente suas próprias regras de cálculo.

### Datas e períodos

A classe `Periodo` utiliza recursos da biblioteca `java.time`, como `LocalDate` e `Period`, para representar datas e calcular a duração dos aluguéis.

---

## 🌐 Consumo de API

O projeto utiliza a **API CheapShark** para consultar informações de jogos.

O processo envolve:

1. Montar o endereço da requisição com o ID do jogo.
2. Configurar o cliente HTTP.
3. Criar e enviar a requisição.
4. Receber a resposta do serviço.
5. Verificar o código de status HTTP.
6. Converter o JSON recebido em objetos Kotlin utilizando Gson.

Entre os recursos utilizados estão:

```kotlin
HttpClient
HttpRequest
HttpResponse
Gson
```

A classe `ConsumoApi` centraliza a comunicação com os serviços externos e o processamento das respostas.

---

## 🔄 Fluxo geral da aplicação

```text
Início
  ↓
Cadastro do gamer
  ↓
Validação dos dados
  ↓
Consulta e cadastro de jogos
  ↓
Consumo da API CheapShark
  ↓
Conversão do JSON para objetos Kotlin
  ↓
Organização, filtro e exclusão de jogos
  ↓
Recomendações e avaliações
  ↓
Escolha do plano do gamer
  ↓
Registro dos aluguéis
  ↓
Cálculo do valor conforme as regras do plano
  ↓
Consulta aos jogos alugados por mês
```

*O fluxo acima apresenta as principais funcionalidades do projeto; nem todas precisam ser executadas em uma única sequência.*

---

## 📂 Estrutura do projeto

A estrutura principal do repositório está organizada da seguinte forma:

```text
alugames-kotlin/
├── IsaiasGames/
│   ├── src/
│   │   ├── main/
│   │   │   └── kotlin/
│   │   │       └── br/com/alura/alugames/
│   │   │           ├── modelo/
│   │   │           │   ├── Gamer.kt
│   │   │           │   ├── Jogo.kt
│   │   │           │   ├── Aluguel.kt
│   │   │           │   ├── Periodo.kt
│   │   │           │   ├── Plano.kt
│   │   │           │   ├── PlanoAvulso.kt
│   │   │           │   ├── PlanoAssinatura.kt
│   │   │           │   ├── Recomendavel.kt
│   │   │           │   ├── InfoApiShark.kt
│   │   │           │   └── meuInfoJogo.kt
│   │   │           ├── principal/
│   │   │           │   ├── Main.kt
│   │   │           │   └── testeGamer.kt
│   │   │           ├── servicos/
│   │   │           │   └── consumoApi.kt
│   │   │           └── utilitario/
│   │   │               └── tranformarEmIdade.kt
│   │   └── test/
│   ├── .gitignore
│   └── pom.xml
└── README.md
```

*Observação: a árvore apresenta os principais arquivos conhecidos do projeto. A presença e a localização de arquivos de teste podem variar conforme a versão do repositório.*

---

## 📌 Principais classes

| Classe | Responsabilidade |
|---|---|
| `Gamer.kt` | Representa o gamer, valida dados, gerencia listas, avaliações e aluguéis. |
| `Jogo.kt` | Representa um jogo, com título, capa, preço, descrição e avaliações. |
| `Aluguel.kt` | Representa o aluguel de um jogo por um gamer durante determinado período. |
| `Periodo.kt` | Representa as datas inicial e final e calcula a duração do aluguel. |
| `Plano.kt` | Define a base das regras de cobrança. |
| `PlanoAvulso.kt` | Implementa as regras de cobrança do plano avulso. |
| `PlanoAssinatura.kt` | Implementa as regras de assinatura, jogos incluídos e descontos. |
| `Recomendavel.kt` | Define o contrato para registrar avaliações e consultar a média. |
| `InfoApiShark.kt` | Representa informações do jogo recebidas da API. |
| `meuInfoJogo.kt` | Auxilia no mapeamento do JSON com Gson. |
| `ConsumoApi` | Realiza requisições HTTP e processa as respostas dos serviços externos. |
| `Main.kt` | Coordena o fluxo principal da aplicação. |
| `tranformarEmIdade.kt` | Contém a função de extensão para calcular a idade. |

---

## 📦 Gerenciamento de dependências

O projeto utiliza Maven para organizar as dependências e a configuração de compilação.

Entre as bibliotecas utilizadas estão:

- Kotlin Standard Library.
- Gson.
- JUnit 5.
- Kotlin Test.

As dependências e as configurações de compilação ficam definidas no arquivo `pom.xml`.

---

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/tecIsaias22/alugames-kotlin.git
```

### 2. Entre na pasta do projeto

```bash
cd alugames-kotlin/IsaiasGames
```

### 3. Compile a aplicação

Com o JDK e o Maven instalados, execute:

```bash
mvn clean compile
```

### 4. Execute o projeto

Abra o projeto na IDE de sua preferência, aguarde o carregamento das dependências Maven e execute a função `main` do arquivo `Main.kt`.

---

## 💡 Aprendizados e evolução

O desenvolvimento do AluGames permitiu praticar e aprofundar conhecimentos em:

- Desenvolvimento com Kotlin.
- Modelagem de classes e objetos.
- Programação Orientada a Objetos.
- Encapsulamento, herança e polimorfismo.
- Interfaces e classes seladas.
- Manipulação de coleções.
- Funções de extensão e expressões lambda.
- Null Safety.
- Datas e períodos.
- Consumo de APIs REST por HTTP.
- Processamento de JSON com Gson.
- Gerenciamento de dependências com Maven.
- Regras de negócio para planos, descontos e aluguéis.
- Versionamento de código com Git e GitHub.

O projeto representa uma evolução contínua dos meus estudos, desde operações básicas de cadastro e busca até a implementação de regras de negócio para avaliações, planos e aluguéis.

---

## 📚 Origem do projeto

O projeto foi desenvolvido durante meus estudos de Kotlin na Alura e ampliado como prática pessoal para consolidar os conceitos aprendidos.

É um projeto de estudo independente e não representa um produto oficial da Alura.

---

## 👨‍💻 Autor

**Isaías Caetano**

GitHub: [@tecIsaias22](https://github.com/tecIsaias22)

Projeto desenvolvido para praticar Kotlin, aprimorar a lógica de programação e evoluir meus conhecimentos em desenvolvimento de software.

---

⭐ Se você também está estudando Kotlin, fique à vontade para explorar o código e acompanhar a evolução do projeto.
