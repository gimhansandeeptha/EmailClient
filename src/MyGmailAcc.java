import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MyGmailAcc implements MailAccounts{

    public void sendMail(Mail mail){
        String recipient=mail.getRecipient();
        String subject=mail.getSubject();
        String content = mail.getContent();

        System.out.println("Preparing to send Email to... "+recipient);
        Properties properties =new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myMailAdr = "emailclient200574n@gmail.com";
        String password = "nzohaaehonsaqlwa";//nhuitgplizjlnhvh";

        Session session =Session.getInstance(properties,new Authenticator() {

           @Override
           protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(myMailAdr, password);
           } 
        });

        Message message = prepareMessage(session,myMailAdr,recipient,subject,content);
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Message sent sucssusfully");

    }

    private Message prepareMessage(Session session, String myMailAdr, String recipient,String subject, String content) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myMailAdr));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(content);
            return message;
        }
        catch(Exception ex){
            java.util.logging.Logger.getLogger(MyGmailAcc.class.getName()).log(java.util.logging.Level.SEVERE,null, ex);
        }
    
        return null;
    }
    
}
