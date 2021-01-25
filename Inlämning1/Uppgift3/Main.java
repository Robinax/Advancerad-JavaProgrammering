package Hej;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        boolean bool =false;
        String[] names = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth", "Joshua", "Kevin", "Brian", "George", "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan", "Jacob", "Gary", "Nicholas", "Eric", "Jonathan", "Stephen", "Larry", "Justin", "Scott", "Brandon", "Benjamin", "Samuel", "Frank", "Gregory", "Raymond", "Alexander", "Patrick", "Jack", "Dennis", "Jerry",};
        List<MyObject> objects = new ArrayList<>(); //skapar listan
        List<MyObject> objects1 = new ArrayList<>(); //skapar listan

        for(int i = 0; i<50; i++){
            int val=(int)(Math.random()*50)+1;
            int rName=(int)(Math.random()*49)+1;
            int boo=(int)(Math.random()*2)+1;
            if (boo ==2){
                bool = true;
            }else{
                bool = false;
            }


            MyObject gs = new MyObject(bool, val, names[rName]); //gör en instance av objektet med värdena
            objects.add(gs); //lägger in objektet i listan

        }


        System.out.println("1:"+Arrays.toString(objects
                .stream()
                .filter(s-> s.getValue()>20)

                .toArray()));


        System.out.println("2 Average: " + objects
                .stream()
                .mapToInt(x -> x
                .getValue())
                .average()
                .getAsDouble());



        Arrays.toString((objects.stream().filter(x-> x.isBool()).map(x -> x.name = "this is true").toArray()));

        System.out.println("3:"+ objects);

        System.out.println("eller");


        System.out.println("3:"+Arrays.toString(objects
                .stream()
                .filter(x-> x.isBool())
                .map(x ->x.name ="this is true")
                .toArray()));

    }
}