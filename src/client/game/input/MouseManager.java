/*
    Handle user mouse input

    I have not yet experimented with all methods of this class.
    I think I found a template for this by googling stuff one time.
    It was quite a while ago. But I don't take much credit for this.

    Written by Kane Templeton Jan 21, 2019 (i deleted this file at some point so this date is wrong)
 */

package client.game.input;

import client.Main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener  {
    
    public MouseManager() {
        
    }
    
    //mouse stuff
    private static int mouseX = -1;
    private static int mouseY = -1;
    public static int mouseDragX = -1;
    public static int mouseDragY = -1;
    public static int mousePressX = -1;
    public static int mousePressY = -1;
    public static int mouseB = -1;
    private static int mouseClick = -1;
    public static boolean dragged = false;
    private static int mouseClickX = -1;
    private static int mouseClickY = -1;
   

    /* mousePressed(): 
        initial click of a mouse in a held mouse click
        use this for typical click actions
    */
    
    @Override
    public void mousePressed(MouseEvent me) { 

        mouseX = me.getX();
        mouseY = me.getY();
        mousePressX = me.getX();
        mousePressY = me.getY();
        mouseB = me.getButton();
        //System.out.println("Mouse clicked at: "+mouseClickX+","+mouseClickY);
        System.out.println("Mouse clicked at: "+mouseX+","+mouseY);
        Main.gameClient.buttonHandler.click(mouseX, mouseY);
        shown = false;
    } //wtf why was i not using this for clicks the entire time
    
       
    /*
     * mouseClicked: a typical click action
    * EDIT NO THIS IS TRASH NEVER USE THIS SHIT METHOD
    * re-edit: this is trash because only some of the clicks will register
    */
    @Override
    public void mouseClicked(MouseEvent me) {
       // System.out.
        mouseClick = me.getClickCount();
        mouseClickX = me.getX();
        mouseClickY = me.getY();
        //System.out.println("Mouse clicked at: "+mouseClickX+","+mouseClickY);
        //Main.gameClient.buttonHandler.click(mouseX, mouseY);
        //Game.getGameButtons().listen(mouseX, mouseY);
        //Game.getGameMenu().handleClicks(mouseClickX, mouseClickY);
    }
    
    private boolean shown = true;

 
    /*
     * mousereleased: releasing a held mouse click
    */
    @Override
    public void mouseReleased(MouseEvent me) {
        mouseB = -1;
        dragged = false;
    }
 
    
    /*
     * mouseEntered: mouse enters frame
    */
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    
 
    /*
     * mouseExited: mouse exits frame
    */
    @Override
    public void mouseExited(MouseEvent me) {
    }
 
    @Override
    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
        mouseDragX = me.getX();
        mouseDragY = me.getY();
        dragged = true;
       
    }
 
    @Override
    public void mouseMoved(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
       
    }
    
    // mouse button that was clicked
    public int mouseClicked() {
        return mouseClick;
    }
    
    public int getX() {
        return mouseX;
    }
   
    public int getY() {
        return mouseY;
    }
 
    public int getButton() {
        return mouseB;
    }

}
