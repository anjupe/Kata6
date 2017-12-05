package kata6.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    public static List<String> read (String filename) throws FileNotFoundException, IOException{
        List<String> mailList = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        String mail;
        while ((mail = reader.readLine()) != null){
            if (mail.contains("@")){
                mailList.add(mail);
            }
        }
        reader.close();
        return mailList;
    }

}
