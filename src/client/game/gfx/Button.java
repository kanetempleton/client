/*
    a button for client interfaces

    Written by Kane Templeton Jan 12, 2019
 */

package client.game.gfx;

import client.Main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Button {
    
    private int button_id;
    protected int start_x,start_y;
    
    private BufferedImage image;
    
    protected boolean visible;
    
    
    public Button(int id, BufferedImage img) {
        this.button_id = id;
        this.start_x=-1;
        this.start_y=-1;
        this.image=img;
        this.visible=false;
    }
    
    
    
    /* hide():
        makes this button invisible to the client.
        the button will still exist in ButtonHandler,
        and can be re-activated at any time using show()
    
        de-activated (invisible) buttons do not react to clicks
    
    */
    public void hide() {
        this.visible=false;
        if (Main.gameClient.buttonHandler.visibleButtons.contains(button_id))
            Main.gameClient.buttonHandler.visibleButtons.remove((Integer)button_id);
    }
    /* show():
        activate this button and make it visible to the client
    */
    public void show() {
        this.visible=true;
        if (!Main.gameClient.buttonHandler.visibleButtons.contains(button_id))
            Main.gameClient.buttonHandler.visibleButtons.add((Integer)button_id);
    }
    
    /* render(g):
        draw the image for this button to the client
        must initialize the button's image in ButtonHandler before calling this
    */
    public void render(Graphics g) {
        g.drawImage(image, start_x, start_y, null);
    }

    public BufferedImage getImage() {
        return image;
    }
    public int getID() {return button_id;}
    public int getX() {return start_x;}
    public int getY() {return start_y;}
    public int getWidth() {return getImage().getWidth();}
    public int getHeight() {return getImage().getHeight();}
    public boolean visible() {return visible;}
    
    
    
    
    

}
