# Sistema de Gerenciamento de Empregados

Aplicação desenvolvida em **Java 21** para estudar operações de persistência de dados em banco de dados relacional, utilizando **Programação Orientada a Objetos (POO)**, **JDBC**, **Maven** e **PostgreSQL**.

O projeto trabalha com o cadastro de empregados e a estrutura de armazenamento de seus dependentes, aplicando conceitos de organização em camadas e integração entre Java e banco de dados.

## 1. Tecnologias utilizadas

- **Java 21:** linguagem de programação.
- **Maven:** gerenciamento de dependências e compilação.
- **JDBC:** API de comunicação entre Java e banco de dados.
- **PostgreSQL 16:** sistema gerenciador de banco de dados relacional.
- **Docker:** execução do ambiente de banco de dados em container.
- **Visual Studio Code:** ambiente de desenvolvimento.

## 2. Funcionalidades

### 2.1. Empregados

A aplicação disponibiliza as seguintes operações:

| Operação | Descrição |
|---|---|
| Inserir empregado | Cadastra um novo empregado. |
| Alterar empregado | Atualiza os dados de um empregado existente. |
| Excluir empregado | Remove um empregado identificado pelo CPF. |
| Listar empregados | Recupera os empregados cadastrados. |
| Pesquisar por CPF | Localiza um empregado utilizando seu CPF. |

### 2.2. Dependentes

O banco de dados também possui uma tabela para armazenar os dependentes dos empregados.

Cada dependente está associado a um empregado por meio do CPF do empregado.

A estrutura da tabela permite que um empregado possua vários dependentes.

**Observação:** a tabela está definida no banco de dados. As operações de manutenção de dependentes poderão ser implementadas posteriormente na aplicação Java.

## 3. Arquitetura do projeto

O projeto utiliza uma organização em camadas, separando as responsabilidades de apresentação, controle, modelo e persistência.

### 3.1. Camada Model

Responsável pela representação dos objetos utilizados pela aplicação.

A classe `Empregado` representa um empregado e contém os atributos:

- CPF;
- Nome;
- Idade;
- Salário.

A estrutura de dependentes poderá ser representada por uma classe `Dependente`, contendo:

- CPF do empregado;
- Nome;
- Grau de parentesco;
- Data de nascimento.

### 3.2. Camada Controller

Responsável por receber as solicitações da camada de apresentação e encaminhá-las para a camada de persistência.

A classe `EmpregadoController` disponibiliza os métodos de inserção, alteração, exclusão, listagem e pesquisa de empregados.

### 3.3. Camada Persistência

Responsável pela comunicação com o banco de dados.

A interface `EmpregadoDAO` define as operações de persistência, enquanto a classe `EmpregadoDAOImp` implementa essas operações utilizando JDBC e comandos SQL.

A classe `ConnectionFactory` é responsável pelo fornecimento da conexão com o PostgreSQL.

### 3.4. Camada View

Responsável pela interação com o usuário e pela apresentação dos resultados.

A classe `Teste` é utilizada para executar e testar as operações disponibilizadas pelo controlador.

## 4. Estrutura de diretórios

A organização dos arquivos segue a seguinte estrutura:

```text
java-estudos/
│
├── .devcontainer/
│   └── devcontainer.json
│
├── src/
│   ├── arquivo/
│   │   ├── arq1.txt
│   │   └── arq2.txt
│   │
│   └── br/
│       └── com/
│           └── javabasico/
│               └── rh/
│                   ├── model/
│                   │   └── Empregado.java
│                   │
│                   ├── controller/
│                   │   └── EmpregadoController.java
│                   │
│                   ├── persistencia/
│                   │   ├── EmpregadoDAO.java
│                   │   ├── EmpregadoDAOImp.java
│                   │   └── ConnectionFactory.java
│                   │
│                   └── view/
│                       └── Teste.java
│
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

**Observação:** o Maven está configurado para utilizar `src` como diretório de código-fonte, preservando a estrutura de diretórios adotada nos exercícios.

## 5. Banco de dados

O projeto utiliza PostgreSQL como sistema gerenciador de banco de dados.

O banco de dados utilizado é `rh`, que contém duas tabelas principais:

- `empregado`: armazena os dados dos empregados.
- `dependente`: armazena os dados dos dependentes associados aos empregados.

### 5.1. Tabela empregado

A tabela `empregado` armazena as informações cadastrais dos empregados.

```sql
CREATE TABLE empregado (
    cpf CHAR(11) NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT,
    salario DECIMAL(8,2)
);
```

Descrição dos campos:

| Campo | Tipo | Descrição |
|---|---|---|
| cpf | CHAR(11) | CPF do empregado. Chave primária. |
| nome | VARCHAR(50) | Nome do empregado. |
| idade | INT | Idade do empregado. |
| salario | DECIMAL(8,2) | Salário do empregado. |

O campo `cpf` é a chave primária da tabela, identificando exclusivamente cada empregado.

### 5.2. Tabela dependente

A tabela `dependente` armazena os dados dos dependentes vinculados aos empregados.

```sql
CREATE TABLE dependente (
    cpfEmpregado CHAR(11) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    grauParentesco VARCHAR(10),
    dataNascimento DATE,

    CONSTRAINT pk_dependente
        PRIMARY KEY (cpfEmpregado, nome),

    CONSTRAINT fk_empregado
        FOREIGN KEY (cpfEmpregado)
        REFERENCES empregado(cpf)
);
```

Descrição dos campos:

| Campo | Tipo | Descrição |
|---|---|---|
| cpfEmpregado | CHAR(11) | CPF do empregado ao qual o dependente está associado. |
| nome | VARCHAR(50) | Nome do dependente. |
| grauParentesco | VARCHAR(10) | Grau de parentesco com o empregado. |
| dataNascimento | DATE | Data de nascimento do dependente. |

A tabela utiliza duas restrições importantes:

**Chave primária composta (`pk_dependente`):**

```sql
PRIMARY KEY (cpfEmpregado, nome)
```

A chave primária é composta por dois campos. Isso significa que a combinação do CPF do empregado com o nome do dependente deve ser única.

Assim, um empregado pode possuir vários dependentes, desde que não existam dois dependentes com o mesmo nome vinculados ao mesmo CPF.

**Chave estrangeira (`fk_empregado`):**

```sql
FOREIGN KEY (cpfEmpregado)
REFERENCES empregado(cpf)
```

Estabelece o relacionamento entre as tabelas `dependente` e `empregado`.

O CPF informado na tabela `dependente` deve existir previamente na tabela `empregado`.

### 5.3. Relacionamento entre as tabelas

O relacionamento entre as tabelas é de **um para muitos (1:N)**:

- Um empregado pode possuir nenhum, um ou vários dependentes.
- Cada dependente está associado a um único empregado.

Representação simplificada:

```text
EMPREGADO
-------------------------
cpf (PK)
nome
idade
salario
          |
          | 1
          |
          | N
