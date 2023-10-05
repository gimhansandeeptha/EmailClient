import java.util.ArrayList;
import java.util.List;

public class Objects {
    /*  initially create all the objects and if we add new recipient 
    this class also create another object for that also.*/
    private static int numOfObjects=0; 
    private static Objects objects = new Objects();
    private static List<MailReceivers> objectList = new ArrayList<>();
    static ObjectFactory objectFactory = new ObjectFactory();
    
    public static Objects getInstance(){
        return objects;
    }

    private Objects(){ 

    }

    public void setExcistingObjects(List<String> recipientList){ 
        // initially this should call.
        //iterate through the array list and create objects one by one.
        
        for(String recipient:recipientList){
            objectList.add(objectFactory.getInstance(recipient));
            numOfObjects++;
        }   
    }
    
    public void setNewObject(String recipient){ 
        // if we add new recipient at run time, this shoud call.
        objectList.add(objectFactory.getInstance(recipient));
        numOfObjects++;
    }

    public MailReceivers getNewlyAddObject(){
        return objectList.get(numOfObjects-1);
    }

    public List<MailReceivers> getAllReceivers(){
        return objectList;
    }

    public int getNumOfObjects(){
        return numOfObjects;
    }
    
}
