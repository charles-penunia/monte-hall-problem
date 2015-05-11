
package montehallproblem;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JOptionPane;

/* Charles Penunia. CMPSC 221. 
 * This class represents a door.
 */

public class Door{
    
    static final int WIDTH = 80;
    static final int HEIGHT = 130;
    
    private String item;
    private int number, x, y;
    private Rectangle rectMain;
    
    public Door(int num, int theX, int theY, String theItem){
        number = num;
        x = theX;
        y = theY;
        item = theItem;
    }
    public void paintDoor(Graphics2D g2){
        rectMain = new Rectangle(x, y, WIDTH, HEIGHT);
        g2.setColor(Color.ORANGE);
        g2.fill(rectMain);
        g2.draw(rectMain);
        
        Rectangle recInner = new Rectangle(x + 10, 
                y + 10, WIDTH - 20, HEIGHT - 20);
        g2.setColor(Color.WHITE);
        g2.fill(recInner);
        g2.draw(recInner);
        
        Ellipse2D.Double knob = new Ellipse2D.Double(x + 15, y + 75, 10, 10);
        g2.setColor(Color.gray);
        g2.fill(knob);
        g2.draw(knob);
        g2.setColor(Color.black);
    }
    public boolean insideDoor(int mouseX, int mouseY){
        return rectMain.contains(mouseX, mouseY);
    }
    public void reveal(){
        JOptionPane.showMessageDialog(null, "a " + item + "!", 
                "Door #" + number + " has...", JOptionPane.PLAIN_MESSAGE);
    }
    public int getWidth(){
        return WIDTH;
    }
    public String getItem(){
        return item;
    }
    public void changeItem(String newItem){
        item = newItem;
    }
    public int getNumber(){
        return number;
    }
}
