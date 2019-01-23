/*
    This class is the thread that runs the GUI
    
    Handles the user-interactive portion of the game

    Written by Kane Templeton Jan 7, 2019
 */

package client.game;

import client.game.gfx.Assets;
import client.game.gfx.ButtonHandler;
import client.game.input.KeyManager;
import client.game.input.MouseManager;
import client.game.state.ClientState;
import client.game.state.Game;
import client.game.state.Login;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class GameClient extends JPanel implements Runnable {
    
    public Display display;
    private BufferStrategy bs;
    private Graphics g;
    public KeyManager keyManager;
    public MouseManager mouseManager;
    public ButtonHandler buttonHandler;
    
    public ClientState state;
    
    private String title;
    private int width,height;
    
    
    public boolean running;
    
    
    public GameClient(String t, int w, int h) {
        title=t;
        width=w;
        height=h;
        //running=true;
    }
    
    /* init():
        initializes GameClient resources
        (assets, key/mouse manager, display,
        button handler, client state)
    
    */
    public void init() {
        
        //init assets
        try {
            Assets.init();
        } catch (IOException ex) {
            Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        keyManager = new KeyManager();
        
        new Thread(keyManager).start();
        //mouseManager = new MouseManager();
        //new Thread(mouseManager).start();
        buttonHandler = new ButtonHandler();
        buttonHandler.initButtons();
        
        //render();
        
        display = new Display(title,width,height);
        display.createDisplay();
        //display.setVisible(false);
       // display.createLoadingPopup();
        //new Thread(display).start();
        
        display.getFrame().addKeyListener(keyManager);
        mouseManager = new MouseManager();
        display.getCanvas().addMouseListener(mouseManager);
        running=true;
        state = new Login();
        state.load();
        
        run();
        
    }
    
    /*run():
    main ticking method for game client
    called when this thread is started but doesn't do anything
    called again after client resources are initialized
    */
    public void run() {
        while (running) {
            render();
        }
    }
    
    /* activateGameState():
        sets the client state to be the Game state
    */
    public void activateGameState() {
        state = new Game();
        state.load();
    }
    
    /* activateLoginState():
        sets the client state to be the Login state
    */
    public void activateLoginState() {
        state = new Login();
        state.load();
    }
    
    private boolean didit=false;
    
    /* render():
        main graphics rendering loop.
        calls other graphic rendering methods
    */
    public void render() {
        
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        
        //color the background black
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);
 
        //for some reason, the first call to g.drawString causes the entire client to stall
        //so this loop makes drawString call before the client is rendered to the screen
        if (!didit) { 
            didit=true;
            System.out.println("Loading client graphics...");
            g.drawString("", 3, 40);//this needs to draw to load correctly
            System.out.println("... client graphics initialized!");
            display.setVisible(true);
           // display.setVisible(1,false);
            //System.out.println("passed the part");
        } //TODO: figure out why this happens
        
        
         // add detail graphic rendering methods here

        state.render(g); //render current client state

        // End drawing
        
        bs.show();
        g.dispose();

    }
    
    
    //these are methods from codenmore's game tutorial on youtube
    //i copied them below in case i need them for future use
    
    //private Thread thread;
    
    /* 
    public synchronized void start() {
        
        System.out.println("synchr void");
        
        if (running)
            return;
        init();
        running = true;
        thread = new Thread(this);
        thread.start();
        //run();
        
    }
    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        
        try {
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
  */

}
