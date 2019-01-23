/*
    Game.java

    The "Game" client state

    This is not even remotely developed.


    Written by Kane Templeton Jan 17, 2019
 */

package client.game.state;

import client.Main;
import client.game.gfx.ButtonHandler;
import java.awt.Color;
import java.awt.Graphics;

public class Game extends ClientState {
    
    public Game() {
        
    }

    @Override
    public void renderDetails(Graphics g) {
        g.setColor(Color.darkGray);
        g.drawRect(0, 0, 1000, 1000);
        g.setColor(Color.white);
        g.drawString("render gameplay here", 150, 250);
    }

    @Override
    public int[] buttons_to_activate() {
        return new int[]{ButtonHandler.LOGOUT};
    }
    
    /* logout():
        disconnect from game and return to the login state.
    
    */
    public void logout() {
        Main.gameClient.activateLoginState();
        
    }

}
