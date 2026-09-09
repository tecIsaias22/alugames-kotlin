# 🎮 AluGames - Kotlin

Projeto desenvolvido durante meus estudos de **Kotlin na plataforma Alura**, com o objetivo de praticar conceitos de **Programação Orientada a Objetos, coleções, funções de extensão, encapsulamento e consumo de API**.

O projeto simula um sistema de cadastro de gamers e busca de jogos através da **API CheapShark**.

> 📚 Projeto desenvolvido para fins de estudo e aprendizado em Kotlin.

---

## 🎯 Objetivo

O projeto permite:

* 👤 Cadastrar um gamer;
* 📧 Validar o e-mail informado;
* 🎂 Calcular a idade do gamer a partir da data de nascimento;
* 🆔 Gerar um identificador interno para o gamer;
* 🎮 Buscar jogos através de um código/ID;
* 🌐 Consumir dados de uma API externa;
* 📝 Adicionar uma descrição personalizada ao jogo;
* 📋 Armazenar os jogos pesquisados;
* 🔤 Ordenar os jogos pelo título;
* 🔎 Filtrar jogos pelo título;
* 🗑️ Excluir um jogo da lista.

---

## 🛠️ Tecnologias utilizadas

* Kotlin
* Maven
* Gson
* Java HttpClient
* CheapShark API
* JUnit
* Git
* GitHub

---

## 📚 Conceitos de Kotlin praticados

Durante o desenvolvimento foram utilizados diversos conceitos da linguagem Kotlin.

### Classes e Data Classes

Foram utilizadas `data class` para representar as informações do sistema, como:

* `Gamer`
* `Jogo`
* `InfoApiShark`
* `meuInfoJogo`

As classes são utilizadas para organizar e representar os dados da aplicação.

---

### Programação Orientada a Objetos

O projeto utiliza conceitos de POO, como:

* Classes;
* Objetos;
* Construtores;
* Construtor secundário;
* Encapsulamento;
* Propriedades;
* Métodos;
* `init`.

---

### Encapsulamento

O projeto utiliza modificadores para controlar o acesso às propriedades.

Um exemplo é o `idInterno`, que possui:

```kotlin
private set
```

Isso permite que o valor seja acessado, mas evita que ele seja alterado diretamente de fora da classe.

---

### Custom Setter

A propriedade `usuario` possui um `setter` personalizado.

Quando o usuário é definido, o sistema verifica se o identificador interno ainda precisa ser criado.

---

### Null Safety

O projeto utiliza recursos de segurança contra valores nulos, como:

```kotlin
?
```

e:

```kotlin
?:
```

Também são utilizadas propriedades que podem receber `null`.

---

### Funções de extensão

Foi criada uma função de extensão para transformar uma data de nascimento em idade:

```kotlin
fun String.tranformarEmIdade()
```

Dessa forma, uma `String` contendo uma data pode utilizar diretamente essa função.

---

### Collections

Foi utilizada uma lista mutável para armazenar os jogos pesquisados:

```kotlin
mutableListOf<Jogo?>()
```

Também foram utilizados recursos de coleções como:

* `add()`
* `sortBy()`
* `filter()`
* `forEach()`
* `removeAt()`

---

### Scope Functions

O projeto também possui exemplos de:

```kotlin
let
```

e:

```kotlin
also
```

utilizados no arquivo de testes do `Gamer`.

---

## 🌐 Consumo de API

O projeto realiza uma requisição HTTP para a **API CheapShark**.

A aplicação envia o ID do jogo e recebe informações no formato JSON.

O consumo é realizado utilizando:

```kotlin
HttpClient
```

e:

```kotlin
HttpRequest
```

O JSON recebido é convertido em objetos Kotlin utilizando a biblioteca:

```kotlin
Gson
```

---

## 🔄 Funcionamento do projeto

O fluxo principal da aplicação funciona da seguinte maneira:

```text
Início
  ↓
Cadastro do Gamer
  ↓
Validação dos dados
  ↓
Exibição dos dados
  ↓
Busca do jogo pelo ID
  ↓
Consulta à API CheapShark
  ↓
Conversão do JSON para objeto Kotlin
  ↓
Adição do jogo à lista
  ↓
Ordenação dos jogos
  ↓
Filtro por título
  ↓
Possibilidade de excluir um jogo
  ↓
Finalização
```

---

## 📂 Estrutura do projeto

