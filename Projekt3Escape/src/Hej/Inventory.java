package Hej;

import java.util.Arrays;

public class Inventory {
    private GameObjects[] list;
    private int size;
    public Inventory(int size){
        this.size = size;
        list =new GameObjects[size];
    }
    //lägger till saker till listan//inventory
    public void addObject(GameObjects go){
        int index = getFirstEmptyIndex();
        //om det är fullt
        if (index ==-1){
            System.out.println("inventory is full");
            return;
        }

        this.list[index] = go;
    }

    //Skicka in det inventory du har just nu och sen lägger man det till det inventoryt som du beffiner dig i
    public void moveObject(Inventory i2, GameObjects go){
        //if (!isObjectHere(go)){felmeddelande} finns den i detta inventoryt. allt ligger i listan, är det där bra annars felmedelande
        i2.addObject(go);
        //this.removeObject(go);
    }

    public String toString(){
        return Arrays.toString(this.list);
    }
    private int getFirstEmptyIndex(){
        //Stream sen!! kollar om det finns ledig plats
        for (int i = 0; i<this.list.length;i++){
            if (this.list[i] == null){
                return i;


                //stream.filter****
            }
        }

        return -1;
    }


}