DEPENDENTE
-------------------------
cpfEmpregado (PK, FK)
nome (PK)
grauParentesco
dataNascimento
```

A chave estrangeira `cpfEmpregado` permite identificar a qual empregado cada dependente pertence.

## 6. Configuração da conexão

No ambiente Docker Compose, o serviço PostgreSQL utiliza as seguintes configurações:

| Parâmetro | Valor |
|---|---|
| Banco de dados | `rh` |
| Usuário | `javabasico` |
| Senha | `123456` |
| Porta publicada no host | `5448` |
| Porta interna do PostgreSQL | `5432` |
| Serviço Docker | `postgres-java` |

A URL JDBC depende do local de execução da aplicação.

**Dentro do container Java:**

```text
jdbc:postgresql://postgres-java:5432/rh
```

**A partir do computador host:**

```text
jdbc:postgresql://localhost:5448/rh
```

## 7. Dependências Maven

O arquivo `pom.xml` configura o Java 21 e a dependência JDBC do PostgreSQL.

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.8</version>
</dependency>
```

O Maven realiza automaticamente o download da biblioteca necessária para a comunicação com o banco de dados.

## 8. Executando o projeto

### 8.1. Iniciar o ambiente Docker

Na raiz do projeto, execute:

```bash
docker compose up -d
```

Para verificar os containers:

```bash
docker compose ps
```

### 8.2. Verificar o Java

Dentro do Dev Container:

```bash
java -version
```

O ambiente deve utilizar Java 21.

### 8.3. Verificar o Maven

```bash
mvn -version
```

### 8.4. Resolver as dependências

```bash
mvn dependency:resolve
```

### 8.5. Compilar o projeto

```bash
mvn clean compile
```

### 8.6. Executar a aplicação

Para executar a classe de teste:

```bash
mvn exec:java -Dexec.mainClass="br.com.javabasico.rh.view.Teste"
```

## 9. Testando as operações

A classe `Teste` permite executar individualmente as operações disponibilizadas pelo sistema.

Para testar uma operação, basta habilitar o respectivo bloco de código, removendo os delimitadores de comentário.

Exemplo de pesquisa de empregado pelo CPF:

```java
EmpregadoController controller = new EmpregadoController();

Empregado emp = controller.pesquisarPorCpf("22222");

if (emp != null) {
    System.out.println("CPF: " + emp.getCpf());
    System.out.println("Nome: " + emp.getNome());
    System.out.println("Idade: " + emp.getIdade());
    System.out.println("Salário: " + emp.getSalario());
}
```

Se o empregado for localizado, seus dados serão apresentados no console.

## 10. Conceitos de programação aplicados

Durante o desenvolvimento do projeto são trabalhados os seguintes conceitos:

- Programação Orientada a Objetos;
- Classes e objetos;
- Atributos e métodos;
- Encapsulamento;
- Construtores;
- Getters e setters;
- Interfaces;
- Implementação de interfaces;
- Organização em pacotes;
- Separação de responsabilidades;
- Arquitetura em camadas;
- Padrão DAO (Data Access Object);
- JDBC;
- Conexões com banco de dados;
- `PreparedStatement`;
- `ResultSet`;
- Comandos SQL;
- Chaves primárias e estrangeiras;
- Relacionamentos entre tabelas;
- Tratamento de exceções;
- Listas e coleções Java;
- Laço de repetição `for-each`;
- Gerenciamento de dependências com Maven.

## 11. Objetivo educacional

O projeto tem como finalidade demonstrar, por meio de uma aplicação prática, como desenvolver um sistema Java organizado em camadas e integrado a um banco de dados relacional.

A implementação permite estudar o fluxo de uma operação desde a camada de apresentação até sua execução no banco de dados, passando pelo controlador e pela camada de persistência.

Também permite compreender como representar relacionamentos entre entidades no banco de dados, utilizando chaves primárias e estrangeiras.

---

**Projeto desenvolvido para fins didáticos e de aprendizagem de Java, JDBC, Maven e PostgreSQL.**