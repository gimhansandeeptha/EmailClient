import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mail implements Serializable {
    private String recipient;
    private String subject;
    private String content;
    private String sendDate;
    private String myMailAdr;
    private String password;

    public Mail(String recipientDetail) throws ParseException{

        String[] arr = recipientDetail.split(",");
        recipient = arr[0];
        subject = arr[1];
        content = arr[2];

        Date date=new Date();
        SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
        String d = formate.format(date);
        this.sendDate=d;
    }


    public void send(){
        
        MailAccounts myGmailAcc01 = new MyGmailAcc();
        myGmailAcc01.sendMail(this); 
    }

    public void save() throws ClassNotFoundException{
        SerializdMail serializdMail=new SerializdMail("object.ser");
        serializdMail.saveMail(this);
    }

    String getRecipient(){
        return recipient;
    }
    String getSubject(){
        return subject;
    }
    String getContent(){
        return content;
    }
    String getSendDate(){
        return sendDate;
    }
    String getMyMailAdr(){
        return myMailAdr;
    }
    String getPassword(){
        return password;
    }
    
}
