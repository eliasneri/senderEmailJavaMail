# Envio de Email com JavaMail

Este projeto Java realiza o envio de um email em formato HTML utilizando a biblioteca JavaMail.

## Pré-requisitos

- Java 8 ou superior
- Biblioteca JavaMail (javax.mail)
- Conexão com servidor SMTP válido

## Arquivo Principal

- `sendEmail.java`

## Variáveis que devem ser configuradas antes do teste

Edite o arquivo `sendEmail.java` e preencha os seguintes campos:

```java
final String username = "teste@email.com";       // Usuário da conta SMTP
final String password = "abcde";                 // Senha da conta SMTP
final String host = "mail.teste.com.br";         // Servidor SMTP
final int port = 123;                            // Porta do servidor SMTP
final String emailFrom = "remetente@email.com";  // Email do remetente
final String emailTo = "destinatario@email.com"; // Email do destinatário
```

## Observação

- O conteúdo do email HTML está embutido no código.
- Caso deseje personalizar o layout, edite o conteúdo da variável `htmlContent`.

## Execução

Compile e execute:

```bash
javac sendEmail.java
java sendEmail
```

O sistema enviará um email HTML com os dados informados.

---

📧 Projeto de teste de envio de email via SMTP.
