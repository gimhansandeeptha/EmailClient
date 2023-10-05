import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SerializdMail implements Serializable {
    private static ArrayList<Mail> mailArr = new ArrayList<>();
    private String fileName;
    
    public SerializdMail(String fileName){
        this.fileName=fileName;
    }

    public void saveMail(Mail mail) throws ClassNotFoundException{

        try {
            mailArr=(SerializdMail.getSavedMails(fileName));
            mailArr.add(mail);

            FileOutputStream file=new FileOutputStream(fileName);
            ObjectOutputStream out=new ObjectOutputStream(file);
            out.writeObject(mailArr);

            out.close();
            file.close();

        } 
        catch(IOException ex)
        {
            System.out.println("IOException");
        }

    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Mail> getSavedMails(String fileName) throws ClassNotFoundException{
        ArrayList<Mail> savedMailArr=new ArrayList<>();
        try {
            FileInputStream file=new FileInputStream(fileName);//fileName="object.ser"
            ObjectInputStream in=new ObjectInputStream(file);
            savedMailArr=(ArrayList<Mail>)in.readObject();

            in.close();
            file.close();

        }
        catch(IOException ex)
        {
            System.out.println("***");
        }

        return savedMailArr;
    }
}
