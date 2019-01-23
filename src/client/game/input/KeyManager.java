/*
    Handle user keyboard input
    initially recycled from old single player 2d game i made

    Written by Kane Templeton Nov 7, 2015
 */

package client.game.input;

import client.Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//to be honest, i am unsure if i should run this as a thread or not

public class KeyManager implements KeyListener, Runnable {
    
    private boolean[] keys;
    
    protected boolean up,down,left,right;
    protected boolean a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,space,enter;
    protected boolean zero,one,two,three,four,five,six,seven,eight,nine;
    
    protected boolean apostrophe,dash,equals;
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
   
    @Override
    public void keyTyped(KeyEvent e) {
      //  keys[e.getKeyCode()] = true;
    }

    /* keyPressed(e):
        called when a key is initially pressed by user.
        doesn't cause a ton of repeat actions like keyTyped
        aka it's perfect for text listening
    
    */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        //System.out.println(e.getKeyCode());
        //processKeys();
        processKey(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    /* run():
        called when this thread is started.
        constantly listens for which keys are pressed,
        transfers keys pressed to boolean variables
        so that they can be checked by other classes
    
    */
    @Override
    public void run() {
        while (true) {
            up = keys[KeyEvent.VK_UP];
            down = keys[KeyEvent.VK_DOWN];
            left = keys[KeyEvent.VK_LEFT];
            right = keys[KeyEvent.VK_RIGHT];
            
            zero = keys[KeyEvent.VK_0];
            one = keys[KeyEvent.VK_1];
            two = keys[KeyEvent.VK_2];
            three = keys[KeyEvent.VK_3];
            four = keys[KeyEvent.VK_4];
            five = keys[KeyEvent.VK_5];
            six = keys[KeyEvent.VK_6];
            seven = keys[KeyEvent.VK_7];
            eight = keys[KeyEvent.VK_8];
            nine = keys[KeyEvent.VK_9];
            
            apostrophe = keys[KeyEvent.VK_QUOTE];
            dash = keys[KeyEvent.VK_MINUS];
            equals = keys[KeyEvent.VK_EQUALS];

            a = keys[KeyEvent.VK_A];
            b = keys[KeyEvent.VK_B];
            c = keys[KeyEvent.VK_C];
            d = keys[KeyEvent.VK_D];
            e = keys[KeyEvent.VK_E];
            f = keys[KeyEvent.VK_F];
            g = keys[KeyEvent.VK_G];
            h = keys[KeyEvent.VK_H];
            i = keys[KeyEvent.VK_I];
            j = keys[KeyEvent.VK_J];
            k = keys[KeyEvent.VK_K];
            l = keys[KeyEvent.VK_L];
            m = keys[KeyEvent.VK_M];
            n = keys[KeyEvent.VK_N];
            o = keys[KeyEvent.VK_O];
            p = keys[KeyEvent.VK_P];
            q = keys[KeyEvent.VK_Q];
            r = keys[KeyEvent.VK_R];
            s = keys[KeyEvent.VK_S];
            t = keys[KeyEvent.VK_T];
            u = keys[KeyEvent.VK_U];
            v = keys[KeyEvent.VK_V];
            w = keys[KeyEvent.VK_W];
            x = keys[KeyEvent.VK_X];
            y = keys[KeyEvent.VK_Y];
            z = keys[KeyEvent.VK_Z];
            space = keys[KeyEvent.VK_SPACE];
            enter = keys[KeyEvent.VK_ENTER];
            
        }
    }
    
    
    
    /* processKey(key):
        trigger action based on key pressed
        this will mostly be appending chars to text fields
    
    */
    
    public void processKey(int key) {
        int field = Main.gameClient.state.currentTextField();
        switch (key) {
            case KeyEvent.VK_ENTER:
                //Main.gameClient.state.printOutText(0);
                Main.gameClient.state.switchTextField(1-field);
                break;
            case KeyEvent.VK_A:
                Main.gameClient.state.appendToText("a",field);
                break;
            case KeyEvent.VK_B:
                Main.gameClient.state.appendToText("b",field);
                break;
            case KeyEvent.VK_C:
                Main.gameClient.state.appendToText("c",field);
                break;
            case KeyEvent.VK_D:
                Main.gameClient.state.appendToText("d",field);
                break;
            case KeyEvent.VK_E:
                Main.gameClient.state.appendToText("e",field);
                break;
            case KeyEvent.VK_F:
                Main.gameClient.state.appendToText("f",field);
                break;
            case KeyEvent.VK_G:
                Main.gameClient.state.appendToText("g",field);
                break;
            case KeyEvent.VK_H:
                Main.gameClient.state.appendToText("h",field);
                break;
            case KeyEvent.VK_I:
                Main.gameClient.state.appendToText("i",field);
                break;
            case KeyEvent.VK_J:
                Main.gameClient.state.appendToText("j",field);
                break;
            case KeyEvent.VK_K:
                Main.gameClient.state.appendToText("k",field);
                break;
            case KeyEvent.VK_L:
                Main.gameClient.state.appendToText("l",field);
                break;
            case KeyEvent.VK_M:
                Main.gameClient.state.appendToText("m",field);
                break;
            case KeyEvent.VK_N:
                Main.gameClient.state.appendToText("n",field);
                break;
            case KeyEvent.VK_O:
                Main.gameClient.state.appendToText("o",field);
                break;
            case KeyEvent.VK_P:
                Main.gameClient.state.appendToText("p",field);
                break;
            case KeyEvent.VK_Q:
                Main.gameClient.state.appendToText("q",field);
                break;
            case KeyEvent.VK_R:
                Main.gameClient.state.appendToText("r",field);
                break;
            case KeyEvent.VK_S:
                Main.gameClient.state.appendToText("s",field);
                break;
            case KeyEvent.VK_T:
                Main.gameClient.state.appendToText("t",field);
                break;
            case KeyEvent.VK_U:
                Main.gameClient.state.appendToText("u",field);
                break;
            case KeyEvent.VK_V:
                Main.gameClient.state.appendToText("v",field);
                break;
            case KeyEvent.VK_W:
                Main.gameClient.state.appendToText("w",field);
                break;
            case KeyEvent.VK_X:
                Main.gameClient.state.appendToText("x",field);
                break;
            case KeyEvent.VK_Y:
                Main.gameClient.state.appendToText("y",field);
                break;
            case KeyEvent.VK_Z:
                Main.gameClient.state.appendToText("z",field);
                break;
            case KeyEvent.VK_0:
                Main.gameClient.state.appendToText("0", field);
                break;
            case KeyEvent.VK_1:
                Main.gameClient.state.appendToText("1", field);
                break;
            case KeyEvent.VK_2:
                Main.gameClient.state.appendToText("2", field);
                break;
            case KeyEvent.VK_3:
                Main.gameClient.state.appendToText("3", field);
                break;
            case KeyEvent.VK_4:
                Main.gameClient.state.appendToText("4", field);
                break;
            case KeyEvent.VK_5:
                Main.gameClient.state.appendToText("5", field);
                break;
            case KeyEvent.VK_6:
                Main.gameClient.state.appendToText("6", field);
                break;
            case KeyEvent.VK_7:
                Main.gameClient.state.appendToText("7", field);
                break;
            case KeyEvent.VK_8:
                Main.gameClient.state.appendToText("8", field);
                break;
            case KeyEvent.VK_9:
                Main.gameClient.state.appendToText("9", field);
                break;
            case KeyEvent.VK_SPACE:
                Main.gameClient.state.appendToText(" ",field);
                break;
            case KeyEvent.VK_QUOTE:
                Main.gameClient.state.appendToText("'",field);
                break;
            case KeyEvent.VK_MINUS:
                Main.gameClient.state.appendToText("-", field);
                break;
            case KeyEvent.VK_EQUALS:
                Main.gameClient.state.appendToText("=", field);
                break;
            case KeyEvent.VK_DELETE:
            case KeyEvent.VK_BACK_SPACE:
                Main.gameClient.state.delete(field);
                break;
                
                    
        }
    }
    
    //i don't need this yet but it might be useful some time
    private boolean alphabet[] = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
    
    

}
