import java.io.IOException;
import java.text.ParseException;

public class AddRecipient {
    private TextFile textFile;
    public AddRecipient(String fileName) throws IOException{
        this.textFile = new TextFile(fileName);
    }

    public void add(String recipient) throws ClassNotFoundException, ParseException{
        Objects object = Objects.getInstance();
        object.setNewObject(recipient);
        
        BirthDayWish birthDayWish=new BirthDayWish();
        birthDayWish.sendBDayWish(object.getNewlyAddObject());
       
        textFile.addRecipientTOFile(recipient);


    }
}
