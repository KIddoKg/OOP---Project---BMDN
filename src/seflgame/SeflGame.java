/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seflgame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import pkg2dgamesframework.GameScreen;
/**
 *
 * @author ASUS
 */
public class SeflGame extends GameScreen{

    private static int WIDTH = 3800;
    private static int HEIGHT = 2100;
    Random generator = new Random(19900828);
    
    private backGround BG;
    private character cha;
    private enemy ene[];
    private enemy2 ene2[];
    private enemy3 ene3[];
    private HP hp;
    private boolean is_lose;
    public start start_game;
    
    public SeflGame() { 
        super(3800,2100);
        //start_game = new start();
        is_lose = false;
        BG = new backGround();
        cha = new character(500,500);
        ene = new enemy[5];
        ene2 = new enemy2[5];
        ene3 = new enemy3[5];
        hp = new HP(0,0);
        for(int i = 0;i<3;i++)
        {
            int value_y = generator.nextInt(1150) + 60;
            int value_x = generator.nextInt(5000);
            ene[i] = new enemy(3800 + value_x, value_y);
        }
        for(int i = 0;i<3;i++)
        {
            int value_y = generator.nextInt(1150) + 60;
            int value_x = generator.nextInt(5000);
            ene2[i] = new enemy2(3800 + value_x, value_y);
        }
        for(int i = 0;i<3;i++)
        {
            int value_y = generator.nextInt(1150) + 60;
            int value_x = generator.nextInt(5000);
            ene3[i] = new enemy3(3800 + value_x, value_y);
        }
        BeginGame();
    }
    public static void main(String[] args) {
        new SeflGame();
    }

    @Override
    public void GAME_UPDATE(long deltaTime) {
        cha.update_among(deltaTime);
        for(int i = 0;i<3;i++)
        {
            int value_y = generator.nextInt(1150) + 60;
            int value_x = generator.nextInt(1000);
            ene[i].update_enemy(deltaTime);
            if(cha.is_knife())
            {
                if(cha.CollisionHappenWith((int)ene[i].getx() - 200, (int)ene[i].gety(), (int)ene[i].getW(), (int)ene[i].getH()))
                {
                    ene[i].is_dead();
                    //System.out.println("enemy dead");
                    ene[i] = new enemy(3800 + value_x, value_y);
                }
            }
            if(cha.CollisionHappenWith((int)ene[i].getx(), (int)ene[i].gety(), (int)ene[i].getW(), (int)ene[i].getH()))
            {
                cha.decreaseHP(1);
                System.out.print(cha.get_HP());
                ene[i] = new enemy(3800 + value_x, value_y);
            }
            if(ene[i].end_map() == true)
            {
                //System.out.println("enemy leave");
                ene[i] = new enemy(3800 + value_x, value_y);
            }
        }
        for(int i = 0;i<3;i++)
        {
            int value_y = generator.nextInt(1150) + 60;
            int value_x = generator.nextInt(1000);
            ene2[i].update_enemy(deltaTime);
            if(cha.is_knife())
            {
                if(cha.CollisionHappenWith((int)ene2[i].getx() - 200, (int)ene2[i].gety(), (int)ene2[i].getW(), (int)ene2[i].getH()))
                {
                    ene2[i].is_dead();
                    //System.out.println("enemy dead");
                    ene2[i] = new enemy2(3800 + value_x, value_y);
                }
            }
            if(cha.CollisionHappenWith((int)ene2[i].getx(), (int)ene2[i].gety(), (int)ene2[i].getW(), (int)ene2[i].getH()))
            {
                //System.out.println("yo0u dead");
                cha.decreaseHP(1);
                ene2[i] = new enemy2(3800 + value_x, value_y);
            }
            if(ene2[i].end_map() == true)
            {
                //System.out.println("enemy leave");
                ene2[i] = new enemy2(3800 + value_x, value_y);
            }
        }
        for(int i = 0;i<3;i++)
        {
            int value_y = generator.nextInt(1150) + 60;
            int value_x = generator.nextInt(1000);
            ene3[i].update_enemy(deltaTime);
            if(cha.is_knife())
            {
                if(cha.CollisionHappenWith((int)ene3[i].getx() - 200, (int)ene3[i].gety(), (int)ene3[i].getW(), (int)ene3[i].getH()))
                {
                    ene3[i].is_dead();
                    //System.out.println("enemy dead");
                    ene3[i] = new enemy3(3800 + value_x, value_y);
                }
            }
            if(cha.CollisionHappenWith((int)ene3[i].getx(), (int)ene3[i].gety(), (int)ene3[i].getW(), (int)ene3[i].getH()))
            {
                //System.out.println("yo0u dead");
                cha.decreaseHP(1);
                ene3[i] = new enemy3(3800 + value_x, value_y);
            }
            if(ene3[i].end_map() == true)
            {
                //System.out.println("enemy leave");
                ene3[i] = new enemy3(3800 + value_x, value_y);
            }
        }
    }
    @Override
    public void GAME_PAINT(Graphics2D g2) {
            BG.paint_among(g2);
            cha.paint_among(g2);
            for(int i = 0;i<3;i++)
            {
                ene[i].paint_enemy(g2);
            }
            for(int i = 0;i<3;i++)
            {
                ene2[i].paint_enemy(g2);
            }
            for(int i = 0;i<3;i++)
            {
                ene3[i].paint_enemy(g2);
            }
           hp.paint_among(g2,(int)cha.getPosX()+180,(int)cha.getPosY()+60,cha.get_HP());
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        cha.key_among(e, Event); 
    }
    
}
