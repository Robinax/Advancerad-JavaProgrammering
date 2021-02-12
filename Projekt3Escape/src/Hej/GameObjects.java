package Hej;

public class GameObjects {
    private String name;
    boolean moveAble;

    public GameObjects(String name, boolean moveAble){
        this.name = name;
        this.moveAble = moveAble;


    }
    public boolean isMoveAble(){

        return this.moveAble;
    }
    public String getName(){
        return this.name;
    }


    public String toString(){
        return this.name;
    }


    }



