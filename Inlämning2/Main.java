package Hej;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static int timesShow = 0;
    public static void main(String[] args) throws FileNotFoundException {


        //creating File instance to reference text file in Java
        File text = new File("Media/text.txt");

        //Creating Scanner instnace to read File in Java
        Scanner scnr = new Scanner(text);

       /*1  Alfabetet*/                  //String pattern = "a+b+c+d+e+f+g+h+i+j";
       /*2  Olas namn*/                  //String pattern = "Ola";
       /*3  3-5 a*/                      // String pattern = "[a]{3,5}";
       /*4 Leta reda på alla symboler */ // String pattern = "[\\W]{2,}";
       /*5 Leta efte Mail */            //  String pattern = "[A-Za-z0-9.%-]+@[A-Za-z0-9.%-]+\\.[A-Za-z]{2,3}";
       /*6 Leta efter telefon numer*/   // String pattern = "\\d{2,5}[0-9+, -/]\\d{5,}";
       /*7  Leta efter bokstäver som är lika*/ // String pattern = "([a-zA-Z])\\1{3}";
       /*8 registreringsnummer*/        // String pattern = "[A-Za-z]{3}+[/_}+[0-9]{3}";
       /*9 paranteser*/                 //String pattern = "\\((.*?)\\)";
       /*10 if-satser */                 String pattern = "if[(].+[}]|for[(].+[}]";


        //Reading each line of file using Scanner class
        int lineNumber = 1;
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();

            lineNumber++;

            finder(line,pattern,lineNumber);




        }
        System.out.println("How many times the word came: "+timesShow);



    }
    public static void finder(String myString, String pattern, int linenumber){
        Pattern p = Pattern.compile(pattern);
        Matcher matcer = p.matcher(myString);

        while(matcer.find()){
            if (matcer.group().length() !=0) {
               // System.out.println("Line:"+linenumber+" , "+ matcer.start()+"-"+matcer.end()+ ":"+" There is:" + matcer.group()+" This is the only place i can find something close to the alphabet");
              //  System.out.println("Line:"+linenumber + ", "+ matcer.start()+"-"+matcer.end()+ ":" + matcer.group());  //Olas namn
              // System.out.println("Line:"+linenumber + ", "+ matcer.start()+"-"+matcer.end()+ ":" + matcer.group());  // 3-5 a
              // System.out.println("Line:"+linenumber + ":" + matcer.group()+" The signs are on place: "+matcer.start()+" and "+ matcer.end()+" on the line");
               // System.out.println("Line:"+linenumber + ":Email:" + matcer.group()); //Emails
               // System.out.println("Line:"+linenumber + ": " + matcer.group());  //Telefon nummer
              //  System.out.println("Line:"+linenumber + ": " + matcer.group()); //Leta efter bokstäver som är lika
              //  System.out.println("Line:"+linenumber + ": " + matcer.group()); //registreringsnummer
               // System.out.println("Line:"+linenumber + ": " + matcer.group()); //paranteser
                System.out.println("Line:"+linenumber + ": " + matcer.group()); //if-satser

                timesShow++;

            }
        }




    }



}
