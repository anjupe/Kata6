package kata4.MAIN;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    
    private List<String> mailList;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException {     
        Kata4 kata = new Kata4();
        kata.execute(); 
    }
    
    private void execute() throws IOException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        String filename = "C:\\Users\\Experimentos\\Documents\\NetBeansProjects\\Kata4\\emailsfile.txt";
        mailList = MailListReader.read(filename);
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }    
}

