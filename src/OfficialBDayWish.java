import java.text.ParseException;

public class OfficialBDayWish implements BirthDay {

    @Override
    public void sendBdayWish(MailReceivers recipient) throws ParseException, ClassNotFoundException {

        String wish=" Happy B'day Dear "+ recipient.getName();
        String subject="Official Birthday Wishes";
        String recipientDetail =recipient.getEmail()+","+subject+","+wish;
        Mail mail =new Mail(recipientDetail);
        mail.send();
        mail.save();
        
    }
    
}
