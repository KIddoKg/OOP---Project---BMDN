/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seflgame;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.GameScreen;
import pkg2dgamesframework.Objects;

/**
 *
 * @author ASUS
 */
class button extends Objects implements MouseListener{
    private BufferedImage but;
    private int scale;
    public button(int x, int y, int w, int h){
        super(x,y,w,h);
        scale = 0;
        addMouseListener(this);
        try {
            but = ImageIO.read(new File("Assets/play.png"));
                    
                    } catch (IOException ex) {
        }
        
    }
    public void paint_button(Graphics2D g2){
        g2.drawImage(but, (int)this.getPosX()-scale , (int)this.getPosY()-scale,(int)but.getWidth()+scale*4, (int)but.getHeight()+scale*2, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Clicked Start");
        scale =0;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        scale = 10;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
