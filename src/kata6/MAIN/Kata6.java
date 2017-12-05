package kata6.MAIN;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {
    
    private List<String> mailList;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException {     
        Kata6 kata = new Kata6();
        kata.execute(); 
    }
    
    private void execute() throws IOException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        String filename = "emailsfile.txt";
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

