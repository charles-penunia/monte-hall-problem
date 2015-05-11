
package montehallproblem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* Charles Penunia. CMPSC 221.
 * This class creates and manages the counter.
 */

public class Counter extends JPanel{
    
    private JTextField carsWonField, goatsWonField, totalPlaysField,
            carsWonPctField, goatsWonPctField;
    private int carsWon, goatsWon, totalPlays;
    private double carsWonPct, goatsWonPct;
    
    public Counter(){
        add(new JLabel("Cars won:"));
        carsWonField = new JTextField("0      ");
        add(carsWonField);
    
        add(new JLabel(" Goats won:"));
        goatsWonField = new JTextField("0      ");
        add(goatsWonField);
    
        add(new JLabel(" Total plays:"));
        totalPlaysField = new JTextField("0      ");
        add(totalPlaysField);
    
        add(new JLabel("Cars won percentage:"));
        carsWonPctField = new JTextField("             ");
        add(carsWonPctField);
    
        add(new JLabel(" Goats won percentage:"));
        goatsWonPctField = new JTextField("             ");
        add(goatsWonPctField);
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ResetListener());
        add(resetButton);
    }
    class ResetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            carsWon = 0;
            carsWonField.setText("0      ");
            goatsWon = 0;
            goatsWonField.setText("0      ");
            totalPlays = 0;
            totalPlaysField.setText("0      ");
            carsWonPct = 0.0;
            carsWonPctField.setText("             ");
            goatsWonPct = 0.0;
            goatsWonPctField.setText("             ");
        }
    }
    public void addCarWin(){
        carsWon++;
        carsWonField.setText("" + carsWon);
        totalPlays++;
        totalPlaysField.setText("" + totalPlays);
        
        carsWonPct = (double) carsWon/totalPlays;
        carsWonPctField.setText("" + String.format("%6.2f", 
                carsWonPct * 100.0));
        
        goatsWonPct = (double) goatsWon/totalPlays;
        goatsWonPctField.setText("" + String.format("%6.2f", 
                goatsWonPct * 100.0));
    }
    public void addGoatWin(){
        goatsWon++;
        goatsWonField.setText("" + goatsWon);
        totalPlays++;
        totalPlaysField.setText("" + totalPlays);
        
        carsWonPct = (double) carsWon/totalPlays;
        carsWonPctField.setText("" + String.format("%6.2f", 
                carsWonPct * 100.0));
        
        goatsWonPct = (double) goatsWon/totalPlays;
        goatsWonPctField.setText("" + String.format("%6.2f", 
                goatsWonPct * 100.0));
    }
}
