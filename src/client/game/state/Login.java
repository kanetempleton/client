/*
    Login.java
    
    This is the login client state, which is the state the client enters on startup.
    Enter login credentials and click "Log in" to issue login request to server

    Written by Kane Templeton Jan 8, 2019
 */

package client.game.state;

import client.Main;
import client.game.gfx.ButtonHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Kane
 * 
 */
public class Login extends ClientState {
    
    public int state;
    /*state:
    0: initial state (nothing)
    1: main menu (click to enter)
    2: enter login credentials
    3: loading please wait
    4: invalid username/password
    5: login accepted (delete this maybe)
    */
    
    public Login() {
        state=0;
        absState=1;
    }
    
    public void renderDetails(Graphics g) {
        if (state==1 || state==4) {
            g.setColor(Color.red);
            Font F = new Font(Font.SERIF,2,24);
            g.setFont(F);
            if (state==4)
                g.drawString("Invalid username/password. Please try again.", 50, 50);
            else
                g.drawString("Please enter username and password.", 50, 50);
            if (Main.gameClient.state.buildText[0].length()>0) //render username as it is typed
                g.drawString(Main.gameClient.state.buildText[0], 50, 80); 
            if (Main.gameClient.state.buildText[1].length()>0) { //render password as it is typed
                String x = "";
                for (int i=0; i<Main.gameClient.state.buildText[1].length(); i++)
                    x+="*";
                g.drawString(x, 50, 110);
            }

        }
        if (state==3) {
            g.setColor(Color.cyan);
            g.drawString("LOADING! Please wait...", 100, 250);
        }
        //g.setColor(Color.red);
        //g.drawRect(20, 30, 60, 50);
        //NIOClient.gameClient.buttonHandler.button[0].render(g);
    }

    
    public int[] buttons_to_activate() {
        return new int[] {ButtonHandler.LOGIN};
    }
    
    /*
    enterLoginCredentials():
    called when clicking "enter" button on main screen
    switches to interface to type user and password
    *//** 
     * @param rejected: 
     * true if the client has issued a login request 
     * and received an "invalid username/password" response
     * 
    */
    public void enterLoginCredentials(boolean rejected) {
        absState=2;
        state=1;
        if (rejected)
            state=4;
        listeningForText=true;
        hide(ButtonHandler.LOGIN);
        show(ButtonHandler.LOGIN_ENTER);
        show(ButtonHandler.LOGIN_CANCEL);
        
    }
    
    /*
    returnToMain():
    called when clicking "cancel" instead of "log in" when prompted to type user&pass
    returns to the main menu
    */
    
    public void returnToMain() {
        absState=1;
        state=0;
        listeningForText=false;
        show(ButtonHandler.LOGIN);
        hide(ButtonHandler.LOGIN_ENTER);
        hide(ButtonHandler.LOGIN_CANCEL);
        Main.gameClient.state.clear(1); //clear password field
    }
    
    /*
    loading():
    called when clicking "log in" after inputting user and password for a login request
    renders a 'loading please wait' screen while it waits for server to respond
    */
    public void loading() {
        state=3;
        listeningForText=false;
        hide(ButtonHandler.LOGIN_ENTER);
        hide(ButtonHandler.LOGIN_CANCEL);
        Main.gameClient.state.clear(1); //clear password and username fields
        Main.gameClient.state.clear(0);
        Main.gameClient.state.switchTextField(0); //change active text field to be the username field
        
    }
    
    public void invalidLogin() {
        enterLoginCredentials(true);
    }
    
    public void acceptLogin() {
        System.out.println("load game state.");
        Main.gameClient.activateGameState();
    }

}
