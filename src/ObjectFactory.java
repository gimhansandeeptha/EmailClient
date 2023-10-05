public class ObjectFactory {
  
    public MailReceivers getInstance(String recipient){ 
        String[] arr = recipient.split(":");

        if (arr[0].equalsIgnoreCase("Official")){
                return new Official(arr[1]);    
        }

        else if (arr[0].equalsIgnoreCase("Office_friend")){
            return new OfficialFriends(arr[1]);
        }
        else if (arr[0].equalsIgnoreCase("Personal")){
            return new Personal(arr[1]);
        }
        else{
            System.out.println("Invalid Format");
            return null;
        }
        
    }
    
}
