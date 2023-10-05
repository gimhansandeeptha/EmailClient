import java.text.ParseException; 

public class Personal extends MailReceivers{
    
    private String nickName;
    private String birthDay;
    
    public Personal(String recipient){
        String[] arr = recipient.split(",");

        this.name = arr[0]; // this should be one part of recipient String
        this.nickName = arr[1];
        this.email= arr[2];
        this.birthDay=arr[3];
        
    }

    public void sendBdayWish() throws ParseException, ClassNotFoundException{
        BirthDay birthDay =new PersonalBDayWish();
        birthDay.sendBdayWish(this);
    }

    public String getBirthDay(){
        return birthDay;
    }
    public String getNickName(){
        return nickName;
    }

    @Override
    public String getDesignation() {
        return null;
    }
    

}
