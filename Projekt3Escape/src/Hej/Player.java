package Hej;


public class Player {
    private Inventory inventory;

    public Player(){

        this.inventory = new Inventory(3);
    }
    public Inventory inventory(){
        return inventory;
    }
    public String toString(){
        return "Player inventory:" + inventory;
    }

}
