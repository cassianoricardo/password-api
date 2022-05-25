# Password API

API REST responsável por validar as senhas informadas pelo usuário.

Será considerada uma senha válida aquela atender aos seguintes critérios abaixo:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
- Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

**_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos

Exemplo:

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

## Tecnologias presentes na API:

- Spring boot 2.6.7;
- Swagger 3;
- Lombok;
- JUnit 5;
- MockMvc

## Pré requisitos

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven 3.8.5](https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/)
- [Git](https://git-scm.com/downloads)

## Configuração Windows

### Adicionando o MAVEN_HOME e o JAVA_HOME
- Acesso o menu Windows,
- Digite "Editar as variáveis de ambiente do sistema"
- Em "Propriedades do Sistema" Acesse a Aba "Avançado" e clique em "Variaveis de Ambiente..."
- Em "Variáveis de Ambiente", Variaveis do Sistema, clique em "Novo..."
  - Nome da variável: MAVEN_HOME
  - Valor da variável: c:\apache-maven-3.8.5

- Em "Nova variável de sistema" Clique "Ok" e depois clique novamente em "Novo..."

  - Nome da variável: JAVA_HOME
  - Valor da variável: C:\Program Files\Java\jdk-11.0.0
- Em "Variáveis de ambiente" Clique "Ok".
- Em "Propriedades do sistema" Clique "Ok".


### Clonando o projeto

- Abra a sua pasta de repositório, clique com o botão direito do mouse e selecione a opção "Git Bash"
- Execute o comando abaixo:
  - git clone https://github.com/cassianoricardo/password-api.git


### Execução do Password API

#### Eclipse:

#### Importando o projeto:

- Menu "File", selecione "Import"
- Em "Import" Expanda a pasta "Maven" e selecione a opção "Existing Maven Projects" e clique em "Next"
- Em "Import Maven Projects" clique em "browse..." e selecione o pasta do projeto "Password API" e clique em "Finish"

#### Baixando as dependencias

Ainda no Eclipse, clique com o botão direito do mouse sob o projeto "Password API" selecione:

- "Run As" e depois "Maven clean"
- "Run As" e depois "Maven install"

#### Subindo a API

- Abra a classe App.java no diretório:
  - src/main/java/br/com/itau/password/api
- Clique com o botão direito do mouse na classe App, selecione "Run As" e clique em "Java Application"
- Após subir a Api será apresentado no console a URL do Swagger do Password API
  - http://localhost:8080/swagger-ui/index.html

#### Intellij:

...