// Main.java
// This is my first attempt at socket programming in Java
// I'm pretty much just copying an online skeleton and taking it from there
// I'll save this as an outline for future server usage
// And from what I understand... Java sockets are TCP by default. So that's cool
// - Kane


package client;

import client.game.GameClient;


public class Main  {
    
   
    public static GameClient gameClient;
    public static NIOClient serverClient;
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public static final boolean INIT_GRAPHICS = true;
    public static final boolean INIT_SERVER = true;

    public static void main(String[] args) {
        
        //initialize GUI thread    
        if (INIT_GRAPHICS) {
            gameClient = new GameClient("Game Test",WIDTH,HEIGHT);
            new Thread(gameClient).start();
        }
        
        //initialize server connection thread
        if (INIT_SERVER) {
            serverClient = new NIOClient();
            new Thread(serverClient).start();
        }
        
        //load the game client
        if (INIT_GRAPHICS)
            gameClient.init();

                
    }
    

    
}
