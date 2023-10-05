import java.text.ParseException;

public class PersonalBDayWish implements BirthDay{

    @Override
    public void sendBdayWish(MailReceivers recipient) throws ParseException, ClassNotFoundException {
     
        String wish= recipient.getName()+" Happy B'day buddy";
        String subject="Personal Birthday Wishes";
        String recipientDetail =recipient.getEmail()+","+subject+","+wish;
        Mail mail =new Mail(recipientDetail);
        mail.send();
        mail.save();

        
    }
    
}
