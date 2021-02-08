package Hej;


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


        public int addNpc(Person person){

                this.person[0] = person; //Streama igenom eller loopa för att nu skriver den bara över första positionen 0.

                for (int i = 0; i<this.person.length;i++){
                        if (this.person[i] == null){
                                return i;

                                //stream.filter****
                        }
                }

                return 0;
        }
        public Person getPersons(){
                return this.person[0];//Streama igenom eller loopa för att nu skriver den bara över första positionen 0.
        }

        //Stream för att inte skriva ut null!!
        public void addObject(GameObjects objects) {
                this.inventory.addObject(objects);
        }


        public String toString(){
                return name+ " : "+ decription+"\n" + inventory +" what do you want to do?";
        }

}

