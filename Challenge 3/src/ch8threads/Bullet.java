/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Bullet implements Runnable{
    public Point pos=new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    public Bullet()
    {
        Speed=1;
    }
    public  void  move()
    {
        pos.y-=Speed;
    }
    public void moveD(){
        pos.y+=Speed;
    }
    public void moveR(){
        pos.x+=Speed;
    }
    public void moveL(){
        pos.x-=Speed;
    }

    @Override
    public void run() {
        if(pos.x>0 && pos.x<583 && pos.y>319){
        for (int i=0;i<600;i++)
        {
            
             
                 move();
                 
       
             
           
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }}
    }
          
            
        else   if (pos.x>0 && pos.x<583 && pos.y<75 ){
             for (int i=0;i<600;i++)
        {
            
            
                moveD();
       
             
           
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }}}
           else    if (pos.x>0 && pos.x<235 && pos.y<320 && pos.y>75) {
             for (int i=0;i<583;i++)
        {
            
    
              
                 moveR();
        
           
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }}}
               else  if  (pos.x<583 && pos.x>235 &&pos.y<320 &&pos.y>75 ){
             for (int i=0;i<583;i++)
        {
            
            
                 moveL();
       
             
           
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                
            }}}
            
        
        
    }
}