```text
alugames-kotlin
│
├── IsaiasGames
│   ├── src
│   │   └── main
│   │       └── kotlin
│   │           └── br.com.alura.alugames
│   │               │
│   │               ├── modelo
│   │               │   ├── Gamer.kt
│   │               │   ├── Jogo.kt
│   │               │   ├── InfoApiShark.kt
│   │               │   └── meuInfoJogo.kt
│   │               │
│   │               ├── principal
│   │               │   ├── Main.kt
│   │               │   └── testeGamer.kt
│   │               │
│   │               ├── servicos
│   │               │   └── consumoApi.kt
│   │               │
│   │               └── utilitario
│   │                   └── tranformarEmIdade.kt
│   │
│   ├── .gitignore
│   └── pom.xml
│
└── README.md
```

---

## 📌 Principais arquivos

### `Gamer.kt`

Responsável por representar o gamer.

Nele são trabalhados:

* Nome;
* E-mail;
* Data de nascimento;
* Usuário;
* ID interno;
* Lista de jogos pesquisados.

Também possui validação de nome e e-mail e a criação do gamer através de um `companion object`.

---

### `Jogo.kt`

Representa um jogo contendo:

* Título;
* Capa;
* Descrição.

Também possui uma implementação personalizada do `toString()`.

---

### `InfoApiShark.kt`

Representa as informações recebidas da API relacionadas ao jogo.

---

### `meuInfoJogo.kt`

Responsável pelo mapeamento das informações recebidas no JSON.

O projeto utiliza a anotação:

```kotlin
@SerializedName("info")
```

para realizar o mapeamento utilizando Gson.

---

### `consumoApi.kt`

Responsável pelo consumo da API.

É nesse arquivo que a aplicação:

1. Monta o endereço da API;
2. Cria o cliente HTTP;
3. Cria a requisição;
4. Envia a requisição;
5. Recebe o JSON;
6. Utiliza Gson para transformar o JSON em objeto Kotlin.

---

### `tranformarEmIdade.kt`

Contém uma função de extensão responsável por calcular a idade utilizando:

* `LocalDate`;
* `Period`;
* `DateTimeFormatter`.

---

### `Main.kt`

É o ponto principal da aplicação.

Responsável por controlar o fluxo do programa, incluindo:

* Cadastro do gamer;
* Busca dos jogos;
* Consumo da API;
* Cadastro das descrições;
* Lista de jogos;
* Ordenação;
* Filtro;
* Exclusão.

---

### `testeGamer.kt`

Arquivo utilizado para realizar testes e praticar funcionalidades relacionadas à classe `Gamer`, incluindo o uso de `let` e `also`.

---

## 📦 Dependências

O projeto utiliza o **Maven** para gerenciamento das dependências.

Entre as principais dependências estão:

* Kotlin;
* Gson;
* JUnit.

---

## ▶️ Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/tecIsaias22/alugames-kotlin.git
```

### 2. Entre na pasta do projeto

```bash
cd alugames-kotlin
```

### 3. Entre na pasta da aplicação

Como o projeto está organizado dentro da pasta `IsaiasGames`:

```bash
cd IsaiasGames
```

### 4. Compile utilizando Maven

```bash
mvn clean compile
```

Depois, execute a aplicação pela sua IDE ou utilizando a configuração do projeto Maven.

---

## 💡 O que aprendi com este projeto

Este projeto foi importante para praticar conceitos fundamentais de Kotlin e programação orientada a objetos.

Entre os principais aprendizados estão:

* Criação e utilização de classes;
* `data class`;
* Construtores;
* Encapsulamento;
* `init`;
* `companion object`;
* Null Safety;
* Collections;
* Funções de extensão;
* Scope Functions;
* Expressões lambda;
* Consumo de API;
* Requisições HTTP;
* JSON;
* Desserialização com Gson;
* Organização de um projeto Kotlin com Maven.

---

## 📚 Origem do projeto

Este projeto foi desenvolvido durante meus estudos de **Kotlin na Alura**, como forma de colocar em prática os conteúdos aprendidos durante o curso.

O projeto é de **estudo pessoal** e não representa um projeto oficial da Alura.

---

## 👨‍💻 Autor

**Isaías Caetano**

Projeto desenvolvido para prática e evolução dos conhecimentos em desenvolvimento com Kotlin.

---

⭐ Se este projeto foi útil para você ou você também está estudando Kotlin, fique à vontade para explorar o código.
