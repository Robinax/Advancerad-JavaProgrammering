package Hej;


import java.util.concurrent.ThreadLocalRandom;

public class Person extends Npc{
    private long pickupItem;
    private long changeRoom = System.currentTimeMillis();
    private int position;
    //Tar in en person och sätter den i en start position

    public Person(String name, int startRoom) {
        super(name);
        this.position = startRoom;

    }



}
