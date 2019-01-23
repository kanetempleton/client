/*
    Sends outgoing packets to the server
    Initializes with a SocketChannel to send all future packets through
   
    Written by Kane Templeton Jan 21, 2019
 */

package client;

import java.nio.channels.SocketChannel;

public class OutputHandler {
    
    private SocketChannel send;
    
    public OutputHandler(SocketChannel s) {
        send=s;
    }
    
    /* sendMessage(type,text)
        the most direct way to send a message to server
        creates packet referenced by sendPacket,
        then sends sendPacket on the next client iteration
        
        the main benefit of this is that you don't have to pass a SocketChannel argument
    */
    public void sendMessage(String type, String text) {
        Packet P = new Packet(type,text);
        Main.serverClient.packetHandler.sendPacket(P, send);
    }

}
