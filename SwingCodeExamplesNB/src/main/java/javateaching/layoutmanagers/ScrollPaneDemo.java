/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javateaching.layoutmanagers;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author 
 */
public class ScrollPaneDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //JPanel jp = new FlowLayoutExample();
        //JPanel jp = new GridLayoutExample();
        //JPanel jp = new BorderLayoutExample();
        //JPanel jp = new MigLayoutExample();
        GridTo500 g500 = new GridTo500();
        JFrame mainWindow = new JFrame("ScrollPane Manager Demo");
        JScrollPane js = new JScrollPane(g500);
        mainWindow.add(js);
        mainWindow.pack();
        //mainWindow.setBounds(50,50,600,600);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
