package Hej;

public class Key extends GameObjects {
    Container container;
    public Key(String name, Boolean moveAble, Container c){
        super(name,moveAble);
        this.container = c;
    }
    //Checking if the key fit the container by getting the name equal to the key name
    public boolean fit (Container c){
        if (this.container.getName().equals(c.getName())){
            return true;
        }
        else{
            return false;
        }
    }
}
