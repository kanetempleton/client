/*
    Handle incoming packets
    Written by Kane Templeton Dec 24, 2018
 */

package client;

import client.game.state.Login;
import client.util.Misc;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PacketHandler {
    
    
    public PacketHandler() {
        
    }
    
    public void handle(Packet P,SocketChannel s) {
        String words[] = P.getData().split(" ");
        int l = words[0].length();
        String data = P.getData().substring(l+1,P.getData().length()-1);
        String type = P.getType();
        print("Received: '"+data+"'");
        if (type.equals(Packet.LOGIN_ACCEPT)) {
            ((Login)Main.gameClient.state).acceptLogin();
        }
        else if (type.equals(Packet.LOGIN_REJECT)) {
            ((Login)Main.gameClient.state).invalidLogin();
        }
        else if (type.equalsIgnoreCase(Packet.POLL)) {
            System.out.println("pollstuff: "+words[0]+" "+words[1]+" "+Misc.arrayToString(words, 2));
            sendPacket(new Packet(Packet.POLL,words[1]+" "+response(Misc.arrayToString(words, 2))),s);
        }

    }
    
    public void print(String s) {
        System.out.println("[Packet Handler]"+s);
    }
    
 
    /** sendPacket(P,s):
     * sends a Packet object thru a SocketChannel
     * @param P: packet to send
     * @param s: SocketChannel to send P thru
    */
    public void sendPacket(Packet P, SocketChannel s) {
        //add client's server ID to packet text
       // if (!P.getData().split(" ")[0].equals(serverID)) {
       //     P.setData(serverID+" "+P.getData());
       // }
        P.setData(Main.serverClient.getID()+" "+P.getData());
        ByteBuffer bytebuf = ByteBuffer.wrap(P.toString().getBytes());
        print("Sending: "+P.toString());
        try {
            s.write(bytebuf);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //for polls ; match with server's response method
    private static String response(String msg) {
        if (msg.equalsIgnoreCase("ALIVE")) {
            return "HELLO";
        }
        return "REJECT";
    }

}
