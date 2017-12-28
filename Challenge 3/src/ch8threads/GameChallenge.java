/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class GameChallenge{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        JFrame jf=new JFrame();
        jf.setSize(600, 600);
        
        MovingBalls mb=new MovingBalls();
        mb.Balls.add(new Ball());
        mb.Balls.add(new Ball(100,100,1,1,Color.ORANGE));
        mb.Balls.add(new Ball(300,160,1,1,Color.red));
        mb.Balls.add(new Ball(450,180,1,1,Color.CYAN));
        mb.Balls.add(new Ball(500,220,1,1,Color.magenta));
        mb.Balls.add(new Ball(120,120,1,1,Color.BLACK));
         mb.Balls.add(new Ball(320,200,1,1,Color.BLUE));
          mb.Balls.add(new Ball(400,100,1,1,Color.YELLOW));
          
         
          

        
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        
        
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        
       
        
    }
    
}
