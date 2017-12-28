/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
  
    public Bullet Rocket=new Bullet();
    public int speed;
    
    public Tank (String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="d:\\TheRocket(Finale)(E).png";
//        Rocket.imgPath="D:\\TheRocketDown(finale)(E).png";
//        Rocket.imgPath="D:\\TheRocketLeft(finale)(E).png";
//        Rocket.imgPath="D:\\TheRocketRight(finale)(E).png";
     
     
      
    }

    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }
      void moveR(){
          this.pos.y+=speed;
      }
      void moveL(){
          this.pos.y-=speed;
      }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+43;//moving bullet
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
        
    }
   
    
}
