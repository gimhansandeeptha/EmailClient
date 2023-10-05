import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {
    private String fileName;

    public TextFile(String fileName) throws IOException{
        this.fileName=fileName;
        try {
            File file = new File(fileName);
            file.createNewFile();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void addRecipientTOFile(String text){

        try{
            FileWriter fstream = new FileWriter(fileName,true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(text+"\n");
            out.close();
            
        }catch (Exception e){
           System.err.println("Error while writing to file: " +
                e.getMessage());
        }

        
    }

    public List<String> getAllRecipients(){  //return a recipient list.
        List<String> recipientList = new ArrayList<>();
        //append all the recipient in text file to this recipientList .

        try {
            File file = new File(fileName);
            Scanner Reader = new Scanner(file);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                recipientList.add(data);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred: file not found.");
            e.printStackTrace();
        }
        return recipientList;
    }
    
}
