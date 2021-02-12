package Hej;

import java.util.Arrays;
import java.util.Objects;

public class Room {
        private String name;
        private String decription;
        private Inventory inventory;
        private Person[] person;
        public int roomnumber = 1;
        private String description;
        public Room(String name, String description ){
                this.person = new Person[5];
                this.name = name;
                this.decription = description;
                this.inventory = new Inventory(10);
        }
        //method for adding an npc
        public boolean addNpc(Person person){
           int i = getFirstEmptyIndex();
            if  (i == -1){
                return false;
            }
            this.person[i] = person;
            return true;
        }
        //gets the first empty space
    private int getFirstEmptyIndex(){
        //Stream sen!! kollar om det finns ledig plats
       for (int i = 0; i<this.person.length;i++){
            if (this.person[i] == null){
                return i;
            }
        }
        return -1;
    }
        public Person[] getPersons(){

                return this.person;
        }
        public Inventory getInventory() {
                return inventory;
        }
        public void addObject(GameObjects objects) {
                this.inventory.addObject(objects);
        }
        public String toString(){
                return name+ " : "+ decription+"\n" + inventory +" what do you want to do?";
        }
        //removes the npcs
        public void removeNpc(Npc npc){
            for (int i = 0; i<this.person.length;i++){
                if (this.person[i] == npc){
                    this.person[i] = null;
                }
            }
        }
}

