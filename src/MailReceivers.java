import java.text.ParseException;

public abstract class MailReceivers {
    String name;
    String email;

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
    public abstract String getDesignation();
    public abstract void sendBdayWish() throws ParseException, ClassNotFoundException;
    public abstract String getBirthDay();
}
