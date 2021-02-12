package Hej;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Inventory {
    private GameObjects[] list;
    private int size;
    private Game game;
    public Inventory(int size){
        this.size = size;
        list =new GameObjects[size];
    }
    //Adds an item to whatever inventory i want
    public void addObject(GameObjects go){
        int index = getFirstEmptyIndex();
        if (index ==-1){
            return;
        }
        this.list[index] = go;
    }
    public String toString() {
        //used stream to get null away
        String streamlist = "";
        streamlist = Arrays.toString(Arrays.stream(list).filter(x -> x != null).toArray());
            return streamlist;
    }
    //Same but with forloop
    /*for (int i = 0; i <this.list.length;i++ ){
            if (list[i] != null) {
                newlist += list[i].toString()+" ";

            }
        }return newlist+" :";
       //return Arrays.toString(this.list);
    }*/
    //Gets the first empty spot in the array
    private int getFirstEmptyIndex(){
        //Stream sen!! kollar om det finns ledig plats
        for (int i = 0; i<this.list.length;i++){
            if (this.list[i] == null){
                return i;
            }
        }
        return -1;
    }
    //A grab method that is used if you pick upp or drop items
    public GameObjects grab(String name) {
        return getAndRemove(name, false);
    }
    //checks if the item is there and leets you pick it up if it is and is movable
    GameObjects getAndRemove(String name, boolean ignoreUnmovable) {
        for (int i = 0; i < list.length; i++) {
            GameObjects object = list[i];
            if (object == null) continue;
            if (!object.isMoveAble() && !ignoreUnmovable) continue;
            if (object.getName().equalsIgnoreCase(name)) {
                list[i] = null;
                return object;
            }
        }
        return null;
    }

    GameObjects getitem(String name, boolean ignoreUnmovable) {
        for (int i = 0; i < list.length; i++) {
            GameObjects object = list[i];
            if (object == null) continue;
            if (!object.isMoveAble() && !ignoreUnmovable) continue;

            if (object.getName().equalsIgnoreCase(name)) {
                return object;
            }
        }

        return null;
    }
    //a method used to find the right key you need, and checks if it fit with the container
    Key findkey(Container container) {
        for (int i = 0; i < list.length; i++) {
            GameObjects object = list[i];
            if (object == null) continue;
            if (object instanceof Key) {
                Key key = (Key) object;
                if (key.fit(container)){
                    return key;
                }
            }
        }
        return null;
    }



}
