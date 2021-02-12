package Hej;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {


    public int gamemode = 1;
    private Game game;
    JButton[] buttons = new JButton[4];
    JLabel[] labels = new JLabel[7];
    JLabel background;
    JTextField input;
    String command = "";
    boolean gotCommand =false;


ImageIcon img;
    //ImageIcon img = new ImageIcon("Media/BackgroundStart.jpg");
    public GUI() {

        //Background label/Window

        setSize(1200, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 700);
        add(background);




        //Buttons
        buttons[0] = new JButton("Start");
        buttons[0].setActionCommand("Start");
        MessageListener Start = new MessageListener();
        buttons[0].addActionListener(Start);
        buttons[0].setBounds(550, 100, 100, 50);

        buttons[1] = new JButton("Exit");
        buttons[1].setActionCommand("Exit");
        MessageListener Exit = new MessageListener();
        buttons[1].addActionListener(Exit);
        buttons[1].setBounds(550, 500, 100, 50);

        buttons[2] = new JButton("Next");
        buttons[2].setActionCommand("Next");
        MessageListener Next = new MessageListener();
        buttons[2].addActionListener(Next);
        buttons[2].setVisible(false);
        buttons[2].setBounds(550, 500, 100, 50);


        buttons[3] = new JButton("Commit");
        buttons[3].setActionCommand("Commit");
        MessageListener Commit = new MessageListener();
        buttons[3].addActionListener(Next);
        buttons[3].setVisible(false);
        buttons[3].setBounds(700, 475, 200, 50);


        setVisible(true);
        //Labels
        labels[0] = new JLabel();
        labels[0].setBounds(20, 30, 200, 100);
        labels[0].setFont(new Font("Arial", Font.PLAIN, 16));
        labels[0].setForeground(Color.red);
        labels[0].setVisible(false);

        labels[1] = new JLabel("<html> You walked home from work and decided to take a shortcut trough a dark forrest. You felt like something were watching you so you started running. After running for a while you cam home and locked the door as fast as you could. You then decided to go and take a shower and then straight to bed. You wake upp and have a headache, you start to look around you and you see some figures standing around you. Its very dark and you start to hear the figures start to talk with you. You then notice that they are people that woke upp right next to you and have been searching for a way out. You start to look around the room and see that there are 4 rooms with no windows. there are a lot of furniture around and a lot of things on the ground. there is a door at the end of room1. The people tell you that its looked. They introduce themself to you, their name is Jason,Freddy and Ture Sventon. You decide with them that they need to escape");
        labels[1].setBounds(350,100,400,500);
        labels[1].setFont(new Font("Arial", Font.PLAIN, 16));
        labels[1].setForeground(Color.ORANGE);
        labels[1].setVisible(false);

        labels[2] = new JLabel();
        labels[2].setBounds(20,130,200,200);
        labels[2].setFont(new Font("Arial", Font.PLAIN, 16));
        labels[2].setForeground(Color.red);
        labels[2].setVisible(false);


        labels[3] = new JLabel();
        labels[3].setBounds(500, 100, 250, 200);
        labels[3].setFont(new Font("Arial", Font.PLAIN, 16));
        labels[3].setForeground(Color.red);
        labels[3].setVisible(false);

        labels[4] = new JLabel();
        labels[4].setBounds(900, 100, 250, 200);
        labels[4].setFont(new Font("Arial", Font.PLAIN, 16));
        labels[4].setForeground(Color.red);
        labels[4].setVisible(false);

        labels[5] = new JLabel();
        labels[5].setBounds(50, 400, 250, 200);
        labels[5].setFont(new Font("Arial", Font.PLAIN, 15));
        labels[5].setForeground(Color.red);
        labels[5].setVisible(false);

        labels[6] = new JLabel();
        labels[6].setBounds(500, 100, 250, 200);
        labels[6].setFont(new Font("Arial", Font.PLAIN, 40));
        labels[6].setForeground(Color.red);
        labels[6].setVisible(false);






        //Text input field
        input = new JTextField("Give command");
        input.setBounds(500,450,200,100);
        input.setVisible(false);






//adds everything to the window
        background.add(buttons[0]);
        background.add(buttons[1]);
        background.add(buttons[2]);
        background.add(buttons[3]);
        background.add(labels[1]);
        background.add(labels[0]);
        background.add(labels[2]);
        background.add(labels[3]);
        background.add(labels[4]);
        background.add(labels[5]);
        background.add(labels[6]);
        background.add(input);
                //For loops that changes more than 1 thing at the time
        //Loop for the Meny!





       for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 30));
            buttons[i].setForeground(Color.red);
        }

        //uppdates
        update();

    }


    public void update() {
        if (gamemode == 1) {
            buttons[0].setVisible(true);
            buttons[1].setBounds(550, 500, 100, 50);
            buttons[2].setVisible(false);
            img = new ImageIcon("Media/backgroundstart.jpg");
            background.setIcon(img);
            labels[1].setVisible(false);


        }

        if (gamemode == 2) {

            buttons[0].setVisible(false);
            buttons[1].setBounds(800, 600, 100, 50);
            buttons[2].setVisible(true);
            img = new ImageIcon("Media/backgroundnext.jpg");
            background.setIcon(img);
            labels[1].setVisible(true);


        }
        if (gamemode == 3){
            for (int i = 0; i < buttons.length; i++){
                buttons[i].setVisible(false);

            }

            labels[1].setVisible(false);
            img = new ImageIcon("Media/backgroundgame.jpg");
            background.setIcon(img);
            buttons[3].setVisible(true);
            labels[0].setVisible(true);
            labels[2].setVisible(true);
            labels[3].setVisible(true);
            labels[5].setVisible(true);
            input.setVisible(true);
            buttons[3].setFont(new Font("Arial", Font.PLAIN, 20));

        }
        if (gamemode == 4){
            for (int i = 0; i < buttons.length; i++){
                buttons[i].setVisible(false);
            }
            for (int x = 0; x < 6; x++){
                labels[x].setVisible(false);
            }
        }



    }
    public void setShowRoom(String roomDescribtion){
        this.labels[3].setText("<html>"+roomDescribtion);
    }
    public void setShowPersons(Person[] persons){

        String person = "";
        for (Npc npc : persons) {
            if (npc == null) continue;
            person += npc.toString();
        }
        this.labels[2].setText("<html>In this room you see:<br>"+person);
    }
    public void setShowInventory(Inventory i){
        this.labels[0].setText("<html>You are holding: "+i.toString());
    }
    public void setshowcontainerinventory(Inventory chest){
        this.labels[4].setText("<html>This are in the chest:" + chest.toString());
    }
    public void setshowtip(){
        this.labels[5].setText("<html>You can move around the rooms by typing room1 - room4. <br> You can grab items with \"grab\" and putdown with \"drop\".<br>You can unlock chests or door withe the right key with the command \"unlock\". To take items from a chest you need to type \"take\" instead of grab");
    }


    public void setPerson(Person p){
        this.labels[2].setText(p.toString());
    }

    //Commands!

    class MessageListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Exit")) {
                System.exit(0);
            }
            if (e.getActionCommand().equals("Start")) {
                gamemode = 2;
                update();
            }
            if (e.getActionCommand().equals("Next")) {
                gamemode = 3;
                update();
            }
            if (e.getActionCommand().equals("Commit")){
                command = input.getText();
                gotCommand = true;

            }

            }

        }
    public String getCommand() {
        try {
            if (this.gotCommand) {
                return this.command;

            }
            return "";
        } catch (Exception e) {
            return "";
        }finally {
            this.gotCommand = false;
        }


    }

    public void setGamemode(int gamemode) {
        this.gamemode = gamemode;
        update();
    }
}





