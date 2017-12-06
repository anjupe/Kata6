package kata6.MAIN;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {
    
    private List<Mail> mailList;
    private HistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    
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
        String filename = "emails.txt";
        mailList = MailListReader.read(filename);
    }
    
    private void process(){
        builder = new HistogramBuilder<>(mailList);
        domains = builder.build(new Attribute<Mail, String>() {
            @Override
            public String get (Mail item) {
                return item.getMail().split("@")[1];
            }
        });
        letters = builder.build(new Attribute< Mail, Character>(){
            @Override
            public Character get(Mail item){
                return item.getMail().charAt(0);
            }
        });
        
    }
    
    private void output(){
        /*HistogramDisplay histoDisplay = new HistogramDisplay(domains, "Dominios");
        histoDisplay.execute();
        histoDisplay = new HistogramDisplay(letters, "Primer caracter");
        histoDisplay.execute();*/
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer caracter").execute();
    }    
}

