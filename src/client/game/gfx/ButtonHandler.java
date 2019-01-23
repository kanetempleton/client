/*
    Handles all buttons on the client

    Written by Kane Templeton Jan 12, 2019
 */

package client.game.gfx;

import client.Main;
import client.Packet;
import client.game.state.Login;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ButtonHandler {
    
    public Button button[];
    
    public static int numButtons;
    public static final int MAX_BUTTONS = 200;
    
    public ArrayList<Integer> visibleButtons;
    
    public ButtonHandler() {
        numButtons = 0;
        button = new Button[MAX_BUTTONS];
        visibleButtons = new ArrayList<>();
    }
    
    /** HOWTO: Add new buttons.
    1. create image file for button. save in client/assets folder
    2. add image in Assets class (define and initialize)
    3. define static final int for the button in this class (defined above initButtons())
    4. use "put" method in the initButtons() methods of this class
    */
    
    
    //Name buttons here
    public static final int LOGIN = 0;
    public static final int LOGIN_ENTER = 1;
    public static final int LOGIN_CANCEL = 2;
    public static final int LOGOUT = 3;
    
    
    /** initButtons()
        creates all buttons that will be used throughout client session
        add all buttons here, even ones that won't be initially visible.
    
    */
    public void initButtons() {
        
        //login state buttons
        put(new Button(LOGIN,Assets.loginButton),350, 250);
        put(new Button(LOGIN_ENTER,Assets.loginEnter),250, 250);
        put(new Button(LOGIN_CANCEL,Assets.loginCancel),450, 250);
        
        //game state buttons
        put(new Button(LOGOUT,Assets.logout),700,0);
        
    }
    
    
    /** handleClick(buttonid):
     * called by click(x,y) when clicking within bounds of an active button,
     * then triggers the button's appropriate actions
     * 
     * @param buttonid: the ID of the button that was clicked. 
     * use static constants defined above for this argument
    
    
    */
    private void handleClick(int buttonid) {
        switch (buttonid) {
            case LOGIN: //enter your login credentials
                ((Login)Main.gameClient.state).enterLoginCredentials(false);
                break;
            case LOGIN_ENTER: //issue login request
                String usr = Main.gameClient.state.buildText[0];
                String pas = Main.gameClient.state.buildText[1];
                if (usr.length()>0&&pas.length()>0) {
                    Main.serverClient.outputHandler.sendMessage(Packet.LOGIN, usr+";;"+pas);
                    ((Login)Main.gameClient.state).loading();
                }
                break;
            case LOGIN_CANCEL: //return to main screen
                ((Login)Main.gameClient.state).returnToMain();
                break;
            case LOGOUT: //log out of game and return to main screen
                
                break;
        }
    }
    
    /** put(B,x,y):
     * place a button at specified coordinates on the GUI screen
     * use this method inside of the initButtons() method in this class
     * 
     * @param x: x-coordinate to place image's top-left corner
     * @param y: y-coordinate to place image's top-left corner
    
    */
    private void put(Button B, int x, int y) {
        if (ButtonHandler.numButtons>=ButtonHandler.MAX_BUTTONS) {
            System.out.println("[Button Handler] No space for any new buttons.");
            return;
        }
        //visibleButtons.add(numButtons);
        button[numButtons++]=B;
        B.start_x=x;
        B.start_y=y;
        B.visible=false;
    }
    
    
    /** click(x,y)
     * check a mouse click that happened at these coordinates
     * to see if it is within bounds of any active buttons.
     * if so, call the handleClick method on the clicked button.
     * 
     * @param x: x coordinate clicked on GUI
     * @param y: y coordinate clicked on GUI
    
    */
    public void click(int x, int y) {
        Iterator it = visibleButtons.iterator();
        while (it.hasNext()) {
            try {
                Button b = button[(int)it.next()];
                if (x>=b.getX() && x<=b.getX()+b.getWidth() && y>=b.getY() && y<=b.getY()+b.getHeight()) 
                    handleClick(b.getID());
            
            }
            catch (ConcurrentModificationException e) {
                break;
            } //TODO: figure out why this exception happens and come up with a better fix
            
        }
    }

    
    

}

