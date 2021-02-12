package Hej;


public class Person extends Npc implements Runnable {
String name;
GUI gui;
    private int position =0;
    int current;
    private Game game;

    Inventory inventory;
    //Tar in en person och sätter den i en start position

    public Person(String name, int startRoom, Game game) {
        super(name);
        this.name = name;
        this.position = startRoom;
        this.inventory = new Inventory(1);
        this.game = game;

    }
    //Starting the thread for the npc's
    @Override
    public void run() {
        //Getting current position that the npc have
        this.current = this.position;
        int rand = (int)(Math.random()*4);
        //Getting the new possition that they are walking to
        this.position = rand;
        try {
            //Adding a npc to the new room and removing the npcs from the last position
            game.getRoom(this.current).removeNpc(this);
            game.getRoom(this.position).addNpc(this);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
