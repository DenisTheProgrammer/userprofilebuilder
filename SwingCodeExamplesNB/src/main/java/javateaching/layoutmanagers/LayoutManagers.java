/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class LayoutManagers  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //  JPanel jp = new FlowLayoutExample();
        //JPanel jp = new GridLayoutExample();
       JPanel jp = new BorderLayoutExample();
       // JPanel jp = new MigLayoutExample();
        //JPanel jp = new GridTo500();
        JFrame mainWindow = new JFrame("Layout Manager Demo");
        System.out.println(mainWindow);
        mainWindow.add(jp);
        mainWindow.pack();
//        mainWindow.setBounds(50,50,600,600);
        mainWindow.setVisible(true);
        Object o = new Object();
        System.out.println(o.toString());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
