/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable , MouseListener,MouseMotionListener{
   public JLabel DamagLabel=new JLabel("Damage");
   public ArrayList<Ball>Balls=new ArrayList<Ball>(9);
   public Tank BlueTank=new Tank("d:\\TankBlueS.jpg");
  

  

   
   public ArrayList<Bullet>rockets=new ArrayList<Bullet>(1);
 
  public int mx,my;
  public boolean isHit;
  public  int Damage=0;
 
  
    public MovingBalls()
    {   
        
        setSize(600,600);
        setBackground(Color.red);
       BlueTank.pos.x=220;
        BlueTank.pos.y=340;
        
        
        this.addKeyListener(new keylist());
        this.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mx=e.getX();
        my=e.getY();
        JOptionPane.showMessageDialog(null, "The Pos X = "+mx+" and Y = "+my);
       
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
       }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                
            }
            if(e.getKeyCode()==KeyEvent.VK_UP){
                BlueTank.moveL();
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                BlueTank.moveR();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {   
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read (new File(BlueTank.Rocket.imgPath));
        BufferedImage imgtankRight=ImageIO.read(new File("d:\\TankBlueS(FRight).jpg"));
        BufferedImage imgtankLeft=ImageIO.read(new File("d:\\TankBlueS(FLeft).jpg"));
        BufferedImage imgTankDown=ImageIO.read(new File("d:\\TankBlueS(FDown).jpg"));
        BufferedImage imgrocketRight = ImageIO.read (new File("D:\\TheRocketRight(finale)(E).png"));
         BufferedImage imgrocketDown = ImageIO.read (new File("D:\\TheRocketDown(finale)(E).png"));
          BufferedImage imgrocketLeft = ImageIO.read (new File("D:\\TheRocketLeft(finale)(E).png"));
   
        if(BlueTank.pos.x>0 && BlueTank.pos.x<583 && BlueTank.pos.y>319  ){
        g.drawImage(imgtank,BlueTank.pos.x ,BlueTank.pos.y,null);
         g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        }
        else if(BlueTank.pos.x>0 && BlueTank.pos.x<583 && BlueTank.pos.y<75 ){
            g.drawImage(imgTankDown,BlueTank.pos.x ,BlueTank.pos.y,null);
            g.drawImage(imgrocketDown, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        }
        else if(BlueTank.pos.x>0 && BlueTank.pos.x<235 && BlueTank.pos.y<320 && BlueTank.pos.y>75) {
            g.drawImage(imgtankRight,BlueTank.pos.x ,BlueTank.pos.y,null);
         g.drawImage(imgrocketRight, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);}
        else if (BlueTank.pos.x<583 && BlueTank.pos.x>235 &&BlueTank.pos.y<320 &&BlueTank.pos.y>75){
              g.drawImage(imgtankLeft,BlueTank.pos.x ,BlueTank.pos.y,null);
         g.drawImage(imgrocketLeft, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        }
        
           
        
        }
        
        
        
       
        
                
                      
                
                

        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls )
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
             
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
              
              
                break;
                
            }
          
             if(BlueTank.pos.distance(OneBall.x,OneBall.y)<=50){
                System.out.println("Tank Damaged" );
               
               Damage++;
                
               // JOptionPane.showMessageDialog(null, "Tank Destroyed");
               if(Damage==50)
                isHit=true;
               
             
                //System.exit(0);
              //  break;
            }
            
         
                  
             
        }
        
        
    }
    @Override
    public void run() {
    try
    { 
        
    while(true)
    {
       if (isHit){  JOptionPane.showMessageDialog(null, "The Tank is destroyed");
       JOptionPane.showMessageDialog(null,"You lose" );

           break;
     
       }
       if(Balls.isEmpty()){
           JOptionPane.showMessageDialog(null, "You Win");
           break;
       }
      // else{ 
               for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth(),this.getHeight());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
       
       
       //}
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
