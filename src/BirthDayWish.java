import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class BirthDayWish {

    
    public void sendBDayWish() throws ClassNotFoundException, ParseException{ 
        Date date=new Date();
        SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
        String today = formate.format(date);

        ArrayList<MailReceivers> birthdayPeople=BirthDayWish.getBirthdayArr(today);
        if(birthdayPeople.isEmpty()){
            return;
        }
        
        System.out.println("=========== Sending Birthday Wishes ========== ");
        for (MailReceivers birthPerson:birthdayPeople){
            birthPerson.sendBdayWish();
        }
        
    }

    public void sendBDayWish(MailReceivers recipient) throws ClassNotFoundException, ParseException{
        String birthday =recipient.getBirthDay();
        if (birthday!=null){
            
            Date date=new Date();
            SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
            String today = formate.format(date);
            String croppedBirthday = birthday.substring(5);
            String croppedToday= today.substring(5);
            
            if (croppedBirthday.equals(croppedToday)){

                System.out.println("==========sending birthday wish==========");
                System.out.println(recipient.name);
                recipient.sendBdayWish();
            }
        }
    }

    private static ArrayList<MailReceivers> getBirthdayArr(String date){
        Objects objects =Objects.getInstance();
        List<MailReceivers> mailReceivers=objects.getAllReceivers();
        ArrayList<MailReceivers> birthdayPeople=new ArrayList<>();
        
        for(MailReceivers recipient:mailReceivers){
            if (recipient.getBirthDay()!=null){
                String day = recipient.getBirthDay().substring(5);
                String givenDay = date.substring(5);
                if (day.equals(givenDay)){
                    birthdayPeople.add(recipient);
                }
            }
        }

        return birthdayPeople;

    }

    public void getBirthDayOn(String date){ //assume user wants to know who has birthdays in future
        ArrayList<MailReceivers> birthdayPeopleArr = BirthDayWish.getBirthdayArr(date);
        
        for (MailReceivers birthPerson:birthdayPeopleArr){
            System.out.println(birthPerson.getName()+" "+birthPerson.getBirthDay());
        }
    }


}
