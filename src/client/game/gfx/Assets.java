/*
    Loads images from files and processes sprite sheets

    Written by Kane Templeton Jan 12, 2019
 */

package client.game.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Assets {

    
    // ADD NEW IMAGES HERE
    public static BufferedImage loginButton,loginEnter,loginCancel,logout;
    
    
    public static void init() throws IOException {
        
      
        //INITIALIZE IMAGES HERE
        loginButton = ImageIO.read(new File("res/assets/buttons/"+ButtonHandler.LOGIN+".png"));
        loginEnter = ImageIO.read(new File("res/assets/buttons/"+ButtonHandler.LOGIN_ENTER+".png"));
        loginCancel = ImageIO.read(new File("res/assets/buttons/"+ButtonHandler.LOGIN_CANCEL+".png"));
        logout = ImageIO.read(new File("res/assets/buttons/"+ButtonHandler.LOGOUT+".png"));
        
        
    }

}
