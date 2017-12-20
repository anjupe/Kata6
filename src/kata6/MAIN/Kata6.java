package kata6.MAIN;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {
    
    private List<Mail> mailList;
    private HistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private List<Person> people;
    private HistogramBuilder<Person> builderPerson;
    private Histogram<Character> gender;
    private Histogram<Float> weight;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {     
        Kata6 kata = new Kata6();
        kata.execute(); 
    }
    
    private void execute() throws IOException, ClassNotFoundException, SQLException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException, ClassNotFoundException, SQLException{
        String filename = "emails.txt";
        mailList = MailListReader.read(filename);
        people = DataBaseList.read();
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
        builderPerson = new HistogramBuilder<>(people);
        gender = builderPerson.build(new Attribute <Person, Character>(){
            @Override
            public Character get(Person item){
                return item.getGender();
            }
        });
        weight = builderPerson.build(new Attribute <Person, Float>(){
            @Override
            public Float get(Person item){
                return item.getWeight();
            }
        });        
    }
    
    private void output(){
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer caracter").execute();
        new HistogramDisplay(gender, "Gender").execute();
        new HistogramDisplay(weight, "Weight").execute();
    }    
}