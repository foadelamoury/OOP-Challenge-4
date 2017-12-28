/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;

/**
 *
 * @author ASUS
 */
public class Ball {
     public int x,y;
    public int speedx,speedy;
    public Color CurrentColor;
    public Ball(int x,int y,int speedx,int speedy,Color color)
    {
        this.x=x;
        this.y=y;
        this.speedx=speedx;
        this.speedy=speedy;
        this.CurrentColor=color;
    }
    public Ball()
    {
    x=0;
        y=0;
        speedx=10;
        speedy=10;
        CurrentColor=Color.GREEN;
    }
    public  void move(int width,int height)
    {
        x+=speedx;
        y+=speedy;
        if (x+50>width)
        {   
            speedx= -speedx;
        }
        if (x<0)
        {
            speedx= -speedx;
        }
        if(y+50>height){
            speedy=-speedy;
        }
        if(y<0){
            speedy=-speedy;
        }
    }
    
}
