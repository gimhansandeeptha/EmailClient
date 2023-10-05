import java.text.ParseException;
public class OfficialFriends extends Official {

    private String birthDay;
    
    public OfficialFriends(String recipient){

        super(recipient);
        String[] arr = recipient.split(",");
        this.birthDay=arr[3];
    }

    public void sendBdayWish() throws ParseException, ClassNotFoundException{
        BirthDay birthDay=new OfficialBDayWish();
        birthDay.sendBdayWish(this);
    }
    public String getBirthDay(){
        return birthDay;
    } 

}
