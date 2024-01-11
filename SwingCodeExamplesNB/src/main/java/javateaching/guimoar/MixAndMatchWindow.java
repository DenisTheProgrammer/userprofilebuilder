/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javateaching.guimoar;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 *
 * @author paul
 */
public class MixAndMatchWindow extends JFrame 
{
    private FlowLayoutExample fl = new FlowLayoutExample();
    private GridLayoutExample gl = new GridLayoutExample();
    private GridTo500 g500 = new GridTo500();
    
    public MixAndMatchWindow()
    {
        super("Demo of mixing and matching layouts with JPanes");
        this.setLayout(new BorderLayout());                
        this.add(fl,BorderLayout.NORTH);
        this.add(gl,BorderLayout.SOUTH);                        
        
        // try commenting out this...
        this.add(g500,BorderLayout.CENTER);
        
        // and uncommenting these two...
        //JScrollPane scrolly = new JScrollPane(g500);
        //this.add(scrolly,BorderLayout.CENTER);        
        
        // and observe the difference!                
        
        this.setSize(600,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // also try flipping round the positions of the components and
        // see how things work out...
    }    
}
