import java.util.ArrayList;

public class CheckMail {
    public void check (String date) throws ClassNotFoundException{
        ArrayList<Mail> mailArr=SerializdMail.getSavedMails("object.ser");
        boolean flag=false;
        for(int i=0;i<mailArr.size();i++){
            if (mailArr.get(i).getSendDate().equals(date)){
                System.out.println("Recipient: "+mailArr.get(i).getRecipient());
                System.out.println("Subject: "+mailArr.get(i).getSubject());
                System.out.println();
                flag=true;
            }
        }
        if (!flag){
            System.out.println("No email sent on "+date);
        }
        
    }
    
}
