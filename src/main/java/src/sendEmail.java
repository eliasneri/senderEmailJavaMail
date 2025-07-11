package src;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class sendEmail {

    public static void main(String[] args) {

        final String username = "teste@email.com";
        final String password = "abcde";
        final String host = "mail.teste.com.br";
        final int port = 123;
        final String emailFrom = "remetente@email.com";
        final String emailTo = "destinatario@email.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject("Teste de Configuração SMTP - Sucesso");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String timeStamp = dtf.format(now);

            String templatePath = "src/resources/email_template.html";
            String htmlTemplate = new String(Files.readAllBytes(Paths.get(templatePath)), StandardCharsets.UTF_8);
            String htmlContent = htmlTemplate.replace("{{dataHora}}", timeStamp);

            message.setContent(htmlContent, "text/html; charset=utf-8");

           Transport.send(message);

            System.out.println("Email HTML enviado com sucesso em " + timeStamp);

        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}