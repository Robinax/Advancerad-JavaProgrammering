package Hej;
public class Container extends GameObjects {
    private Inventory inventory;
    boolean locked;
    public Container(String name, Boolean moveAble, boolean locked){
        super(name,moveAble);
        this.inventory = new Inventory(3);
        this.locked = locked;
    }
    //Locked method
    public boolean isLocked() {
        return this.locked;
    }
    //containers inventory
    public Inventory getInventory(){
        return this.inventory;
    }
}