import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class RunDate {
    public static boolean isRunToday() throws IOException{
        Date date=new Date();
        SimpleDateFormat formate = new SimpleDateFormat("yyyy/MM/dd");
        String today = formate.format(date);

        String runDate;
        try{
            FileReader file = new FileReader("today.txt");
            BufferedReader buffer = new BufferedReader(file);
            //read the 1st line
            runDate = buffer.readLine();

            buffer.close();
            file.close();

        }
        catch(FileNotFoundException e){
            FileWriter fstream = new FileWriter("today.txt",false);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(today);
            fstream.close();
            return false;
        }
        

        try{
            FileWriter fstream = new FileWriter("today.txt",false);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(today);
            out.close();
        }catch (Exception e){
           System.err.println("Error while writing to file: " +e.getMessage());
        }

        if (today.equals(runDate)){
            return true;
        }
        return true;
    }
    
}
