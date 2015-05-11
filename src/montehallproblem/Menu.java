
package montehallproblem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* Charles Penunia. CMPSC 221.
 * This class creates and contains the menu.
 */

public class Menu extends JPanel{
    public Menu(){
        JButton button1 = new JButton("Instructions");
        button1.addActionListener(new FirstButton());
        add(button1);
        
        JButton button2 = new JButton("FAQs");
        button2.addActionListener(new SecondButton());
        add(button2);
        
        JButton button3 = new JButton("About");
        button3.addActionListener(new ThirdButton());
        add(button3);
    }
    public void giveInstructions(){
        JOptionPane.showMessageDialog(null, 
                "Welcome the the Monte Hall Problem!\n"
                + "Here is how the game works:\n\n"
                + "The player will be shown with three door.\n"
                + "Two doors will contain a goat while the\n"
                + "other door will contain a car.\n\n"
                + "The objective of the game is to choose\n"
                + "a door that has the car.", 
                "Instructions",
                JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, 
                "Here is the twist:\n\n"
                + "When a door is chosen, " 
                + "the host will reveal another door\n"
                + "that contains a goat. " 
                + "Then the host will ask if the player\n"
                + "would like to switch doors.\n\n" 
                + "If the player chooses to switch, then"
                + " the remaining door\n" 
                + "will be open and he/she wins the object "
                + "behind that door.\n" 
                + "If the player chooses not to switch, then "
                + "the door that \n" 
                + "he/she initially chose will be open, " 
                + "and that object is won.", 
                "Instructions",
                JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, 
                "This is the big question:\n\n"
                + "Should the player switch doors or not?",
                "Instructions",
                JOptionPane.PLAIN_MESSAGE);
    }
    public void faq(){
        JOptionPane.showMessageDialog(null, 
            "1) How do I get out of here? The X button doesn't work!\n\n"
            + "Relax man. Go to the Monte Hall Problem window and \n"
            + "click on that X button. The entire program should close.\n\n"
            + "2) Can I type numbers on the counter box fields?\n\n"
            + "DON'T DO IT! Instead, play the game once. The counter will\n"
            + "update automatically. If you wish to clear the boxes, simply\n" 
            + "press the reset button.\n\n"
            + "3) Ugh! Why do I have to wait for the doors to reset? Why\n"
            + "not create a \"Reset Doors\" button?\n\n"
            + "This program is designed to randomly simulate the Monte\n"
            + "Hall Problem. If the doors don't reset, then you can redo the\n"
            + "puzzle knowing the item behind each door. The automatic\n"
            + "reset mechanic prevents that.\n\n"
            + "4) Can you do my homework for me?\n\n"
            + "No.",
            "FAQs",
            JOptionPane.PLAIN_MESSAGE);
    }
    public void about(){
        JOptionPane.showMessageDialog(null, 
                "Version 1.000\n\n"
                + "Charles Penunia\n"
                + "2015",
                "About",
                JOptionPane.PLAIN_MESSAGE);
    }
    class FirstButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            giveInstructions();
        }
    }
    class SecondButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            faq();
        }
    }
    class ThirdButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            about();
        }
    }
}
