
package montehallproblem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/* Charles Penunia. CMPSC 221.
 * This class draws and manages the three doors.
 */

class DoorComponent extends JComponent{
    
    static final int F_DOOR_X = 40;
    static final int F_DOOR_Y = 60;
    static final int DELAY = 900;
    
    private String[] item = {"goat", "goat", "goat"};
    private Door d1, d2, d3;
    private Random generator;
    private JFrame frame;
    private Counter counter;
    private Timer t;
    
    public DoorComponent(){
        generator = new Random();
        int n = generator.nextInt(3);
        item[n] = "car";
        
        d1 = new Door(1, F_DOOR_X, F_DOOR_Y, item[0]);
        d2 = new Door(2, F_DOOR_X + d1.getWidth() + 30,
                F_DOOR_Y, item[1]);
        d3 = new Door(3, F_DOOR_X + 2*(d1.getWidth() + 30), 
                F_DOOR_Y, item[2]);
        
        frame = new JFrame("Counter");
        frame.setSize(400, 125);
        frame.setLocation(290, 50);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        counter = new Counter();
        frame.add(counter);
        
        ActionListener bePatient = new Reset();
        t = new Timer(DELAY, bePatient);
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("Choose a door by clicking on it", 105, 35);
        d1.paintDoor(g2);
        d2.paintDoor(g2);
        d3.paintDoor(g2);
        g2.drawString("After playing the game, wait unit the doors reset",
                60, 235);
    }
    public void revealDoors(int mouseX, int mouseY){
        int notChosenSubscript, randSubscript, choice;
        
        if (d1.insideDoor(mouseX, mouseY)){
            randSubscript = 1 + generator.nextInt(2);
            if (randSubscript == 1 && item[1].equals("goat")){
                d2.reveal();
                notChosenSubscript = 2;
            }
            else if(item[2].equals("goat")){
                d3.reveal();
                notChosenSubscript = 1;
            }
            else{
                d2.reveal();
                notChosenSubscript = 2;
            }
            
            choice = JOptionPane.showConfirmDialog(null, 
                    "You chose door #1. Would you like to switch to door #"
                    + (notChosenSubscript + 1) + "?", 
                    "The host says...", 
                    JOptionPane.YES_NO_CANCEL_OPTION); 
                    // 0 means yes, 1 means no, 2 means cancel
            if (choice == 1){
                d1.reveal();
                if ((d1.getItem()).equals("car"))
                    counter.addCarWin();
                else
                    counter.addGoatWin();
            }
            else if (choice == 0)
                if (notChosenSubscript == 1){
                    d2.reveal();
                    if ((d2.getItem()).equals("car"))
                        counter.addCarWin();
                    else
                        counter.addGoatWin();
                }
                else{
                    d3.reveal();
                    if ((d3.getItem()).equals("car"))
                        counter.addCarWin();
                    else
                        counter.addGoatWin();
                }
            t.start();
        }
        
        else if (d2.insideDoor(mouseX, mouseY)){
            randSubscript = generator.nextInt(3);
            while(randSubscript == 1)
                randSubscript = 1 + generator.nextInt(2);
            if (randSubscript == 0 && item[0].equals("goat")){
                d1.reveal();
                notChosenSubscript = 2;
            }
            else if (item[2].equals("goat")){
                d3.reveal();
                notChosenSubscript = 0;
            }
            else{
                d1.reveal();
                notChosenSubscript = 2;
            }
            
            choice = JOptionPane.showConfirmDialog(null, 
                    "You chose door #2. Would you like to switch to door #"
                    + (notChosenSubscript + 1) + "?", 
                    "The host asks...", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == 1){
                d2.reveal();
                if ((d2.getItem()).equals("car"))
                    counter.addCarWin();
                else
                    counter.addGoatWin();
            }
            else if (choice == 0)
                if (notChosenSubscript == 2){
                    d3.reveal();
                    if ((d3.getItem()).equals("car"))
                        counter.addCarWin();
                    else
                        counter.addGoatWin();
                }
                else{
                    d1.reveal();
                    if ((d1.getItem()).equals("car"))
                        counter.addCarWin();
                    else
                        counter.addGoatWin();
                }
            t.start();
        }
        
        else if (d3.insideDoor(mouseX, mouseY)){
            randSubscript = generator.nextInt(2);
            if (randSubscript == 0 && item[0].equals("goat")){
                d1.reveal();
                notChosenSubscript = 1;
            }
            else if (item[1].equals("goat")){
                d2.reveal();
                notChosenSubscript = 0;
            }
            else{
                d1.reveal();
                notChosenSubscript = 1;
            }
            
            choice = JOptionPane.showConfirmDialog(null, 
                    "You chose door #3. Would you like to switch to door #"
                    + (notChosenSubscript + 1) + "?",
                    "The host asks...", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == 1){
                d3.reveal();
                if ((d3.getItem()).equals("car"))
                    counter.addCarWin();
                else
                    counter.addGoatWin();
            }
            else if (choice == 0)
                if (notChosenSubscript == 0){
                    d1.reveal();
                    if ((d1.getItem()).equals("car"))
                        counter.addCarWin();
                    else
                        counter.addGoatWin();
                }
                else{
                    d2.reveal();
                    if ((d2.getItem()).equals("car"))
                        counter.addCarWin();
                    else
                        counter.addGoatWin();
                }
            t.start();
        }
    }
    public void resetDoors(){
        for (int i = 0; i <= 2; i++)
            item[i] = "goat";
        int j = generator.nextInt(3);
        item[j] = "car";
        
        d1.changeItem(item[0]);
        d2.changeItem(item[1]);
        d3.changeItem(item[2]);
        
        t.stop();
        JOptionPane.showMessageDialog(null, "The doors have been reset.");
    }
    class Reset implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            resetDoors();
        }
    }
    public void makeCounterVisible(){
        frame.setVisible(true);
    }
}
