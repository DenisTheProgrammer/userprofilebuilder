/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author 
 */
public class Controller implements ActionListener, MouseListener
{
    private static Controller oneInstance ;//= new Controller();

    public static Controller getInstance() {
        if (oneInstance == null){
            oneInstance = new Controller();
        }
        return oneInstance;
    }

    // singleton pattern
    private Controller()
    {
        
    }

    public void actionPerformed(ActionEvent ae)
    {
       
        System.out.println(ae.getActionCommand());
        if (ae.getActionCommand().equals("clickme")) {
            GridTo500 g500 = new GridTo500();
            JFrame newWindow = new JFrame("New");
            newWindow.add(g500);
            newWindow.setSize(500, 500);
            newWindow.setVisible(true);
        }
        if (ae.getActionCommand().equals("abc"))
        {
            System.out.println("hello");
        }
    }

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
