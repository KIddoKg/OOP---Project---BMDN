/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seflgame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.Objects;

/**
 *
 * @author ASUS
 */
class backGround extends Objects{
    
    private BufferedImage background;
    
    public backGround(){
//        super(x, y, w, h);
        
        try {
            background = ImageIO.read(new File("Assets/background1.png"));
        } catch (IOException ex) {}
    }
    public int get_width(){
        return this.background.getWidth();
    }
    public int get_heigh(){
        return this.background.getHeight();
    }
    public void update_among(long deltaTime){
        
    }
    public void paint_among(Graphics2D g2){
        g2.drawImage(background, 0, 0, 3800, 2100, null);
    }
}
