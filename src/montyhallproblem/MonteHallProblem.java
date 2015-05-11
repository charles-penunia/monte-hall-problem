
package montehallproblem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;


/* Charles Penunia. CMPSC 221. 
 * This program simulates the infamous Monte Hall problem.
 */

public class MonteHallProblem {
    public static void main(String[] args) {
        final DoorComponent d1 = new DoorComponent();
        /* Older Java versions require this component to be final */
        
        class DoorOpen implements MouseListener{
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {
                int tempX = e.getX();
                int tempY = e.getY();
                d1.revealDoors(tempX, tempY);
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        }
        
        JFrame frame1 = new JFrame("Monte Hall Problem");
        frame1.setSize(400, 300);
        frame1.setLocation(690, 50);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MouseListener doorAction = new DoorOpen();
        d1.addMouseListener(doorAction);
        frame1.add(d1);
        
        JFrame frame2 = new JFrame("Menu");
        frame2.setSize(400, 90);
        frame2.setLocation(290, 175);
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        Menu menu = new Menu();
        frame2.add(menu);
        
        menu.giveInstructions();
        d1.makeCounterVisible();
        frame2.setVisible(true);
        frame1.setVisible(true);
    }
}
