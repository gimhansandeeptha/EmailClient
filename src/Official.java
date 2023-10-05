import java.text.ParseException;

public class Official extends MailReceivers{

    private String designation;
    
    public Official(String recipient){
        String[] arr = recipient.split(",");

        this.name = arr[0]; 
        this.email=arr[1];
        this.designation = arr[2];
    }

    public String getDesignation(){
        return this.designation;
    }

    public String getBirthDay(){
        return null;
    }
    public void sendBdayWish() throws ParseException, ClassNotFoundException{
        return ;
    }

    
}
