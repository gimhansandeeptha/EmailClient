import java.util.List;
import java.util.Scanner;

public class MailClient {
    public static void main(String[] args) throws Exception {

        TextFile textFile = new TextFile("clientList.txt");
        
        Objects objects = Objects.getInstance();
        List<String>recipientList = textFile.getAllRecipients();
        objects.setExcistingObjects(recipientList);
        
        if (!RunDate.isRunToday()){ 
            BirthDayWish birthDayWish =new BirthDayWish();
            birthDayWish.sendBDayWish();
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        while(true){   // uncomment this while block along with the if block to run this program several times at once.

        System.out.println("Enter option type: \n"
            + "1 - Adding a new recipient\n"
            + "2 - Sending an email\n"
            + "3 - Printing out all the recipients who have birthdays\n"
            + "4 - Printing out details of all the emails sent\n"
            + "5 - Printing out the number of recipient objects in the application"
        );
        
        System.out.println("Press any other number to exit");
        int option = scanner.nextInt();
        if(option<1 || option>5)
            break;

        switch(option){
            case 1:
                // code to add a new recipient
                System.out.println("==========Adding a new recipient==========");
                System.out.println("input format - Official: nimal,nimal@gmail.com,ceo");
                String recipient= scanner2.nextLine();
                AddRecipient addRecipient=new AddRecipient("clientList.txt");
                addRecipient.add(recipient);
                break;
            
            case 2:
            
                // code to send and save an email
                System.out.println("==========Sending an email==========");
                System.out.println("input format - email, subject, content");
                String recipientMail= scanner2.nextLine();
                Mail mail = new Mail(recipientMail);
                mail.send();
                mail.save();
                break;
            
            case 3:
                // code to print recipients who have birthdays on the given date
                System.out.println("input format - yyyy/MM/dd (ex: 2018/09/17)");
                String day= scanner2.nextLine(); 
                BirthDayWish birthDayWish =new BirthDayWish();
                birthDayWish.getBirthDayOn(day);
                break;
            case 4:
                // code to print the details of all the emails sent on the input date
                System.out.println("input format - yyyy/MM/dd (ex: 2018/09/17)"); 
                String date=scanner2.nextLine();
                CheckMail checkMail =new CheckMail();
                checkMail.check(date);
                break;

            case 5:
                // code to print the number of recipient objects in the application
                System.out.println("\nNumber of Objects: "+objects.getNumOfObjects());
                System.out.println();
                break;

        }
        }  // while ends
        scanner.close();
        scanner2.close();    
        
    }
}
