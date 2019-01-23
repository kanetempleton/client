/*
    Abstract class representing a client state

    State is rendered by main graphics loop of GameClient
    
    Each state should serve a fundamentally different purpose

    Written by Kane Templeton Jan 8, 2019
 */

package client.game.state;

import client.Main;
import client.game.gfx.Button;
import client.game.gfx.ButtonHandler;
import java.awt.Graphics;


public abstract class ClientState {
    
    public String buildText[],lastText[];
    public boolean listeningForText;
    
    private int textField;
    protected int absState;
    
    
    
    public ClientState() {
        //initialize dynamic text fields
        buildText = new String[2];
        for (int i=0; i<buildText.length; i++)
            buildText[i]="";
        lastText = new String[2];
        for (int i=0; i<lastText.length; i++)
            lastText[i]="";
        
        listeningForText=false;
        textField=0;
        absState=0;
    }
    
    /* render(g):
        render the details of the state (abstract method)
        plus all visible buttons.
    
    */
    public void render(Graphics g) {
        renderDetails(g);
        for (int i=0; i<ButtonHandler.numButtons; i++) {
            Button b = Main.gameClient.buttonHandler.button[i];
            if (b==null)
                return;
            if (b.visible()) {
                b.render(g);
            }
            
        }
    }
    
    /* renderDetails(g):
        render the specific details of this client state
    
        since a state will always be being rendered by the main client loop,
        all of the details of a specific rendering can be placed
        inside of this method
    
    */
    public abstract void renderDetails(Graphics g);
    
    
    /* load():
        specific initializations of the state
    
        as of now, just have specific buttons to activate
    
    */
    public void load() {
        //init();
        activateButtons();
        
    }
    
    
    /* activateButtons():
        calls the show() method of any buttons that need to be visible
        when this state launches
    
    */
    private void activateButtons() {
        for (int i=0; i<buttons_to_activate().length; i++)
            Main.gameClient.buttonHandler.button[buttons_to_activate()[i]].show();
    }
    
    /* show(b), hide(b):
        calls the show() and hide() methods of button specified by ID=b
    
    */
    public void show(int b) {
        Main.gameClient.buttonHandler.button[b].show();
    }
    public void hide(int b) {
        Main.gameClient.buttonHandler.button[b].hide();
    }
    
    /* 
    buttons_to_activate():
    returns an array of button IDs to enable when the client state is loaded.
    use static IDs from ButtonHandler to create this array.
    first add buttons to ButtonHandler. 
    instructions on how to do this are near the top of ButtonHandler.java
    */
    public abstract int[] buttons_to_activate();
    
    
    /** appendToText(x,tField)
     * append a string of text to the end of a dynamic text field.
     * this is called in KeyManager to append
     * single characters as they are typed.
     * 
     * @param x: the string to append to the text field
     * @param tField: id of text field to append the string to
    
    */
    public void appendToText(String x, int tField) {
        
        if ((absState==3 && buildText[tField].length()<12)
                ||absState!=3) {

            buildText[tField]+=x;
            lastText[tField]=x;

        }
    }
    
    /** delete(tField):
     * remove one character from the end of the text stored in
     * the text field identified by ID=tField
    */
    public void delete(int tField) {
        if (buildText[tField].length()>1)
            buildText[tField]=buildText[tField].substring(0, buildText[tField].length()-1);
        else if (buildText[tField].length()==1)
            clear(tField);
    }
    
    /* clear(tField):
        remove all characters from specified text field
    */
    public void clear(int tField) {
        buildText[tField]="";
    }
    
    /* switchTextField(field):
        switch the actively listening text field
        to be the one defined by ID=field
    
    */
    public void switchTextField(int field) {
        if (absState==2) //tell the client we are typing the password now
            absState=3;
        if (absState==3) //tell the client we are typing the username now
            absState=2;
        
        textField=field;
    }
    
    /* currentTextField():
        returns the ID of the text field that is actively listening for text
        
        for Login:
            0 = typing username
            1 = typing password
    
    */
    public int currentTextField() {return textField;}

    


}

/*

    absState states:
*   0: initial state
*   1: clicked initial login button to enter user and password
*   2: typing username
*   3: typing password
*
*/
