package Hej;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

public class Game {
    private Room r1,r2,r3,r4;
    private GUI gui;
    private Inventory inventory;
    private Player player;
    private Room[] map;
    private Person person;

    private Person jason = new Person("Jason",2,this);
    private Person freddy = new Person("Freddy",1,this);
    private Person sture = new Person("Sture Sventon",0,this);
    private Person persons[] = new Person[3];

    private Container chest = new Container("a_blue_chest",false,true);
    private Container doorOut = new Container("lastdoor",false,true);
    private  Key key = new Key("key#32",true,chest);
    private boolean wongame = false;
    private int position = 0;
    private int chestopen = 0;
    Inventory playerInventory = new Inventory(3);
    public Game() {
        //Setup the game and start the gui
        setupgame();
        gui = new GUI();
       //Commands
        while (true) {
            String command = gui.getCommand();
            String arks[] = command.split(" ");
            if (command != null) {
                if (command.contains("room1")) {
                    position = 0;
                    gui.labels[4].setVisible(false);

                }
                if (position == 3){
                    if (command.contains("room2")) {


                }}else if (command.contains("room2")){
                    position =1;
                }
                if (command.contains("room3")) {
                    position = 2;
                    gui.labels[4].setVisible(false);
                }
                if (command.contains("room4")) {
                    position = 3;
                    gui.labels[4].setVisible(false);
                }
                if (command.contains("grab")){
                    Room active = getActiveRoom();
                    GameObjects item = active.getInventory().grab(arks[1]);
                    playerInventory.addObject(item);
                }
                if (command.contains("putdown")){
                    Room active = getActiveRoom();
                    GameObjects item = playerInventory.grab(arks[1]);
                    active.getInventory().addObject(item);

                }
                //Checks if there is a container in the room you are in and if there is one you try to se if you have the right key for it and if you do it gets unlocked
                if (command.contains("unlock")){
                 GameObjects getchest = getActiveRoom().getInventory().getitem(arks[1],true);
                 if (getchest instanceof Container){
                     Container chest = (Container) getchest;
                      Key findkey =  playerInventory.findkey(chest);
                      if (findkey != null){
                          chest.locked = false;
                          chestopen = 1;
                          if (this.chest.locked == false) {
                              gui.setshowcontainerinventory(chest.getInventory());
                              gui.labels[4].setVisible(true);
                              chestopen = 1;
                          }
                          if (this.doorOut.locked == false){
                              gui.labels[4].setVisible(false);
                              gui.labels[6].setVisible(true);
                              gui.labels[6].setText("<html>You won the game!!");
                              gui.setGamemode(4);
                          }
                      }
                 }
                }
                //if chest is open you can use the command "take" to get items from the chest inventory
                if (command.contains("take") && chestopen ==1 && position == 1){
                    GameObjects item = this.chest.getInventory().grab(arks[1]);
                    playerInventory.addObject(item);
                    gui.setshowcontainerinventory(this.chest.getInventory());
                }
            }
            //Writes everything to the GUI
            gui.setShowRoom(map[position].toString());
            gui.setShowInventory(playerInventory);
            gui.setshowtip();
            if (map[position].getPersons() != null) {
                gui.setShowPersons(map[position].getPersons());
            }
            if (map[position].getPersons() == null) {
                gui.labels[2].setText("There is noone in this room");
            }
        }
 }

    public void setupgame(){
        //here i create the rooms and put them into an array
        r1 = new Room("Room1","You see a chest in one of the corner and some things on the ground:");
        r2 = new Room("Room2","You entered into room number 2. You see concrete walls surrounding you with cracks in the wall 2 doors, the doors are leading to room number 1 and 3. You se some things laying on the floor:");
        r3 = new Room("Room3","You entered room number 3. You see 3 doors one leading into room2 and one int room number 4, then last door seems to be leading out of the dungeon but its locked. You see some things on the ground:");
        r4 = new Room("Room4","You entered room number 4. You see 2 doors one leading to room nr 3 and one leading to room nr 1. You see some things on the ground:");
        map = new Room[4];
        map[0] = r1;
        map[1] = r2;
        map[2] = r3;
        map[3] = r4;
        //creating objects
        GameObjects lamp = new GameObjects("lamp",false);
        GameObjects rock = new GameObjects("rock",true);
        GameObjects stick = new GameObjects("stick",true);
        GameObjects couch = new GameObjects("couch",false);
        GameObjects can = new GameObjects("can",true);
        GameObjects pencil = new GameObjects("pencil",true);
        GameObjects chair = new GameObjects("chair",true);
        GameObjects brokenTv = new GameObjects("brokenTv",true);
        //creating a key
        Key keyout = new Key("key#21",true,doorOut);

        //puting a key into my container chest
        chest.getInventory().addObject(keyout);
        //putting objects into the rooms
        r1.addObject(lamp);
        r1.addObject(stick);
        r2.addObject(couch);
        r2.addObject(chest);
        r2.addObject(can);
        r3.addObject(pencil);
        r3.addObject(chair);
        r3.addObject(doorOut);
        r4.addObject(rock);
        r4.addObject(brokenTv);
        r4.addObject(key);
        //Putting the npcs into the array (person)
        persons[0] = jason;
        persons[1] = freddy;
        persons[2] = sture;
        persons[0].getInventory().addObject(rock);
        //Threads for the npcs
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(10);
        pool.scheduleAtFixedRate(jason, 4, 10, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(freddy, 4, 10, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(sture, 4, 10, TimeUnit.SECONDS);
    }
    public Room getRoom(int i){
        return map[i];
    }
    public Room getActiveRoom() {
        return map[position];
    }

}
