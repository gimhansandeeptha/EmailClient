import java.text.ParseException;

public interface BirthDay {
    void sendBdayWish(MailReceivers recipient) throws ParseException, ClassNotFoundException;
}
