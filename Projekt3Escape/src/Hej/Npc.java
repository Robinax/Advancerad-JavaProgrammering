package Hej;

public abstract class Npc implements Runnable{
    private String name;
    private Inventory inventory;

    public Npc(String name){
        this.name = name;
        this.inventory = new Inventory(1);
    }

    public Inventory getInventory() {
        return this.inventory;
    }
    @Override
    public String toString (){
        return this.name + " is carrying:" + this.inventory;
    }


}