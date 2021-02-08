package Hej;
import java.io.IOException;
public class Game {
    private Room r1,r2,r3,r4;
    private GUI gui;
    private Inventory inventory;
    private Player player;
    private Room[] map;
    private int position = 0;
    Inventory playerInventory = new Inventory(3);
    GameObjects lamp = new GameObjects("lamp",false);
    GameObjects rock = new GameObjects("rock",true);
    public Game() {

        setupgame();

        gui = new GUI();

       //Commands
        while (true) {
            String command = gui.getCommand();
            if (command != null) {
                if (command.contains("room1")) {
                    position = 0;
                }
                if (command.contains("room2")) {
                    position = 1;
                }
                if (command.contains("room3")) {
                    position = 2;
                }
                if (command.contains("room4")) {
                    position = 3;
                }
                if (command.contains("grab")){

                  inventory.moveObject(playerInventory,rock);

                }

            }
            gui.setShowRoom(map[position].toString());
            gui.setShowInventory(playerInventory);


            if (map[position].getPersons() != null) {
                gui.setShowPersons(map[position].getPersons());
            }
            if (map[position].getPersons() == null) {
                gui.labels[2].setText("There is noone in this room");
            }

        }
 }
    /*public void updatePlayer() {
        gui.setShowInventory(playerInventory);
    }*/
    public void setupgame(){
        //Skappar rummen och sätter in dem i en array(map)
        r1 = new Room("Room1","You see a chest in one of the corner and some things on the ground:");
        r2 = new Room("Room2","You entered into room number 2. You see concrete walls surrounding you with cracks in the wall 2 doors, the doors are leading to room number 1 and 3. You se some things laying on the floor:");
        r3 = new Room("Room3","You entered room number 3. You see 3 doors one leading into room2 and one int room number 4, then last door seems to be leading out of the dungeon but its locked. You see some things on the ground:");
        r4 = new Room("Room4","You entered room number 4. You see 2 doors one leading to room nr 3 and one leading to room nr 1. You see some things on the ground:");
        map = new Room[4];
        map[0] = r1;
        map[1] = r2;
        map[2] = r3;
        map[3] = r4;


        //Skappar objects
        GameObjects lamp = new GameObjects("lamp",false);
        GameObjects rock = new GameObjects("rock",true);
        GameObjects stick = new GameObjects("stick",true);
        GameObjects couch = new GameObjects("couch",false);
        GameObjects can = new GameObjects("can",true);
        GameObjects pencil = new GameObjects("pencil",true);
        GameObjects chair = new GameObjects("chair",true);
        GameObjects brokenTv = new GameObjects("brokenTv",true);
        //Lägger in objekten i rummen
        r1.addObject(lamp);
        r1.addObject(stick);
        r2.addObject(couch);
        r2.addObject(can);
        r3.addObject(pencil);
        r3.addObject(chair);
        r4.addObject(rock);
        r4.addObject(brokenTv);

        //Skapar npc's, ger dem namn och start position
        Person jason = new Person("Jason",0);
        Person freddy = new Person("Freddy",0);
        Person sture = new Person("Sture Sventon",0);

        //Lägger in dem i rum
        r2.addNpc(jason);
        r3.addNpc(freddy);
        r4.addNpc(sture);










    }


    public Room[] getMap() {
        return this.map;
    }

    public Room getActiveRoom() {
        return map[position];
    }

    public Player getPlayer() {
        return player;
    }

    public int getActiveRoomIndex() {
        return this.position;
    }







}
